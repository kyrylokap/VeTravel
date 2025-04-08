package com.example.vetravel.controller;

import com.example.vetravel.models.Place;
import com.example.vetravel.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaceContoller {
    @Autowired
    PlaceService placeService;
    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/add-place")
    public String addPlace(Model model){
        model.addAttribute("place",new Place());
        return "add-place";
    }
    @PostMapping("/process-add")
    public String processAdd(@ModelAttribute Place place){
        placeService.addPlace(place);
        System.out.println("Successfully added place!");
        return "redirect:/add-place";
    }


}
