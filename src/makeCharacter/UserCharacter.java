/*
 * ---------------------------------------------------------------------------
 * File name: Character.java
 * Project name: mkChar
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/15/2019
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserCharacter
{
    private String name = "";
    private String alignment = "";
    private String race = "";
    private String chClass = "";
    private String background = "";

    UserCharacter()
    {
        try
        {
            setName(randomName());
            setRace(randomRace());
            setClass(randomClass());
            setBackground(randomBackground());
        }
        catch (FileNotFoundException f)
        {
            JOptionPane.showMessageDialog(null, "Character data file not found");
        }

        setAlignment(randomAlignment());
    }

    private void setName(String name)
    {
        this.name = name;
    }

    private void setAlignment(String alignment)
    {
        this.alignment = alignment;
    }

    private void setRace(String race)
    {
        this.race = race;
    }

    private void setClass(String chClass)
    {
        this.chClass = chClass;
    }

    private void setBackground(String background)
    {
        this.background = background;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAlignment()
    {
        return this.alignment;
    }

    public String getRace()
    {
        return this.race;
    }

    public String getChClass()
    {
        return this.chClass;
    }

    public String getBackground()
    {
        return this.background;
    }

    private String randomName() throws FileNotFoundException
    {
        String strName;
        File nameFile = new File("CharacterData/Names.txt");
        Scanner fileScanner = new Scanner(nameFile);
        Random ran = new Random();
        ArrayList<String> lines = new ArrayList<>();

        while(fileScanner.hasNext())
        {
            lines.add(fileScanner.nextLine());
        }

        fileScanner.close();

        strName = lines.get(ran.nextInt(lines.size()));

        return strName;
    }

    private String randomRace() throws FileNotFoundException
    {
        String strRace;
        File raceFile = new File("CharacterData/Races.txt");
        Scanner fileScanner = new Scanner(raceFile);
        Random ran = new Random();
        ArrayList<String> lines = new ArrayList<>();

        while(fileScanner.hasNext())
        {
            lines.add(fileScanner.nextLine());
        }

        fileScanner.close();

        strRace = lines.get(ran.nextInt(lines.size()));

        return strRace;
    }

    private String randomClass() throws FileNotFoundException
    {
        String strClass;
        File classFile = new File("CharacterData/Classes.txt");
        Scanner fileScanner = new Scanner(classFile);
        Random ran = new Random();
        ArrayList<String> lines = new ArrayList<>();

        while(fileScanner.hasNext())
        {
            lines.add(fileScanner.nextLine());
        }

        fileScanner.close();

        strClass = lines.get(ran.nextInt(lines.size()));

        return strClass;
    }

    private String randomBackground() throws FileNotFoundException
    {
        String strBackground;
        File backgroundFile = new File("CharacterData/Backgrounds.txt");
        Scanner fileScanner = new Scanner(backgroundFile);
        Random ran = new Random();
        ArrayList<String> lines = new ArrayList<>();

        while(fileScanner.hasNext())
        {
            lines.add(fileScanner.nextLine());
        }

        fileScanner.close();

        strBackground = lines.get(ran.nextInt(lines.size()));

        return strBackground;
    }

    private String randomAlignment()
    {
        String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral",
                               "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        String strAlignment;
        Random ran = new Random();

        strAlignment = alignments[ran.nextInt(9)];

        return strAlignment;
    }

    public void saveCharacter() throws FileNotFoundException
    {
       JFileChooser save = new JFileChooser("SavedCharacters");
       int iResult = save.showSaveDialog(null);

       if(iResult != JFileChooser.APPROVE_OPTION)
       {
           JOptionPane.showMessageDialog(null, "No file selected");
       }
       else
       {
          String fileName = save.getSelectedFile().getPath();
          PrintWriter pw = new PrintWriter(fileName);

          pw.println(getName());
          pw.println(getAlignment());
          pw.println(getRace());
          pw.println(getChClass());
          pw.println(getBackground());

          pw.close();
       }
    }

    public void loadCharacter() throws FileNotFoundException
    {
        JFileChooser open = new JFileChooser("SavedCharacters");
        int iResult = open.showOpenDialog(null);
        ArrayList<String> lines = new ArrayList<>();

        if(iResult != JFileChooser.APPROVE_OPTION)
        {
            JOptionPane.showMessageDialog(null, "No file selected");
        }
        else
        {
           String fileName = open.getSelectedFile().getPath();
           File loadFIle = new File(fileName);
           Scanner load = new Scanner(loadFIle);

           while(load.hasNext())
           {
               lines.add(load.nextLine());
           }

           setName(lines.get(0));
           setAlignment(lines.get(1));
           setRace(lines.get(2));
           setClass(lines.get(3));
           setBackground(lines.get(4));

           load.close();
        }
    }
}
