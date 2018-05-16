// Loris Witschard & Nicolas Bovet
package project09;

import project09.gfx.Point;
import project09.gfx.shape.Square;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private View view = new View();
    
    public Window()
    {
        setTitle("Tangram");
    
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        exitItem.addActionListener(e -> System.exit(0));
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
        
        view.add(new Square(new Point(0, 0), 10, Color.BLACK));
        
        setContentPane(view);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public View getView()
    {
        return view;
    }
}
