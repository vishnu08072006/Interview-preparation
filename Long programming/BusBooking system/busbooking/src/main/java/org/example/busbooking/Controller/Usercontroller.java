package org.example.busbooking.Controller;

import org.example.busbooking.Entity.User;
import org.example.busbooking.Service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class Usercontroller {

    @Autowired
    private Userservice service;

    @PostMapping("/add")
    public User adduser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getusers() {
        return service.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}