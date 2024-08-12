package com.workintech.ecommerce_backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stores", schema = "public")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "tax_no", nullable = false)
    private String taxNo;

    @Column(name = "bank_account", nullable = false)
    private String bankAccount;

    @JsonManagedReference
    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private User user;

}
