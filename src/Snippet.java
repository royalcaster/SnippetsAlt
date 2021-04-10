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
import java.util.EventListener;

public class  Snippet extends JPanel{

int mouse_x, mouse_x2, mouse_y, mouse_y2;
JPanel snippet_body;
JPanel snippet_footer;
int snippet_x;
int snippet_y;
int count;
boolean wrapped;


    public Snippet(String title, int x,int y, int width, int height){
        super();
        setVisible(true);
        setBounds(x,y,width,height);
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.decode("#141414"),1,false));
        wrapped = false;

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

        JTextField snippet_title = new JTextField(title);
        snippet_title.setVisible(true);
        snippet_title.setBackground(Color.decode("#313331"));
        snippet_title.setForeground(Color.decode("#E6E6E6"));
        snippet_title.setFont(new Font("Arial Nova Light", Font.BOLD, 16));
        EmptyBorder snippet_title_border = new EmptyBorder(5,12,5,12);
        snippet_title.setBorder(snippet_title_border);

        snippet_title.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                snippet_title.setBackground(Color.decode("#2C2E2C"));
            }
        });
        snippet_title.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent e){
                snippet_title.setBackground(Color.decode("#313331"));
            }
        });

        /*
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
        
        button_minimize.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                if (wrapped == true) {
                    add(snippet_body);
                    add(snippet_footer);
                    wrapped = false;
                }
                else if (wrapped == false) {
                    remove(snippet_body);
                    remove(snippet_footer);
                    wrapped = true;
                }
                SwingUtilities.updateComponentTreeUI(snippet_body);
                SwingUtilities.updateComponentTreeUI(snippet_footer);
            }
            
        });*/

        snippet_body = new JPanel();
        snippet_body.setBackground(Color.decode("#17252A"));
        snippet_body.setBounds(x,y,width,height);
        snippet_body.setLayout(new BorderLayout());

        snippet_footer = new JPanel();
        snippet_footer.setBackground(Color.decode("#1E1F1E"));
        snippet_footer.setLayout(new BorderLayout(10,10));

        JButton button_resize = new JButton();
        button_resize.setText(" ");
        button_resize.setForeground(Color.decode("#5E615E"));
        button_resize.setVisible(true);
        button_resize.setFont(new Font("Arial", Font.BOLD, 24));
        button_resize.setFocusPainted(false);
        button_resize.setBorder(BorderFactory.createLineBorder(Color.decode("#313331"),1,false));
        button_resize.setBackground(Color.decode("#313331"));
        button_resize.setPreferredSize(new Dimension(25,25));

        button_resize.addMouseListener(new MouseInputAdapter(){
            public void mousePressed(MouseEvent e){
                
                mouse_x2 = e.getX();
                mouse_y2 = e.getY();

                snippet_x = getX();
                snippet_y = getY();
            }
        });
        
        button_resize.addMouseMotionListener(new MouseInputAdapter(){
            public void mouseDragged(MouseEvent e){
                setBounds(snippet_x,snippet_y,getWidth() + e.getX()-mouse_x2,getHeight() + e.getY()-mouse_y2);

                //System.out.println(mouse_x2 + " | " + mouse_y2);
                System.out.println(e.getX() + " | " + e.getY());

                SwingUtilities.updateComponentTreeUI(snippet_head);
                SwingUtilities.updateComponentTreeUI(snippet_body);
                SwingUtilities.updateComponentTreeUI(snippet_footer);
            }
        }); 

        title_box.add(snippet_drag);
        //title_box.add(button_minimize);

        snippet_head.add(title_box, BorderLayout.PAGE_START);
        snippet_head.add(snippet_title);

        snippet_footer.add(button_resize, BorderLayout.LINE_END);

        add(snippet_head, BorderLayout.PAGE_START);
        add(snippet_body, BorderLayout.CENTER);
        add(snippet_footer, BorderLayout.PAGE_END);
    }

}
