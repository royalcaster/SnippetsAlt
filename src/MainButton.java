import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class MainButton extends JButton {
    Font roboto;

    public MainButton(String text, String url, String url2){
        super();

        Icon icon = new ImageIcon(url);
        setIcon(icon);

        Icon icon_hover = new ImageIcon(url2);

        setSize(new Dimension(100,100));
        setBackground(Color.decode("#2B7A78"));
        setForeground(Color.decode("#9EA39E"));
        setText(text);
        setBorderPainted(false);
        setFont(new Font("Century Gothic", Font.PLAIN, 15));
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#266E6B"));
                setIcon(icon_hover);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#2B7A78"));
                setIcon(icon);
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
