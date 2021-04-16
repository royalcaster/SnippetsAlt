import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

public class Table extends Snippet{
    
    public Table(String title, int x,int y, int width, int height, String url2){
        super(title,x,y,width,height,url2);

        String[] columnNames = {"ID","Name","Gehalt"};
        Object[][] data = {
            {"101","Gabriel","500"},
            {"102","Marius","400"},
            {"103", "Katharina","300"}
        };

        JTable table = new JTable(data,columnNames);
        table.setVisible(true);
        table.setForeground(Color.decode("#D7DED7"));
        table.setBackground(Color.decode("#1E1F1E"));
        table.setSelectionBackground(Color.decode("#1E1F1E"));
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(Color.decode("#747874"));
        table.setIntercellSpacing(new Dimension(10,10));
        table.setRowHeight(30);
        table.setRowMargin(0);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        table.setBorder(new EmptyBorder(new Insets(5,5,5,5)));

        snippet_body.add(table);
    }
}
