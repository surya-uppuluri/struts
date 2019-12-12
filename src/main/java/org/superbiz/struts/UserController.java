package org.superbiz.struts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUserForm";
    }


    @PostMapping("/addUser")
    public String addUserFormWithPOST(User user) {
        System.out.println("Received user: " + user.toString());
        userService.save(user);
        return "addedUser";
    }

    @GetMapping("/findUser")
    public String findUserForm() {
        return "findUserForm";
    }


    @PostMapping("/findUser")
    public String findAndReturnUser(long id, Model model) {
        System.out.println("Finding user with id " + id);

        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        return "displayUser";

    }


    @GetMapping("/list")
    public String listAllUsers(Model model) {

        List<User> usersList = userService.findAll();
        model.addAttribute("users", usersList);
        return "displayUsers";
    }

    @PostMapping("/listAllUsers")
    public String listAllUsersResponse(long id, Model model) {
        System.out.println("Finding user with id " + id);

        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        return "displayUsers";

    }

}
