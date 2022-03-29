package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public boolean existsByUserName(String username);
    public User findAllByUserName(String username);
    public User findByEmail(String email);

}
