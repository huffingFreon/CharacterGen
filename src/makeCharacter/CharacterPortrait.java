/*
 * ---------------------------------------------------------------------------
 * File name: CharacterPortrait.java
 * Project name: CharacterGen
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/20/19
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;
import java.awt.*;

/**
 * Extends JPanel to produce a scaled image according to the chClass of the UserCharacter passed
 *
 * Date Created: Apr 20, 2019
 *
 * @author Ben Higgins
 */
public class CharacterPortrait extends JPanel
{
    /**
     * CharacterPortrait constructor that displays a scaled image from a relative path, depending on what
     * value is in chClass of the UserCharacter passed.
     *
     * Date Created: Apr 20, 2019
     *
     * @param c UserCharacter whose class is to be determined
     */
    public CharacterPortrait(UserCharacter c)
    {
        //Call to create the base JPanel
        super();

        setLayout(new BorderLayout());

        JLabel portrait = new JLabel();

        //Sets the JLabel's Icon to an image corresponding with the chClass String returned from c
        switch(c.getChClass())
        {
            case "Barbarian":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyBarbarian.jpg"));
                break;

            case "Bard":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyBard.jpg"));
                break;

            case "Cleric":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyCleric.jpg"));
                break;

            case "Druid":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyDruid.jpg"));
                break;

            case "Fighter":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyFighter.jpg"));
                break;

            case "Monk":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyMonk.jpg"));
                break;

            case "Paladin":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyPaladin.jpg"));
                break;

            case "Ranger":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyRanger.jpg"));
                break;

            case "Rogue":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyRogue.jpg"));
                break;

            case "Sorcerer":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinySorcerer.jpg"));
                break;

            case "Warlock":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyWarlock.jpg"));
                break;

            case "Wizard":
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyWizard.jpg"));
                break;

            default:
                portrait.setIcon(new ImageIcon("CharacterPortraits/TinyBase.jpg"));
                break;
        }//end switch()

        //Adds the JLabel and RigidAreas to the panel for uniform spacing
        add(Box.createRigidArea(new Dimension(0, 25)), BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0, 25)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(15, 0)), BorderLayout.EAST);
        add(portrait, BorderLayout.CENTER);
    }//end CharacterPortrait(UserCharacter)
}//end CharacterPortrait