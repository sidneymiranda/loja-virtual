package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Users")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
public class User implements UserDetails {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date register;

    @Temporal(TemporalType.DATE)
    private Date updated;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

    @OneToMany
    @JoinTable(
            name = "role_users",
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}, name = "uniq_role_access"),
            joinColumns =
                @JoinColumn(
                        name = "user_id",
                        referencedColumnName = "id",
                        table = "users",
                        foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)
                ),
            inverseJoinColumns =
                @JoinColumn(
                        name = "role_id",
                        referencedColumnName = "id",
                        table = "role",
                        foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)
                )
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
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
