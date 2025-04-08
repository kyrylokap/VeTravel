package com.example.vetravel.controller;
import com.example.vetravel.models.Place;
import com.example.vetravel.models.User;
import com.example.vetravel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController{
    @Autowired
    UserService userService;

    @GetMapping("/info/change-password")
    public String changePassword(Model model){
        model.addAttribute("user",new User());
        return "change-password";
    }

    @PostMapping("/update-password")
    public String updatePassword(@ModelAttribute User user){
        if(!userService.updatePassword(user)){
            return "redirect:/info/change-password";
        }
        return "redirect:/info";
    }

    @GetMapping("/")
    public String mainPage(Model model,@ModelAttribute User user){
        model.addAttribute("user",user);
        System.out.print("/: ");
        System.out.println(user.toString());
        return "index";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/process-register")
    public String processRegister(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/process-login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password, RedirectAttributes redirectAttributes){
        User user = userService.searchFirstByUsernameAndPassword(username, password);
        if(user == null){
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute(user);
        System.out.print("/process-login: ");
        System.out.println(user.toString());
        return "redirect:/";
    }
    @GetMapping("/show-users")
    @ResponseBody
    public List<User>showUsers(){
        return userService.showUsers();
    }


    @PostMapping ("/info")
    public String infoPage(@ModelAttribute User user, Model model){
        System.out.print("/info: ");
        System.out.println(user.toString());
        model.addAttribute("user", user);
        return "info";
    }

}
