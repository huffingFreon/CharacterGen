/*
 * ---------------------------------------------------------------------------
 * File name: InfoPanel.java
 * Project name: CharacterGen
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/17/19
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;
import java.awt.*;

/**
 * Extends JPanel class to create a formatted collection of JLabels that display details about a UserCharacter
 *
 * Date Created: Apr 17, 2019
 *
 * @author Ben Higgins
 */
public class InfoPanel extends JPanel
{
   /**
    * InfoPanel constructor that takes information from the passed UserCharacter, formats, and displays it.
    *
     * @param c UserCharacter whose information is displayed
    */
    public InfoPanel(UserCharacter c)
    {
       //Call to create the base JPanel
       super();

       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

       //Creating JLabels with UserCharacter information and formatting them to the appropriate size and font
       JLabel nameLabel = new JLabel("Name: " + c.getName());
       nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

       JLabel alignmentLabel = new JLabel("Alignment: " + c.getAlignment());
       alignmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

       JLabel raceLabel = new JLabel("Race: " + c.getRace());
       raceLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

       JLabel classLabel = new JLabel("Class: " + c.getChClass());
       classLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

       JLabel backgroundLabel = new JLabel("Background: " + c.getBackground());
       backgroundLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

       //Adding JLabels and RigidAreas to the panel for uniform spacing
       add(Box.createRigidArea(new Dimension(0, 50)));
       add(nameLabel);
       add(Box.createRigidArea(new Dimension(0, 10)));
       add(alignmentLabel);
       add(Box.createRigidArea(new Dimension(0, 10)));
       add(raceLabel);
       add(Box.createRigidArea(new Dimension(0, 10)));
       add(classLabel);
       add(Box.createRigidArea(new Dimension(0, 10)));
       add(backgroundLabel);
    }//end InfoPanel(UserCharacter)
}//end InfoPanel