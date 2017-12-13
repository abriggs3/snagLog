package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "Users")
public class User implements Storable{
    @Id
    @Column(name = "users_id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int usersId;

    @Basic
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Basic
    @Column(name = "user_pass", nullable = false, length = 30)
    private String userPassword;

    /**
     * Instantiates a new User.
     */
// required empty constructor
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param userPass  the user pass
     */
// partial constructor
    public User(String firstName, String lastName, String userName, String userPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPass;
    }

    /**
     * Instantiates a new User.
     *
     * @param usersId   the users id
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param userPass  the user pass
     */
// full constructor
    public User(int usersId, String firstName, String lastName, String userName, String userPass) {
        this.usersId = usersId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPass;
    }


    /**
     * Gets users id.
     *
     * @return the users id
     */
    public int getUsersId() {
        return usersId;
    }

    /**
     * Sets users id.
     *
     * @param usersId the users id
     */
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPass the user pass
     */
    public void setUserPassword(String userPass) {
        this.userPassword = userPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User users = (User) o;

        if (usersId != users.usersId) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(users.userPassword) : users.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usersId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "usersId=" + usersId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPassword + '\'' +
                '}';
    }


}
