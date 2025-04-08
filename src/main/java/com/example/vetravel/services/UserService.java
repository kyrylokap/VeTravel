package com.example.vetravel.services;
import com.example.vetravel.models.User;
import com.example.vetravel.repository.UserRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService{
    private final UserRepositoryDAO repository;

    @Autowired
    public UserService( UserRepositoryDAO repository) {
        this.repository = repository;
    }


    public boolean updatePassword(User user){
        System.out.println("Changed password from " + user.getPrevPassword() + " to " + user.getPassword());
        return repository.updatePassword(user.getUsername(),user.getPrevPassword(), user.getPassword()) > 1;
    }

    public User addUser(User user){
        return repository.save(user);
    }
    public User deleteUser(User user){
        repository.delete(user);
        return user;
    }
    public boolean existsById(User user){
        return repository.existsById(user.getId());
    }
    public List<User>showUsers(){
        return repository.findAll();
    }

    public User searchFirstByUsernameAndPassword(String username,String password){
        return repository.searchFirstByUsernameAndPassword(username, password);
    }

    public User searchFirstById(Long id){
        return repository.searchFirstById(id);
    }
}
