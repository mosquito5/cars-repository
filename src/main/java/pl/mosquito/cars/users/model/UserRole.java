package pl.mosquito.cars.users.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private long id;
    private String role;

    public UserRole() {
    }

    public UserRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public  String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }


}
