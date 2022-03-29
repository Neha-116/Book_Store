package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Constants.PropertyConstants;
import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserServiceImplementation userService;

    @GetMapping(PropertyConstants.LOGINPAGE)
    public String loginPage(){
        return "LoginPage";
    }

    @PostMapping(PropertyConstants.LOGIN)
    public String login(Model model, User user, Cart cart, HttpServletRequest request, RedirectAttributes redirectAttributes){
        return userService.userLogin(model,user,cart,request,redirectAttributes);
    }
    @GetMapping(PropertyConstants.REGISTRATIONPAGE)
    public String registrationPage(){
        return "RegistrationPage";
    }

    @PostMapping(PropertyConstants.REGISTER)
    public String addUser(User user){
        System.out.println("registration");
        System.out.println(user);
        return userService.userAdd(user);
    }

}
