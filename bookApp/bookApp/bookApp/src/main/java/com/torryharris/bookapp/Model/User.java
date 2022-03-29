package com.torryharris.bookapp.Model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class User {
    @Id
    private int userUniqueId;
    private String userName;
    private String email,password;

}
