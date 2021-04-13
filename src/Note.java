import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Note extends Snippet{
    public Note(String title, int x,int y, int width, int height){
        super(title,x,y,width,height);
        JTextArea textarea = new JTextArea();
        textarea.setBackground(Color.decode("#1E1F1E"));
        textarea.setForeground(Color.decode("#E6E6E6"));
        textarea.setBorder(new EmptyBorder(15,15,15,15));
        textarea.setFont(new Font("Arial Nova Light",Font.PLAIN,15));
        snippet_body.add(textarea, BorderLayout.CENTER);
        textarea.setCaretPosition(0);

        if (isdragged == 1){
            textarea.setText("true");
        }
        else {
            textarea.setText("false");
        }

    }
}
