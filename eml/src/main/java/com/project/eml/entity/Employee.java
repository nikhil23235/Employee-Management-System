package com.project.eml.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "employeedb")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

@Column(name = "first_name ")
    private String firstName;
@Column(name = "last_name")
    private String lastName;
@Column(name = "email", nullable = false, unique = true)
    private String email;
}
