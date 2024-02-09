import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public  class Main{
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(100,20));

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                String text1= textField.getText();
                textField.setText(text1.toUpperCase());
            }


        });

        JLabel label=new JLabel("Enter your Name");

        JButton b=new JButton("Submit");
        b.setMnemonic('s');
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = text.getText();

                if (s.length() == 0) {
                    try {
                        throw new Exception("Text box is Empty");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Exception Caught: " + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Hello "+s,"Welcome",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });



        JPanel panel=new JPanel();




        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(text);
        frame.add(panel);
        frame.add(b);

        frame.setVisible(true);
    }
}
