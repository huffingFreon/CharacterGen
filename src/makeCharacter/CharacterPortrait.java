package makeCharacter;

import javax.swing.*;
import java.awt.*;

public class CharacterPortrait extends JPanel
{
    public CharacterPortrait(UserCharacter c)
    {
        super();

        setLayout(new BorderLayout());

        JLabel portrait = new JLabel();

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
        }

        add(Box.createRigidArea(new Dimension(0, 25)), BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(0, 25)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(15, 0)), BorderLayout.EAST);
        add(portrait, BorderLayout.CENTER);
    }
}
