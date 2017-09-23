package edu.matc.utility;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRolesKey implements Serializable {
    @Column(name="user_name")
    private String userName;

    @Column(name="role_name")
    private String userRole;
}
