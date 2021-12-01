package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(unique = true)
    public String username;

    @Column
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(unique = true)
    private String email;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


    public long getUser_id() {return user_id;}

    public void setUser_id(long user_id) {this.user_id = user_id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public boolean isEnabled() {return enabled;}

    public void setEnabled(boolean enabled) {this.enabled = enabled;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Set<Authority> getAuthorities() {return authorities;}

    public void setAuthorities(Set<Authority> authorities) {this.authorities = authorities;}
}
