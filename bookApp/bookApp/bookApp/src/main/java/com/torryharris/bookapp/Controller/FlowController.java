package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Constants.PropertyConstants;
import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Service.BookServiceImplementation;
import com.torryharris.bookapp.Service.CartServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class FlowController {

    @Autowired
    CartServiceImplementation cartService;
    @Autowired
    BookServiceImplementation bookServiceImplementation;

    @GetMapping("/landingPage")
    public String landingPage(){
        return "LandingPage";
    }

    @GetMapping(PropertyConstants.CART)
    public String cart(Model model){
        List<Cart> cartList=cartService.cartList();
        model.addAttribute("ListCart",cartList);
        return "Cart";
    }

    @RequestMapping(PropertyConstants.SHOPPINGTYPE)
    public String shopping(@PathVariable("bookCode") int bookCode, Model model, Cart cart, @RequestParam("Quantity") int quantity,@RequestParam("shopping") String shopping){
        if(Objects.equals(shopping, "addToCart")){
            return cartService.addToCart(bookCode,model,cart,quantity);
        }
        else{
            cartService.addToCart(bookCode,model,cart,quantity);
            return "redirect:/cart";
        }
    }

    @GetMapping(PropertyConstants.TERMSANDCONDITION)
    public String termsAndCondition(){
        return "TermsAndConditions";
    }

    @GetMapping(PropertyConstants.PAYMENT)
    public String payment(){
        //cartService.emptyCart()
        return "payment";
    }

    @GetMapping(PropertyConstants.RECEIPT)
    public String receipt(Model model){
        return cartService.receipt(model);
    }
    @GetMapping(PropertyConstants.CONFIRMATION)
    public String confirmation(){
        return "confirm";
    }

}
