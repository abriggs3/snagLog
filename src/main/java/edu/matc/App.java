package edu.matc;

import java.util.List;

import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.service.GenericServiceImpl;
import edu.matc.service.IGenericService;
import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.entity.Log;
import edu.matc.entity.Snag;

public class App {
    public static void main(String[] args) {
        User user=null;
        UserRoles userRoles=null;

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, SessionFactoryProvider.getSessionFactory());
        IGenericService<UserRoles> userRolesService = new GenericServiceImpl<UserRoles>(
                UserRoles.class, SessionFactoryProvider.getSessionFactory());
        userService.deleteAll();

        user = new User();
        user.setFirstName("Mulberry");
        user.setLastName("Briggs");
        user.setUserPassword("coolPassword");
        user.setUserName("starUser");
        userService.save(user);

/*
        List<Country> countryList = countryService.getAll();
        if (countryList != null) {
            for (Country c : countryList) {
                System.out.println(c.toString());
            }
        }
*/
    }
}