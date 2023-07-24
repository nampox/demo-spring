package com.example.demosprinng.controller;

import com.example.demosprinng.entity.User;
import com.example.demosprinng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User userUpdate){
        return userService.update(userUpdate);
    }
}
