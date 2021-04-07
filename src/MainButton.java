import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class MainButton extends JButton {
    Font roboto;


    public MainButton(String text){
        super();  

        setBackground(Color.decode("#006494"));
        setForeground(Color.WHITE);
        setText(text);
        setBorderPainted(false);
        setFont(new Font("Century Gothic", Font.PLAIN, 15));
        setMargin(new Insets(7,15,7,15));
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#005780"));
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#006494"));
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Color.decode("#080808"));
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(Color.decode("#080808"));
            }
        });

    }
}
