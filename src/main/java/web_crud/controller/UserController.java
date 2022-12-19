package web_crud.controller;


import web_crud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web_crud.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/users")
    public String indexPage(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "all_users";
    }

    @GetMapping("/new_user")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("/new_user")
    public String newUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String updateUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id).get());
        return "update_user";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }


    @PostMapping(value = "/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = {"/users/", "/"})
    public String redirect() {
        return "redirect:/users";
    }
}