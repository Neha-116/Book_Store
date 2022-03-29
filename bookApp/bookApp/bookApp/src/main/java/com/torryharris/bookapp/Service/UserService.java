package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public String userLogin(Model model, User user, Cart cart, HttpServletRequest request, RedirectAttributes redirectAttributes);
    public String userAdd(User user);

    }
