import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainButton extends JButton {



    public MainButton(String text){
        super();
        setBackground(Color.decode("#141414"));
        setForeground(Color.decode("#9EA39E"));
        setText(text);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setMargin(new Insets(7,15,7,15));
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#080808"));
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
