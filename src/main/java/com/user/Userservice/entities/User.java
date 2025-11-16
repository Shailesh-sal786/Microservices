package com.user.Userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name="id")
    private String userId;

    @Column(name="NAME", length = 20)
    private String name;

    @Column(name ="Email")
    private String email;

    @Column(name = "About")
    private String about;

    @Transient
    private List<Rating> ratings=  new ArrayList<>();
}
