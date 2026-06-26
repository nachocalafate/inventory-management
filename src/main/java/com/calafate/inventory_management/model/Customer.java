package com.calafate.inventory_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName; // nombre
    private String lastName;  // apellido
    private String dni;
    private String phone;
    private String email;
    private String address;
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;
}