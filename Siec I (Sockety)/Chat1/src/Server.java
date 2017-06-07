/**
 * Created by robert on 16.05.2017.
 */
import java.io.*;
import  java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Server extends JFrame{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    //constructor
    public Server(){
        super("Server");
        userText= new JTextField();
        userText.setEditable(false);
        userText.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage(e.getActionCommand());
                        userText.setText("");
                    }
                }
        );
        add(userText,BorderLayout.SOUTH);
        chatWindow=new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300,150);
        setVisible(true);
        chatWindow.setEditable(false);
    }

    //set up and run the server
    public void startRunning(){
        try{
            server = new ServerSocket(6789,100);
            while(true){
                try{
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                    //connect and have conversation
                }catch (EOFException eofException){
                    showMessage("\n Server ended the connection! ");
                }finally {
                    close();
                }
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    //wait for connection, then prompt "YOU'RE CONNECTED"
    private void waitForConnection()throws IOException{
        showMessage("Waiting for you in that special place... \n");
        chatWindow.setEditable(false);
        connection = server.accept();
        showMessage(" Now connected to "+connection.getInetAddress().getHostName());
        //chatWindow.setEditable(true);
    }
    //get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input= new ObjectInputStream(connection.getInputStream());
        showMessage("\n Streams are now set up! \n");
    }
    //during the chat conversation
    private void whileChatting() throws IOException{
        String message = " You are now connected! ";
        sendMessage(message);
        ableToType(true);
        do{
            try{
                message = (String) input.readObject();
                showMessage("\n"+message);
            }catch (ClassNotFoundException classNotFoundException){
                showMessage("\n idk wtf that user sent!");
            }
            //have a conversation
        }while(!message.equals("/quit"));
    }

    //close streams and sockets after you are done chatting
    private void close(){
        showMessage("\n Closing connections... \n");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    //send a message to client
    private void sendMessage(String message)
    {
        try{
            output.writeObject("<SERVER> "+message);
            output.flush();
            showMessage("\n<SERVER> - "+message);
        }catch (IOException ioException)
        {
            chatWindow.append("\n ERROR: I CAN'T SEND THAT MESSAGE");
        }
    }

    //updates chatWindow
    private void showMessage(final String text) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        chatWindow.append(text);
                    }
                }
        );
    }
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        userText.setEditable(tof);
                    }
                }
        );
    }
        //

}
