package Tables.Records;

/**
 * Created by robert on 29.05.2017.
 */
import java.sql.Date;

public class Issue {
    private int issueId;
    private int userId;
    private int firearmId;
    private Date date;

    public Issue(int issueId, int userId, int firearmId, Date date) {
        this.issueId = issueId;
        this.userId = userId;
        this.firearmId = firearmId;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public int getFirearmId() {
        return firearmId;
    }

    public Date getDate() {
        return date;
    }

    public String toSqlString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append(issueId).append("\",\"").append(userId).append("\",\"").append(firearmId)
                .append("\",\"").append(date).append("\"");

        return stringBuilder.toString();
    }

    public int getId() {
        return issueId;
    }
}