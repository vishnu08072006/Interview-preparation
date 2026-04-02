package org.example.busbooking.Service;

import org.example.busbooking.Entity.User;
import org.example.busbooking.Repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    private Userrepository repo;

    public User addUser(User user) {
        return repo.save(user);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public String deleteUser(int id) {
        repo.deleteById(id);
        return "User Deleted Successfully";
    }
}