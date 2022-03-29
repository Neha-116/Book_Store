package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Cart;
import org.springframework.ui.Model;

import java.util.List;

public interface CartService {
    public List<Cart> cartList();
    public String addToCart(int bookCode, Model model, Cart cart, int quantity);
    //public String emptyCart();
    }
