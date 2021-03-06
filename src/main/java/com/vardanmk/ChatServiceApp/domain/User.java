package com.vardanmk.ChatServiceApp.domain;

import com.vardanmk.ChatServiceApp.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Firstname cannot be empty")
    @Column(name = "first_name", nullable = false)
    private String firstname;

    @NotBlank(message = "Lastname cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastname;

    @NotBlank(message = "Username cannot be empty")
    @Column(name = "user_name", nullable = false)
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Column(name = "user_passwd", nullable = false)
    private String password;

    @Column(name = "user_pic")
    private String filename;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastname(String userName) {
        this.lastname = userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
//        return getRoles();
    }



    public String getLastname() {
        return lastname;
    }

    @Override
    public String getUsername() {return username;}

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
