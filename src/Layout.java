import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;

public class Layout extends JFrame{
    /**
     *
     */
    Note note;
    Table table;
    int mouse_x;
    int mouse_y;
    int panel_x;
    int panel_y;

    public Layout(){

        // Startfenster erzeugen
        JFrame frame = new JFrame("Snippets");
        frame.setVisible(true);
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Kamerapanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#0D0D0D"));
        panel.setLayout(null);

        //Content-Panel
        JPanel panel_content = new JPanel();
        panel_content.setLayout(null);
        panel_content.setBackground(Color.decode("#0D0D0D"));
        panel_content.setVisible(true);
        panel_content.setBounds(-2040,-960,6000,3000);

        JPanel panel_buttons = new JPanel();
        panel_buttons.setBackground(Color.decode("#141414"));
        panel_buttons.setLayout(new GridLayout(12,1,0,0));

        MainButton button_note = new MainButton("Notiz","src/icons/icon_note.png");
        MainButton button_table = new MainButton("Tabelle","src/icons/icon_table.png");
        MainButton button_list = new MainButton("Liste","src/icons/icon_list.png");


        panel_buttons.add(button_note);
        panel_buttons.add(button_table);
        panel_buttons.add(button_list);

        panel.add(panel_content);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel_buttons, BorderLayout.WEST);

        //Maus-Events
        button_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title_text = JOptionPane.showInputDialog("Titel eingeben:");

                createNote(title_text,Math.abs(panel_content.getX())+300,Math.abs(panel_content.getY())+300,250,260,"src/icons/icon_note_small.png");
                panel_content.add(note);

                SwingUtilities.updateComponentTreeUI(panel_content);
            }
        });

        button_table.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                createTable("Test",Math.abs(panel_content.getX())+300,Math.abs(panel_content.getY())+300,250,260,"src/icons/icon_table_small.png");
                panel_content.add(table);

                SwingUtilities.updateComponentTreeUI(panel_content);
            }
        });

        panel_content.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //PointerInfo a = MouseInfo.getPointerInfo();
                //Point b = a.getLocation();
                mouse_x = e.getX();
                mouse_y = e.getY(); 

            }
         });

        panel_content.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panel_x = panel_content.getX();
                panel_y = panel_content.getY();

                panel_content.setLocation(panel_x + (e.getX()-mouse_x),panel_y + (e.getY()-mouse_y)); 

                /* Muss noch gel??st werden: Wenn Rand des Content-Panels erreicht, dann nicht weiter scrollen...
                
                int dif_x = panel_content.getWidth()-panel.getWidth();
                int dif_y = panel_content.getHeight() - panel.getHeight();

                if (Math.abs(panel_content.getX())>dif_x){
                    panel_content.setLocation(200,200);  
                }
                */
        }
        });    

    }

    public void createNote(String title, int x, int y, int width, int height, String url2){
        note = new Note(title,x, y, width, height,url2);
    }

    public void createTable(String title, int x, int y, int width, int height, String url2){
        table = new Table(title,x,y,width,height, url2);
    }
}