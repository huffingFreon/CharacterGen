/*
 * ---------------------------------------------------------------------------
 * File name: mkChar.java
 * Project name: CharacterGen
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/17/19
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;

/**
 * Driver class for random character generator
 *
 * Date Created: Apr 17, 2019
 *
 * @author Ben Higgins
 */
public class CharacterGen
{
    /**
     * Main method
     *
     * Date Created: Apr 17, 2019
     *
      * @param args Array of Strings unused in this method
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater
        (
            new Runnable()
            {
                @Override
                public void run()
                {
                    CharacterWindow window = new CharacterWindow();
                }//end run()
            }//end runnable()
        );
    }//end main(String[])
}//end CharacterGen