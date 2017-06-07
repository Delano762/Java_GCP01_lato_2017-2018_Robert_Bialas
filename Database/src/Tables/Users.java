package Tables;

/**
 * Created by robert on 29.05.2017.
 */
import Tables.Records.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Users {
    private Issues issues;

    public Users(Issues issues) {
        this.issues = issues;
    }

    public void create(User user) throws SQLException {
        issues.addUser(user);
    }

    public User read(int id) throws SQLException {
        ResultSet resultSet = issues.getUsers();

        while (resultSet.next()) {
            if (Integer.parseInt(resultSet.getString("id")) == id) {
                return new User(id, resultSet.getString("firstname"), resultSet.getString("lastname"));
            }
        }

        return null;
    }

    public void update(User user) throws SQLException {
        issues.updateUser(user);
    }

    public void delete(User user) throws SQLException {
        issues.deleteUser(user);
    }

    public void delete(int id) throws SQLException {
        issues.deleteUser(new User(id, null, null));
    }
}