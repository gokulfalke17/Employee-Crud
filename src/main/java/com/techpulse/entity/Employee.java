package com.techpulse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(length = 10)
    private String empName;

    @Column(length = 10)
    private Integer salary;

    @Column(unique = true)
    private String email;
    private String dept;
}
