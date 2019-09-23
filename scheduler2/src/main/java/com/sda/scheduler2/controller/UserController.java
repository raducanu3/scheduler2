package com.sda.scheduler2.controller;

import com.sda.scheduler2.entity.User;
import com.sda.scheduler2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUser(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("userList", list);
        model.addAttribute("newUser", new User());
        return "userList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(ModelMap model, @RequestParam("UserID") Integer UserID) {

        userService.deleteUser(UserID);
        List<User> list = userService.getAllUsers();
        model.addAttribute("userList", list);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUserView(ModelMap model, @RequestParam("UserID") Integer UserID) {
        User userToBeUpdated = userService.getById(UserID);
        List<User> list = userService.getAllUsers();
        model.addAttribute("userList", list);
        model.addAttribute("newUser", userToBeUpdated);
        return "userList";
    }


    @PostMapping("/save")
    public String save(Model model, @ModelAttribute User newUser) {
        userService.save(newUser);
        return "redirect:/user/list";
    }

}
