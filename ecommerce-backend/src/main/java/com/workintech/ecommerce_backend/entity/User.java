package com.workintech.ecommerce_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;

}
