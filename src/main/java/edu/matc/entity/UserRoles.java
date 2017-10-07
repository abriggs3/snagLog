package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "User_roles")
public class UserRoles {
    private int userRolesId;
    private String userName;
    private String roleName;
    private User userByUserId;

    // required empty constructor
    public UserRoles() {
    }

    // partial constructor
    public UserRoles( String userName, String roleName, User userByUserId) {
        this.userRolesId = userRolesId;
        this.userName = userName;
        this.roleName = roleName;
    }

    @Id
    @Column(name = "user_roles_id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(int userRolesId) {
        this.userRolesId = userRolesId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 30)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRolesId != userRoles.userRolesId) return false;
        if (userName != null ? !userName.equals(userRoles.userName) : userRoles.userName != null) return false;
        if (roleName != null ? !roleName.equals(userRoles.roleName) : userRoles.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRolesId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "userRolesId=" + userRolesId +
                ", userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
