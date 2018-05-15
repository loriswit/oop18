// Loris Witschard & Nicolas Bovet
package project10;

import javax.swing.*;

public class Window extends JFrame
{
    private View view = new View();
    
    public Window()
    {
        setTitle("Tangram");
        
        var menuBar = new JMenuBar();
        var gameMenu = new JMenu("Game");
        var exitItem = new JMenuItem("Exit");
        
        exitItem.addActionListener(e -> System.exit(0));
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        Controller controller = new Controller(view);
        view.addMouseListener(controller);
        addKeyListener(controller);
    
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
