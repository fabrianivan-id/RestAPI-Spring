package com.fabrianivan.manajemengaji.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    @Size(min = 3, max = 50)
    private String username;
    @Size(min = 8, max = 100)
    private String password;
    @ManyToOne
    @JoinColumn(name="id_role", nullable=false)
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions;
    @OneToMany(mappedBy = "user")
    private Set<Activity> activities;
}