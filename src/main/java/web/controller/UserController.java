package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/info";
    }

    @GetMapping("/new")
    public String getCreateUserPage(@ModelAttribute("user") User user) {
        return "/new";
    }


    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String getControlUsersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("users/edit/{id}")
    public String getEditUsersPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping("users/edit/{id}")
    public String saveEditUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}