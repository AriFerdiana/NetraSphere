package com.smartwaste.entity;

import jakarta.persistence.*;

/**
 * Entitas Admin — subclass dari {@link User} untuk peran administrator sistem.
 */
@Entity
@Table(name = "admins")
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    @Column(name = "position", length = 100)
    private String position;

    public Admin() {
        super();
    }

    public Admin(String name, String email, String password, String phone, String position) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhone(phone);
        this.position = position;
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
