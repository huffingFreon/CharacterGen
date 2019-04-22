/*
 * ---------------------------------------------------------------------------
 * File name: Character.java
 * Project name: CharacterGen
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

/**
 * Class used for the generation of randomized Dungeons and Dragons characters
 *
 * Date Created: Apr 15, 2019
 *
 * @author Ben Higgins
 */
public class UserCharacter
{
    private String name = "";                       //character's name
    private String alignment = "";                  //character's alignment
    private String race = "";                       //character's race
    private String chClass = "";                    //character's class
    private String background = "";                 //character's background

    /**
     * Base constructor. Creates a new and randomized character each time it is called.
     *
     * Date Created: Apr 15, 2019
     */
    UserCharacter()
    {
        try
        {
            setName(randomName());
            setAlignment(randomAlignment());
            setRace(randomRace());
            setClass(randomClass());
            setBackground(randomBackground());
        }
        catch (FileNotFoundException f)
        {
            JOptionPane.showMessageDialog(null, "Character data file not found");
        }//end catch(FileNotFoundException)
    }//end UserCharacter()

    /**
     * Name setter
     *
     * Date Created: Apr 15, 2019
     *
     * @param name Name to be set
     */
    private void setName(String name)
    {
        this.name = name;
    }//end setName(String)

    /**
     * Alignment setter
     *
     * Date Created: Apr 15, 2019
     *
     * @param alignment Alignment to be set
     */
    private void setAlignment(String alignment)
    {
        this.alignment = alignment;
    }//end setAlignment(String)

    /**
     * Race setter
     *
     * Date Created: Apr 15, 2019
     *
     * @param race Race to be set to
     */
    private void setRace(String race)
    {
        this.race = race;
    }//end setRace(String)

    /**
     * Class setter
     *
     * Date Created: Apr 15, 2019
     *
     * @param chClass Class to be set to
     */
    private void setClass(String chClass)
    {
        this.chClass = chClass;
    }//end setClass(String)

    /**
     * Background setter
     *
     * Date Created: Apr 15, 2019
     *
     * @param background Background to be set to
     */
    private void setBackground(String background)
    {
        this.background = background;
    }//end setBackground(String)

    /**
     * Name getter
     *
     * Date Created: Apr 15, 2019
     *
     * @return this.name The current name of the character
     */
    public String getName()
    {
        return this.name;
    }//end getName()

    /**
     * Alignment getter
     *
     * Date Created: Apr 15, 2019
     *
     * @return this.alignment The current alignment of the character
     */
    public String getAlignment()
    {
        return this.alignment;
    }//end getAlignment()

    /**
     * Race getter
     *
     * Date Created: Apr 15, 2019
     *
     * @return this.race The current race of the character
     */
    public String getRace()
    {
        return this.race;
    }//end getRace()

    /**
     * Class getter
     *
     * Date Created: Apr 15, 2019
     *
     * @return this.chClass The current class of the character
     */
    public String getChClass()
    {
        return this.chClass;
    }//end getChClass()

    /**
     * Background getter
     *
     * Date Created: Apr 15, 2019
     *
     * @return this.background The current background of the character
     */
    public String getBackground()
    {
        return this.background;
    }//end getBackground()

    /**
     * Loads a text file of names into an ArrayList and returns one selected at random
     *
     * Date Created: Apr 15, 2019
     *
     * @return strName The randomly selected name
     * @throws FileNotFoundException If the Names file is not found at the relative location
     */
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
        }//end while()

        fileScanner.close();

        strName = lines.get(ran.nextInt(lines.size()));

        return strName;
    }//end randomName()

    /**
     * Loads a text file of races into an ArrayList and returns one selected at random
     *
     * Date Created: Apr 15, 2019
     *
     * @return strRace The randomly selected race
     * @throws FileNotFoundException If the Races file is not found at the relative location
     */
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
        }//end while()

        fileScanner.close();

        strRace = lines.get(ran.nextInt(lines.size()));

        return strRace;
    }//end randomRace()

    /**
     * Loads a text file of classes into an ArrayList and returns one selected at random
     *
     * Date Created: Apr 15, 2019
     *
     * @return strClass The randomly selected class
     * @throws FileNotFoundException If the Classes file is not found at the relative location
     */
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
        }//end while()

        fileScanner.close();

        strClass = lines.get(ran.nextInt(lines.size()));

        return strClass;
    }//end randomClass()

    /**
     * Loads a text file of backgrounds into an ArrayList and returns one selected at random
     *
     * Date Created: Apr 15, 2019
     *
     * @return strBackground The randomly selected background
     * @throws FileNotFoundException If the Backgrounds file is not found at the relative location
     */
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
        }//end while()

        fileScanner.close();

        strBackground = lines.get(ran.nextInt(lines.size()));

        return strBackground;
    }//end randomBackground()

    /**
     * Chooses a random alignment from an array containing all nine possible alignments.
     *
     * Date Created: Apr 15, 2019
     *
     * @return strAlignment The randomly selected alignment
     */
    private String randomAlignment()
    {
        String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral",
                               "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        String strAlignment;
        Random ran = new Random();

        strAlignment = alignments[ran.nextInt(9)];

        return strAlignment;
    }//end randomAlignment()

    /**
     * Takes the attributes of the current UserCharacter and writes them to a text file
     *
     * Date Created: Apr 15, 2019
     *
     * @throws FileNotFoundException If the directory passed does not exist
     */
    public void saveCharacter() throws FileNotFoundException
    {
       //Opens a JFileChooser box in the SavedCharacters folder, relative to where the code is currently at
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
       }//end if()
    }//end saveCharacter()

    /**
     * Loads a character from a text file
     *
     * Date Created: Apr 15, 2019
     * @throws FileNotFoundException If the file passed does not exist
     */
    public void loadCharacter() throws FileNotFoundException
    {
        //Opens a JFileChooser box in the SavedCharacters folder, relative to where the code is currently at
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
           }//end while()

           setName(lines.get(0));
           setAlignment(lines.get(1));
           setRace(lines.get(2));
           setClass(lines.get(3));
           setBackground(lines.get(4));

           load.close();
        }//end if()
    }//end loadCharacter()
}//end UserCharacter