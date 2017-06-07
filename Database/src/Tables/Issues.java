package Tables;

/**
 * Created by robert on 29.05.2017.
 */
import Tables.Records.Firearm;
import Tables.Records.Issue;
import Tables.Records.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Issues {
    private Connection connection;
    private Statement statement;
    private ResultSet firearms;

    public Issues(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = this.connection.createStatement();
    }

    public void addUser(User user) throws SQLException {
        statement.execute("INSERT INTO users VALUES (" + user.toSqlString() + ");");
    }

    public void addIssueEntry(Issue issue) throws SQLException {
        statement.execute("INSERT INTO issues VALUES (" + issue.toSqlString() + ");");
    }

    public void updateUser(User user) throws SQLException {
        statement.execute("UPDATE users SET firstname = " + "\"" + user.getFirstName() + "\"" + ", lastname = " +
                "\"" + user.getLastName() + "\"" + " WHERE users.id = " + user.getId());
    }

    public void updateIssueEntry(Issue issue) throws SQLException {
        statement.execute("UPDATE issues SET user_id= " + "\"" + issue.getUserId() + "\"" + ", firearm_id= " +
                "\"" + issue.getFirearmId() + "\"" + ", date= " + "\"" + issue.getDate() + "\"" + " WHERE issues.issue_id = " + issue.getId());
    }

    public ResultSet getUsers() throws SQLException {
        return statement.executeQuery("SELECT * FROM users");
    }

    public ResultSet getRawIssueEntries() throws SQLException {
        return statement.executeQuery("SELECT * FROM  issues");
    }

    public ResultSet getIssueEntries() throws SQLException {
        return statement.executeQuery("SELECT * FROM  main_view");
    }


    public void deleteUser(User user) throws SQLException {
        statement.execute("DELETE FROM users WHERE id = " + user.getId());
    }

    public void deleteIssueEntry(Issue issue) throws SQLException {
        statement.execute("DELETE FROM issues WHERE issue_id = " + issue.getId());
    }

    public void deleteIssueEntry(int id) throws SQLException {
        statement.execute("DELETE FROM issues WHERE issue_id = " + id);
    }

    public void addFirearm(Firearm firearm) throws SQLException {
        statement.execute("INSERT INTO firearms VALUES (" + firearm.toSqlString() + ");");
    }

    public ResultSet getFirearms() throws SQLException {
        return statement.executeQuery("SELECT * FROM  firearms");
    }

    public void updateFirearm(Firearm firearm) throws SQLException {
        statement.execute("UPDATE firearms SET model = " + "\"" + firearm.getModel() + "\", designer = " + "\"" + firearm.getDesigner() + "\"" + ", caliber = " + "\"" + firearm.getCaliber() + "\"" + " WHERE  firearms.id = " + firearm.getId());
    }

    public void deleteFirearm(Firearm firearm) throws SQLException {
        statement.execute("DELETE FROM firearms WHERE id = " + firearm.getId());
    }
}