package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("name1", "lastName1", (byte)11);
        userDaoJDBC.saveUser("name2", "lastName2", (byte)22);
        userDaoJDBC.saveUser("name3", "lastName3", (byte)33);
        userDaoJDBC.saveUser("name4", "lastName4", (byte)44);
        List<User> list = userDaoJDBC.getAllUsers();
        list.forEach(System.out::println);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}
