package com.user.Userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
}
