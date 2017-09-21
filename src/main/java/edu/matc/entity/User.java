package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Class manages information about users
 * Created on 9/13/17.
 *
 * @author abriggs
 */
@Entity
@Table(name = "users")

public class User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPassword;

    // no argument constructor, required for java bean
    public User() {}

    public User(String firstName, String lastName, String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
