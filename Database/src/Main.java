import Tables.Firearms;
import Tables.Issues;
import Tables.Records.Issue;
import Tables.Records.User;
import Tables.Users;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_base", "", "");

            Issues issues = new Issues(myConn);

            ResultSet resultSet = issues.getFirearms();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + " | ");
                System.out.print(resultSet.getString("model") + " | ");
                System.out.print(resultSet.getString("designer") + " | ");
                System.out.println(resultSet.getString("caliber"));
            }

            System.out.println();
            System.out.println();
            System.out.println();

            resultSet = issues.getUsers();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + " | ");
                System.out.print(resultSet.getString("firstname") + " | ");
                System.out.println(resultSet.getString("lastname"));
            }

            System.out.println();
            System.out.println();
            System.out.println();

            resultSet = issues.getRawIssueEntries();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("user_id") + " | ");
                System.out.print(resultSet.getString("issue_id") + " | ");
                System.out.print(resultSet.getString("firearm_id") + " | ");
                System.out.println(resultSet.getString("date"));
            }

            System.out.println();
            System.out.println();
            System.out.println();
            //resultSet = issues.getRawIssueEntries();
            /*while (resultSet.next()) {
                System.out.print(resultSet.getString("firearm_id") + " | ");
                System.out.print(resultSet.getString("caliber") + " | ");
                System.out.print(resultSet.getString("firstname") + " | ");
                System.out.print(resultSet.getString("lastname") + " | ");
                System.out.print(resultSet.getString("model") + " | ");
                System.out.print(resultSet.getString("designer") + " | ");
                System.out.print(resultSet.getString("date") + " | ");
                System.out.println(resultSet.getString("lastname"));
            }*/
            issues.deleteIssueEntry(6);
            issues.addIssueEntry(new Issue(6, 2, 2, new Date(System.currentTimeMillis())));
            issues.deleteIssueEntry(6);


            Users users = new Users(issues);
            Firearms firearms = new Firearms(issues);
            System.out.println(firearms.read(1));
            users.update(new User(2, "888", "8"));
            System.out.println(users.read(2));
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}
