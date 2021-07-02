package project.guilherme.controller;

import project.guilherme.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.guilherme.repository.UserRepository;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")
    @ResponseBody
    public Iterable<UserModel> getUsers() {

        return this.userRepository.findAll();
    }
}
