package org.example.workserver.controller;

import lombok.RequiredArgsConstructor;
import org.example.workserver.entity.User;
import org.example.workserver.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/lk")
    public String userProfilePage(Model model) {
        User authUser = userService.getCurrentAuthUser();

        model.addAttribute("user", authUser);
        return "user/userProfile";
    }


    @PostMapping("/transfer")
    public String transferFunds(String recipient, Double amount) {
      Long toUserId  =  userService.getUserIdByName(recipient);
      Long fromUserId = userService.getUserIdByName(userService.getCurrentAuthUser().getUsername());

      userService.transferMoney(fromUserId, toUserId, amount);
      return "redirect:/lk";
    }

    //



}
