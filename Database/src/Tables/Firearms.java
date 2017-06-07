package Tables;

/**
 * Created by robert on 29.05.2017.
 */
import Tables.Records.Firearm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;


public class Firearms {

    private Issues issues;

    public Firearms(Issues issues) {
        this.issues = issues;
    }

    public void create(Firearm firearm) throws SQLException {
        issues.addFirearm(firearm);
    }


    public Firearm read(int id) throws SQLException {
        ResultSet resultSet = issues.getFirearms();

        while (resultSet.next()) {
            if (Integer.parseInt(resultSet.getString("id")) == id) {
                return new Firearm(id, resultSet.getString("model"), resultSet.getString("designer"),resultSet.getDouble("caliber"));
            }
        }

        return null;
    }

    public void update(Firearm firearm) throws SQLException {
        issues.updateFirearm(firearm);
    }

    public void delete(Firearm firearm) throws SQLException {
        issues.deleteFirearm(firearm);
    }

    public void delete(int id) throws SQLException {
        issues.deleteFirearm(new Firearm(id, null, null, 0));
    }
}