import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class MainButton extends JButton {
    Font roboto;

    public MainButton(String text, String url){
        super();

        Icon icon = new ImageIcon(url);
        setIcon(icon);

        setBackground(Color.decode("#141414"));
        setForeground(Color.decode("#E6E6E6"));
        setText(text);
        setBorderPainted(false);
        setFont(new Font("Arial Nova Light", Font.PLAIN, 14));
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#1A1A1A"));
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#141414"));
            }
        });

    }
}
