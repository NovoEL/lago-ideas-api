package xyz.lagosoft.ideas.Auth;

import xyz.lagosoft.ideas.common.BaseEntityA;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntityA {

    private String email;

    @Column(nullable = false, length = 15, unique = true)
    private String username;

    private String hashedPassword;

    private Boolean emailVerified;

    private Boolean disabled;

    public User() {
        this.emailVerified = false;
        this.disabled = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
