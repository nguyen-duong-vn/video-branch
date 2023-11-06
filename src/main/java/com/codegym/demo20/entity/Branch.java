package com.codegym.demo20.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "BRANCH")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
    private List<Employee> employees;
}
