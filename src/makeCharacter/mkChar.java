/*
 * ---------------------------------------------------------------------------
 * File name: mkChar.java
 * Project name: mkChar
 * ---------------------------------------------------------------------------
 * Creator's name and email: Ben Higgins, higginsba@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: 4/17/19
 * ---------------------------------------------------------------------------
 */

package makeCharacter;

import javax.swing.*;

public class mkChar
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater
        (
            new Runnable()
            {
                @Override
                public void run()
                {
                    mkWindow window = new mkWindow();
                }
            }
        );
    }
}
