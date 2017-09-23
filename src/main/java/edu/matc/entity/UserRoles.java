package edu.matc.entity;

import edu.matc.utility.UserRolesKey;

import javax.persistence.*;

/*
@Entity
@Table (name = "user_roles")
*/
public class UserRoles {
    //@EmbeddedId
    private UserRolesKey userName;

    //@EmbeddedId
    private UserRolesKey userRole;

    public UserRolesKey getUserName() {
        return userName;
    }

    public void setUserName(UserRolesKey userName) {
        this.userName = userName;
    }

    public UserRolesKey getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRolesKey userRole) {
        this.userRole = userRole;
    }

}
