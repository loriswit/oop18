// Loris Witschard & Nicolas Bovet
package assignment10.exercise02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventDemo extends JPanel implements Runnable
{
    private JPanel panel = new JPanel();
    private JTextArea textArea = new JTextArea();
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new MouseEventDemo());
    }
    
    public void addBlankArea(Color color)
    {
        var label = new JLabel();
        label.setPreferredSize(new Dimension(400, 200));
        label.addMouseListener(new CustomListener("blank area", textArea));
        
        var blankPanel = new JPanel();
        blankPanel.setBackground(color);
        blankPanel.add(label);
        
        panel.add(blankPanel);
    }
    
    public void addTextArea()
    {
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.addMouseListener(new CustomListener("text area", textArea));
        panel.add(new JScrollPane(textArea));
    }
    
    @Override
    public void run()
    {
        panel.setLayout(new GridLayout(2, 1));
        
        addBlankArea(Color.GREEN);
        addTextArea();
        
        var window = new JFrame("Mouse Event Demo");
        window.setContentPane(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    static class CustomListener implements MouseListener
    {
        private String name;
        private JTextArea text;
        
        public CustomListener(String name, JTextArea text)
        {
            this.name = name;
            this.text = text;
        }
        
        @Override
        public void mouseClicked(MouseEvent e)
        {
            text.append("Mouse clicked detected on " + name + "\n");
        }
        
        @Override
        public void mousePressed(MouseEvent e)
        {
        }
        
        @Override
        public void mouseReleased(MouseEvent e)
        {
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            text.append("Mouse entered detected on " + name + "\n");
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            text.append("Mouse exited detected on " + name + "\n");
        }
    }
}
