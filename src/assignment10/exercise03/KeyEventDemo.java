// Loris Witschard & Nicolas Bovet
package assignment10.exercise03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("Duplicates")
public class KeyEventDemo extends JFrame implements KeyListener, ActionListener
{
    JTextArea displayArea;
    JTextField typingArea;
    static final String newline = System.getProperty("line.separator");
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(KeyEventDemo::createAndShowGUI);
    }
    
    private static void createAndShowGUI()
    {
        //Create and set up the window.
        KeyEventDemo frame = new KeyEventDemo("KeyEventDemo_Original");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up the content pane.
        frame.addComponentsToPane();
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    private void addComponentsToPane()
    {
        
        JButton button = new JButton("Clear");
        button.addActionListener(this);
        
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));
        
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
    }
    
    public KeyEventDemo(String name)
    {
        super(name);
    }
    
    /**
     * Handle the key typed event from the text field.
     */
    public void keyTyped(KeyEvent e)
    {
        displayInfo(e, "KEY TYPED: ");
    }
    
    /**
     * Handle the key pressed event from the text field.
     */
    public void keyPressed(KeyEvent e)
    {
        displayInfo(e, "KEY PRESSED: ");
    }
    
    /**
     * Handle the key released event from the text field.
     */
    public void keyReleased(KeyEvent e)
    {
        displayInfo(e, "KEY RELEASED: ");
    }
    
    /**
     * Handle the button click.
     */
    public void actionPerformed(ActionEvent e)
    {
        //Clear the text components.
        displayArea.setText("");
        typingArea.setText("");
        
        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }
    
    private void displayInfo(KeyEvent e, String keyStatus)
    {
        String keyString;
        
        if(e.getID() == KeyEvent.KEY_TYPED)
            keyString = "key character = '" + e.getKeyChar() + "'";
        else
            keyString = "key code = " + e.getKeyCode()
                + " (" + KeyEvent.getKeyText(e.getKeyCode()) + ")";
        
        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if(tmpString.length() > 0)
        {
            modString += " (" + tmpString + ")";
        }
        else
        {
            modString += " (no extended modifiers)";
        }
        
        String actionString = "action key? ";
        if(e.isActionKey())
        {
            actionString += "YES";
        }
        else
        {
            actionString += "NO";
        }
        
        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if(location == KeyEvent.KEY_LOCATION_STANDARD)
        {
            locationString += "standard";
        }
        else if(location == KeyEvent.KEY_LOCATION_LEFT)
        {
            locationString += "left";
        }
        else if(location == KeyEvent.KEY_LOCATION_RIGHT)
        {
            locationString += "right";
        }
        else if(location == KeyEvent.KEY_LOCATION_NUMPAD)
        {
            locationString += "numpad";
        }
        else
        { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }
        
        displayArea.append(keyStatus + newline
            + "    " + keyString + newline
            + "    " + modString + newline
            + "    " + actionString + newline
            + "    " + locationString + newline);
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }
}
