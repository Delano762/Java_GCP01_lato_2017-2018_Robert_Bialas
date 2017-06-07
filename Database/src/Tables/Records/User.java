package Tables.Records;

/**
 * Created by robert on 29.05.2017.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toSqlString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append(id).append("\",\"").append(firstName).append("\",\"").append(lastName).append("\"");
        return stringBuilder.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
