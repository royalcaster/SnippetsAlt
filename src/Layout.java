import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout extends JFrame{
    Snippet snippet;
    int mouse_x;
    int mouse_y;

    public Layout(){

        // Startfenster erzeugen

        JFrame frame = new JFrame("Snippets");
        frame.setVisible(true);
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#141414"));
        panel.setLayout(null);

        JPanel panel_buttons = new JPanel();
        panel_buttons.setBackground(Color.decode("#252625"));
        panel_buttons.setLayout(new FlowLayout());

        MainButton button_add = new MainButton("Neues Snippet");
        MainButton button_table = new MainButton("Neue Tabelle");
        MainButton button_list = new MainButton("Neue Liste");

        panel_buttons.add(button_add);
        panel_buttons.add(button_table);
        panel_buttons.add(button_list);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel_buttons, BorderLayout.PAGE_START);

        //Maus-Events
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title_text = JOptionPane.showInputDialog("Abfrage:");

                createSnippet(title_text,frame.getWidth()/10,frame.getHeight()/10,170,260);
                panel.add(snippet);

                SwingUtilities.updateComponentTreeUI(panel);
            }
        });
    }

    public void createSnippet(String title, int x, int y, int width, int height){
        snippet = new Snippet(title,x, y, width, height);
    }
}