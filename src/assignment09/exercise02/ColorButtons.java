// Loris Witschard & Nicolas Bovet
package assignment09.exercise02;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ColorButtons implements Runnable
{
    private JPanel panel = new JPanel();
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new ColorButtons());
    }
    
    private void addButton(String name, Color color)
    {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(120, 30));
        button.addActionListener(e -> panel.setBackground(color));
        panel.add(button);
    }
    
    @Override
    public void run()
    {
        panel.setLayout(new GridLayout(1, 4, 40, 40));
        panel.setBorder(new EmptyBorder(40, 40, 40, 40));
        
        addButton("Red", Color.RED);
        addButton("Yellow", Color.YELLOW);
        addButton("Green", Color.GREEN);
        addButton("Blue", Color.BLUE);
        
        JFrame window = new JFrame("Select color");
        window.setContentPane(panel);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
