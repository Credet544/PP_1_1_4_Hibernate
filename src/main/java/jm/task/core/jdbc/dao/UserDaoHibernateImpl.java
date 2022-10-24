package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(45), lastName VARCHAR(45), age INT(3));").addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ignored) {

        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users;").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ignored) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception ignored) {

        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            User user = session.get(User.class, id);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception ignored) {

        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            result = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        } catch (Exception ignored) {

        }
        return result;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User");
            session.getTransaction().commit();
        } catch (Exception ignored) {

        }
    }
}
