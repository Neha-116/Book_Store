package com.torryharris.bookapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksPageController {

    @GetMapping("/Bird_Box")
    public String bird_Box(){
        return "Bird_Box";
    }

    @GetMapping("/marvel")
    public String marvel(){
        return "Marvel Adventures Super Heroes 1 Paul Tobin";
    }

    @GetMapping("/abdulKalam")
    public String abdulKalam(){
        return "Wings_of_fire_Paperback";
    }

    @GetMapping("/java")
    public String java(){
        return "Core Java Volume I--Fundamentals";
    }

    @GetMapping("/fis")
    public String fis(){
        return "The Fault in Our Stars";
    }

    @GetMapping("/harryPotter")
    public String harryPotter(){
        return "Harry Potter and the Deathly Hallows";
    }

    @GetMapping("/TechZone")
    public String TechZone(){
        return "TechZone";
    }

    @GetMapping("/EZ")
    public String EZ(){
        return "EZ";
    }

    @GetMapping("/Autobiographies")
    public String Autobiographies(){
        return "Autobiographies";
    }

}
