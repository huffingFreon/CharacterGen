/*
 * ---------------------------------------------------------------------------
 * File name: mkWindow.java
 * Project name: CharacterGen
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/16/2019
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Extends JFrame to create a formatted window of all components required to run the program
 *
 * Date Created: Apr 16, 2019
 *
 * @author Ben Higgins
 */
public class CharacterWindow extends JFrame
{
	private static final long serialVersionUID = 1L;            //to avoid an error
	final int WINDOW_WIDTH = 400,                               //set width of the window
			  WINDOW_HEIGHT = 300;                              //set height of the window
	private InfoPanel info;                                     //InfoPanel to display the Character's information
	private CharacterPortrait portrait;                         //CharacterPortrait to display the appropriate portrait
    private UserCharacter c;                                    //UserCharacter from which all information is retrieved
    private JButton generate;                                   //JButton to generate new characters
    private JButton export;                                     //JButton to export a character to a text file
    private JButton importButton;                               //JButton to import a character from a text file
    private JPanel buttonPanel;                                 //JPanel to organize the buttons

    /**
     * Initializes all variables and organizes them into the final window
     *
     * Date Created: Apr 16, 2019
     */
	public CharacterWindow()
	{
	    //Call to create the base JFrame and have it named "Random Character Generator"
		super("Random Character Generator");

		//Creates a randomized UserCharacter
		c = new UserCharacter();

		//Creates an InfoPanel and CharacterPortrait based on the newly randomized UserCharacter
        info = new InfoPanel(c);
        portrait = new CharacterPortrait(c);

        //Initializes JButtons and registers the appropriate ActionListeners to them
        generate = new JButton("Generate!");
        generate.addActionListener(new GenerateListener());
        export = new JButton("Export");
        export.addActionListener(new ExportListener());
        importButton = new JButton("Import");
        importButton.addActionListener(new ImportListener());

        //Initializes buttonPanel and adds all buttons to it
        buttonPanel = new JPanel();
        buttonPanel.add(generate);
        buttonPanel.add(export);
        buttonPanel.add(importButton);

        //Sets the window's icon to the Dungeons and Dragons logo
        ImageIcon icon = new ImageIcon("CharacterPortraits/dnd.png");

        //Organizes the window and adds all components to it
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(icon.getImage());
        add(info, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.SOUTH);
        add(portrait, BorderLayout.EAST);

		setVisible(true);
	}//end mkWindow()

    /**
     * Implements ActionListener to create a GenerateListener that will create and display a new UserCharacter
     * when an action is performed.
     *
     * Date Created: Apr 19, 2019
     *
     * @author Ben Higgins
     */
	private class GenerateListener implements ActionListener
    {
        /**
         * Implementation of actionPerformed that creates and displays a new UserCharacter
         *
         * Date Created: Apr 19, 2019
         *
         * @param e Indicates an action has occurred
         */
        public void actionPerformed(ActionEvent e)
        {
            //Removes info and portrait from the window
            remove(info);
            remove(portrait);

            //Creates a new UserCharacter to be put into c and new a new InfoPanel and CharacterPortrait are generated
            c = new UserCharacter();
            info = new InfoPanel(c);
            portrait = new CharacterPortrait(c);

            //Adds the new InfoPanel and CharacterPortrait to the window and revalidates and repaints it to show them
            add(info, BorderLayout.WEST);
            add(portrait, BorderLayout.EAST);
            validate();
            repaint();
        }//end actionPerformed(ActionEvent)
    }//end GenerateListener

    /**
     * Implements ActionListener to create an ExportListener that will call the saveCharacter() method
     *
     * Date Created: Apr 20, 2019
     *
     * @author Ben Higgins
     */
    private class ExportListener implements ActionListener
    {
        /**
         * Implementation of actionPerformed that tries to call the saveCharacter() method
         *
         * Date Created: Apr 20, 2019
         *
         * @param e Indicates an action has occurred
         */
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                c.saveCharacter();
            }
            catch(FileNotFoundException f)
            {
                JOptionPane.showMessageDialog(null, f.getMessage());
            }//end catch(FileNotFoundException)
        }//end actionPerformed(ActionEvent)
    }//end ExportListener

    /**
     * Implements ActionListener to create an ImportListener that will create and display a new UserCharacter from a
     * text file when an action is performed.
     *
     * Date Created: Apr 20, 2019
     *
     * @author Ben Higgins
     */
    private class ImportListener implements ActionListener
    {
        /**
         * Implementation of actionPerformed that tries to call the loadCharacter() method then display it
         * in the window
         *
         * Date Created: Apr 20, 2019
         *
         * @param e Indicates an action has occurred
         */
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //Removes info and portrait from the window
                remove(info);
                remove(portrait);

                //Calls the loadCharacter method
                c.loadCharacter();

                //Creates new InfoPanel and CharacterPortrait for the new UserCharacter
                info = new InfoPanel(c);
                portrait = new CharacterPortrait(c);

                //Adds them to the window, revalidates and repaints
                add(info, BorderLayout.WEST);
                add(portrait, BorderLayout.EAST);
                validate();
                repaint();
            }
            catch (FileNotFoundException f)
            {
                JOptionPane.showMessageDialog(null, f.getMessage());
            }//end catch(FileNotFound)
        }//end actionPerformed(ActionEvent)
    }//end ImportListener
}//end mkWindow