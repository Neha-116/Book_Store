package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.CartRepository;
import com.torryharris.bookapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookServiceImplementation bookServiceImplementation;
    @Autowired
    CartRepository cartRepository;

    public String username;
    Random random=new Random();

    public String userLogin(Model model, User user, Cart cart, HttpServletRequest request, RedirectAttributes redirectAttributes){
        username=request.getParameter("username");
        String password=request.getParameter("password");
        User user1= userRepository.findAllByUserName(username);
        System.out.println(user1+"login");
        // System.out.println(user1.getUserName());
        //System.out.println(username+password+user1.getUserName()+user1.getPassword());
        if(username.equals("admin") && password.equals("admin")){

            return bookServiceImplementation.adminTableDetails(model);
        }
        else if(userRepository.existsByUserName(username) && username.equals(user1.getUserName()) && password.equals(user1.getPassword())){
            System.out.println(user1.getUserName()+user1.getPassword());

            model.addAttribute("username",username);
            return "outlook.html";
        }
        else {
            redirectAttributes.addFlashAttribute("loginFailed", "Check your credentials and enter again");

            return "redirect:/loginPage";
        }
    }
    public String userAdd(User user){
        int userUniqueId=random.nextInt(10000000);
        System.out.println(userUniqueId);
        System.out.println(user+"user details");
        user.setUserUniqueId(userUniqueId);

        userRepository.save(user);

        return "LoginPage.html";
    }
}
