package Tables.Records;

/**
 * Created by robert on 29.05.2017.
 */
import java.time.Year;

public class Firearm {
    private int id;
    private String model;
    private String designer;
    private double caliber;

    public Firearm(int id, String model, String designer, double caliber) {
        this.id = id;
        this.model = model;
        this.designer = designer;
        this.caliber = caliber;
    }

    public Firearm(String model, String designer, double caliber) {
        this.model = model;
        this.designer = designer;
        this.caliber = caliber;
    }

    @Override
    public String toString() {
        return "Firearm{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", designer='" + designer + '\'' +
                ", caliber=" + caliber +
                '}';
    }

    public String toSqlString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append(id).append("\",\"").append(model).append("\",\"").append(designer)
                .append("\",\"").append(caliber).append("\"");

        return stringBuilder.toString();
    }

    public String getModel() {
        return model;
    }

    public String getDesigner() {
        return designer;
    }

    public int getId() {
        return id;
    }

    public double getCaliber() {
        return caliber;
    }
}