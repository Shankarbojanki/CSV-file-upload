package com.example.CSVfileToMysql.entity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "users_table")

public class Users {

    @Id
  //  @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column(length =255)
    private String first_name;

    @Column(length =255)
    private String last_name;

    @Column(length =255)
    private String email;

    @Column(length =255)
    private String  gender;

    @Column(length =255)
    private String username;

    @Column(length =25)
    private int  age;

    @Column(length =255)
    private String address;

    @Column(length =25)
    private Long mobile;


    public Users(Long id, String first_name, String last_name, String email,
                 String gender, String username, int age, String address, Long mobile) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.age = age;
        this.address = address;
        this.mobile = mobile;
    }

    public Users(){

    }

    public Users(List<Users> csvToUsers) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }



}