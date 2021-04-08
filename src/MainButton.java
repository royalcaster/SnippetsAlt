import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainButton extends JButton {



    public MainButton(String url){
        super();

        Icon icon = new ImageIcon(url);

        setIcon(icon);
        setSize(25, 25);
        setBackground(Color.decode("#2B7A78"));
        setForeground(Color.decode("#9EA39E"));
        setText(" ");
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setMargin(new Insets(7,15,7,15));
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#2B7A78"));
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#2B7A78"));
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
