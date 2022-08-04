package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("name1", "lastName1", (byte) 1);
        userServiceImpl.saveUser("name2", "lastName2", (byte) 2);
        userServiceImpl.saveUser("name3", "lastName3", (byte) 3);
        userServiceImpl.saveUser("name4", "lastName4", (byte) 4);
        userServiceImpl.getAllUsers();
        userServiceImpl.cleanUsersTable();
        userServiceImpl.removeUserById(3);
        Util.closeSession();
    }
}
