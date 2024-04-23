package com.bci.user.entity;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @Email(message = "Email must be in a valid format")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<PhoneEntity> phones;

    @Column(name = "date")
    private OffsetDateTime created;

    @Column(name = "modified")
    private OffsetDateTime modified;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @Column(name = "token")
    private String token;

    @Column(name="inactive")
    private Boolean inactive;

}
