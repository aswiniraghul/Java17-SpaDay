//package org.launchcode.controllers;
//
//import org.launchcode.models.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("user")
//public class UserController {
//
//    @GetMapping("/add")
//    public String displayAddUserForm() {
//        return "user/add";
//    }
//
//    @PostMapping
//    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        if (user.getPassword().equals(verify)) {
//            return "user/index";
//        }
//        else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
//
//    }
//
//
//}
package org.launchcode.controllers;


import jakarta.validation.Valid;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        if (!user.getPassword().equals(verify) || errors.hasErrors()) {
            if (!user.getPassword().equals(verify)) {
                model.addAttribute("verifyError", "Passwords do not match.");
            }
            return "user/add";
        }
        else {
            model.addAttribute("user", user);
            model.addAttribute("verify", verify);
            return "user/index";
        }
    }

//}
//    @PostMapping("")
//    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors) {
//        if (!errors.hasErrors()) {
//            return "user/index";
//        } else {
//            return "user/add";
//        }
//
//    }


}

