package chat;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private JPanel rootPanel;
    private JTextArea chatArea;
    private JList<String> userList;
    private JTextField inputField;
    private JButton sendButton;

    public MainWindow(String login){
        this.setTitle(login);
        this.setMinimumSize(new Dimension(800,600));

        this.setContentPane(rootPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();

        sendButton.addActionListener(actionEvent-> send());
        inputField.addActionListener(actionEvent-> send());
    }
    private void send(){
        String message = inputField.getText();
        if(message.isEmpty()) return;
        chatArea.append(message+"\n");
        inputField.setText("");
    }

}
