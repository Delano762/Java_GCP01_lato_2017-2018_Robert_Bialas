package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * Created by robert on 07.03.2017.
 */
public class SampleForm extends JFrame {
    private JButton button1;
    private JPanel rootPanel;
    private JTextField textField1;
    private JList list1;
    private JTextArea textArea1;

    public SampleForm(){
        super("Hello World");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(SampleForm.this,"You clicked the button!");
            }
        });

        setVisible(true);
    }
}
