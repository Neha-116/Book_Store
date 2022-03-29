package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    public List<Cart> findAllByUser(User user);
    public void deleteCartByUser(User user);

}
