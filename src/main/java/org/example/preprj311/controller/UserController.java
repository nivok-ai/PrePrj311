package org.example.preprj311.controller;

import org.example.preprj311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.preprj311.model.User;



@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:users";
    }

    @GetMapping()
    public String listOfUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User userUpdated) {
        userService.updateUser(userUpdated);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
