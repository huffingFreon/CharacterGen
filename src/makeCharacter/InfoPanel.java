/*
 * ---------------------------------------------------------------------------
 * File name: InfoPanel.java
 * Project name: mkChar
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/17/19
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel
{
    public InfoPanel(UserCharacter c)
    {
       super();

       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
    }
}