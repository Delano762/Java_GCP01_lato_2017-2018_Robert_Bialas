import javax.swing.JFrame;
public class ServerTest {

    public static void main(String[] args) {
        Server testo = new Server();
        testo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testo.startRunning();
    }
}
