package com.ismailAkca.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_table")
@Data
public class User extends BaseEntity{
    @Id
    @SequenceGenerator(name="user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_seq_gen")
    @Column(name = "ID",unique = true)
    private Long id;
    @Column(unique = false,length = 100)
    private String firstName;
    @Column(unique = false,length = 99)
    private String lastName;
}
