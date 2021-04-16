import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class  Snippet extends JPanel{

int mouse_x, mouse_x2, mouse_y, mouse_y2;
JPanel snippet_body;
JPanel snippet_footer;
JButton button_resize;
int snippet_x;
int snippet_y;
int border_x;
int border_y;

    public Snippet(String title, int x,int y, int width, int height, String url2){
        super();
        setVisible(true);
        setBounds(x,y,width,height);
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.decode("#141414"),1,false));

        JPanel snippet_head = new JPanel();
        snippet_head.setLayout(new BorderLayout(0,0));
        snippet_head.setVisible(true);
        snippet_head.setBackground(Color.decode("#313331"));
        snippet_head.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel snippet_drag = new JPanel();
        snippet_drag.setVisible(true);
        snippet_drag.setBackground(Color.decode("#212121"));
        snippet_drag.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        snippet_drag.setCursor(new Cursor(Cursor.HAND_CURSOR));
        snippet_drag.setPreferredSize(new Dimension(100,30));
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
                
                border_x = getX()+200;
                border_y = getY()+200;
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

        JTextField snippet_title = new JTextField(title);
        snippet_title.setVisible(true);
        snippet_title.setBackground(Color.decode("#313331"));
        snippet_title.setForeground(Color.decode("#E6E6E6"));
        snippet_title.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
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

        JPanel title_box = new JPanel();
        title_box.setVisible(true);
        title_box.setBackground(Color.decode("#313331"));
        title_box.setLayout(new BorderLayout(10,5));
        title_box.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        snippet_drag.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        snippet_body = new JPanel();
        snippet_body.setBackground(Color.decode("#1E1F1E"));
        snippet_body.setBounds(x,y,width,height);
        snippet_body.setLayout(new BorderLayout(10,10));

        snippet_footer = new JPanel();
        snippet_footer.setBackground(Color.decode("#1E1F1E"));
        snippet_footer.setLayout(new BorderLayout(10,10));

        button_resize = new JButton();
        button_resize.setForeground(Color.decode("#5E615E"));
        button_resize.setVisible(true);
        button_resize.setFont(new Font("Arial", Font.BOLD, 24));
        button_resize.setFocusPainted(false);
        button_resize.setBorderPainted(false);
        button_resize.setBackground(Color.decode("#1E1F1E"));
        button_resize.setPreferredSize(new Dimension(28,25));
        button_resize.setContentAreaFilled(false);

        Icon icon_resize = new ImageIcon("src/icons/icon_resize.png");
        button_resize.setIcon(icon_resize);
        button_resize.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));

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

                if ((getX()+getWidth()-button_resize.getWidth()+e.getX())>border_x && (getY()+getHeight()-button_resize.getHeight()+e.getY())>border_y){
                    setBounds(snippet_x,snippet_y,getWidth() + e.getX()-mouse_x2,getHeight() + e.getY()-mouse_y2);
                }
                else if ((getX()+getWidth()-button_resize.getWidth()+e.getX())<border_x && (getY()+getHeight()-button_resize.getHeight()+e.getY())>border_y) {
                    setBounds(snippet_x,snippet_y,border_x-getX(),getHeight() + e.getY()-mouse_y2);
                }
                else if ((getX()+getWidth()-button_resize.getWidth()+e.getX())>border_x && (getY()+getHeight()-button_resize.getHeight()+e.getY())<border_y){
                    setBounds(snippet_x,snippet_y,getWidth() + e.getX()-mouse_x2,border_y-getY());
                }

                System.out.println(button_resize.getX() + " | " + button_resize.getY());

                SwingUtilities.updateComponentTreeUI(snippet_head);
                SwingUtilities.updateComponentTreeUI(snippet_body);
                SwingUtilities.updateComponentTreeUI(snippet_footer);
            }
        }); 

        JButton button_delete = new JButton();
        Icon icon_delete = new ImageIcon("src/icons/icon_delete.png");
        button_delete.setIcon(icon_delete);
        button_delete.setPreferredSize(new Dimension(50,30));
        button_delete.setBackground(Color.decode("#212121"));
        button_delete.setFocusPainted(false);
        button_delete.setBorderPainted(false);

        button_delete.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                button_delete.setBackground(Color.decode("#1A1A1A"));
            }
        });
        button_delete.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent e){
                button_delete.setBackground(Color.decode("#212121"));
            }
        });

        button_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel logo = new JLabel();
        Icon icon_logo = new ImageIcon(url2);
        logo.setIcon(icon_logo);

        title_box.add(logo, BorderLayout.LINE_START);
        title_box.add(snippet_drag, BorderLayout.CENTER);
        title_box.add(button_delete, BorderLayout.LINE_END);

        snippet_head.add(title_box, BorderLayout.PAGE_START);
        snippet_head.add(snippet_title);

        snippet_footer.add(button_resize, BorderLayout.LINE_END);

        add(snippet_head, BorderLayout.PAGE_START);
        add(snippet_body, BorderLayout.CENTER);
        add(snippet_footer, BorderLayout.PAGE_END);
    }
}
