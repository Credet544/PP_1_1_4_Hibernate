package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.createUsersTable();
        userService.saveUser("name1", "lastName1", (byte) 11);
        userService.saveUser("name2", "lastName2", (byte) 22);
        userService.saveUser("name3", "lastName3", (byte) 33);
        userService.saveUser("name4", "lastName4", (byte) 44);
        List<User> list = userService.getAllUsers();
        list.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
