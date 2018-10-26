package pl.mosquito.cars.users.model;

import pl.mosquito.cars.CustomConstraint.FieldMatch;
import pl.mosquito.cars.car.model.Car;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@FieldMatch(first = "password", second = "spassword", message = "The passwords must match")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "The user name must not be empty")
    private String username;
    @NotBlank
    private String password;
    @Email
    @NotBlank(message = "The email must not be empty")
    private String email;
    @Transient
    @NotBlank(message = "The confirm password must not be empty")
    private String spassword;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car userCar;


    public User() {
    }

    public User(String username, String password, String spassword, String email,
                Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.spassword = spassword;
        this.email = email;
        this.userRoles = userRoles;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Car getUserCar() {
        return userCar;
    }

    public void setUserCar(Car userCar) {
        this.userCar = userCar;
    }
}
