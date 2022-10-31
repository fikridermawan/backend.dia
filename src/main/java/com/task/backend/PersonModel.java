package com.task.backend;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tab_fikri")
@Getter
@Setter
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int personId;
    @Column(name = "name")
    private String personName;
    @Column(name = "password")
    private String personPassword;
    @Column(name = "email")
    private String personEmail;
    @Column(name = "phone")
    private String personPhone;
    @Column(name = "address")
    private String personAddress;
    @Column(name = "resume")
    private String personResume;
    @Column(name = "create_at")
    private String personCreateAt;
    @Column(name = "update_at")
    private String personUpdateAt;
    @Column(name = "status")
    private String personStatus;
}
