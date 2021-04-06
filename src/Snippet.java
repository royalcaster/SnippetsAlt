import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class  Snippet extends JPanel{
int mouse_x;
int mouse_y;
JPanel snippet_body;
JPanel snippet_footer;

    public Snippet(String title, int x,int y, int width, int height){
        super();
        setVisible(true);
        setBounds(x,y,width,height);
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.decode("#141414"),1,false));

        JPanel snippet_head = new JPanel();
        snippet_head.setLayout(new BorderLayout(5,7));
        snippet_head.setVisible(true);
        snippet_head.setBackground(Color.decode("#313331"));
        snippet_head.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel snippet_drag = new JPanel();
        snippet_drag.setVisible(true);
        snippet_drag.setBackground(Color.decode("#212121"));
        snippet_drag.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        snippet_drag.setCursor(new Cursor(Cursor.HAND_CURSOR));
        snippet_drag.setPreferredSize(new Dimension(100,25));
        snippet_drag.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //PointerInfo a = MouseInfo.getPointerInfo();
                //Point b = a.getLocation();
                mouse_x = e.getX();
                mouse_y = e.getY();
            }
         });

        snippet_drag.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getX() - mouse_x + getLocation().x,e.getY() - mouse_y + getLocation().y);
            }
        });

        snippet_drag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                snippet_drag.setBackground(Color.decode("#1A1A1A"));
            }
        });

        snippet_drag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                snippet_drag.setBackground(Color.decode("#212121"));
            }
        });

        JPanel title_box = new JPanel();
        title_box.setVisible(true);
        title_box.setBackground(Color.decode("#313331"));
        title_box.setLayout(new FlowLayout());
        snippet_drag.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel snippet_title = new JLabel(title, SwingConstants.LEFT);
        snippet_title.setVisible(true);
        snippet_title.setOpaque(true);
        snippet_title.setBackground(Color.decode("#313331"));
        snippet_title.setForeground(Color.decode("#9EA39E"));
        snippet_title.setFont(new Font("Arial", Font.BOLD, 15));
        EmptyBorder snippet_title_border = new EmptyBorder(5,12,5,12);
        snippet_title.setBorder(snippet_title_border);

        JButton button_minimize = new JButton("-");
        button_minimize.setForeground(Color.decode("#5E615E"));
        button_minimize.setVisible(true);
        button_minimize.setFont(new Font("Arial", Font.BOLD, 24));
        button_minimize.setFocusPainted(false);
        button_minimize.setBorder(BorderFactory.createLineBorder(Color.decode("#5E615E"),2,false));
        button_minimize.setBackground(Color.decode("#313331"));
        button_minimize.setPreferredSize(new Dimension(50,25));
        button_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button_minimize.setBackground(Color.decode("#212121"));
            }
        });
        button_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                button_minimize.setBackground(Color.decode("#313331"));
            }
        });
        button_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_minimize.setBackground(Color.decode("#212121"));
            }
        });
        button_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button_minimize.setBackground(Color.decode("#212121"));
            }
        });

        snippet_body = new JPanel();
        snippet_body.setBackground(Color.decode("#252625"));
        snippet_body.setBounds(x,y,width,height);
        snippet_body.setLayout(new BorderLayout());

        snippet_footer = new JPanel();
        snippet_footer.setBackground(Color.decode("#252625"));
        snippet_footer.setLayout(new BorderLayout());

        JButton button_resize = new JButton();
        button_resize.setText("Resize");
        setBackground(Color.GREEN);

        button_resize.addMouseListener(new MouseInputAdapter(){
            public void mousePressed(MouseEvent e){
                
            }
        }); 

        title_box.add(snippet_drag);
        title_box.add(button_minimize);

        snippet_head.add(title_box, BorderLayout.PAGE_START);
        snippet_head.add(snippet_title, BorderLayout.LINE_START);

        snippet_footer.add(button_resize, BorderLayout.LINE_END);

        add(snippet_head, BorderLayout.PAGE_START);
        add(snippet_body, BorderLayout.CENTER);
        add(snippet_footer, BorderLayout.PAGE_END);

    }
}
