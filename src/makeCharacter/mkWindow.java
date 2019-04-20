/*
 * ---------------------------------------------------------------------------
 * File name: mkWindow.java
 * Project name: mkChar
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

public class mkWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	final int WINDOW_WIDTH = 400,
			  WINDOW_HEIGHT = 300;
	private InfoPanel info;
	private CharacterPortrait portrait;
    private UserCharacter c;
    private JButton generate;
    private JButton export;
    private JPanel buttonPanel;

	public mkWindow()
	{
		super("Random Character Generator");

		c = new UserCharacter();
        info = new InfoPanel(c);
        portrait = new CharacterPortrait(c);
        generate = new JButton("Generate!");
        generate.addActionListener(new GenerateListener());
        export = new JButton("Export");
        export.addActionListener(new ExportListener());
        buttonPanel = new JPanel();
        buttonPanel.add(generate);
        buttonPanel.add(export);
        ImageIcon icon = new ImageIcon("CharacterPortraits/dnd.png");

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
	}

	private class GenerateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            remove(info);
            remove(portrait);
            c = new UserCharacter();
            info = new InfoPanel(c);
            portrait = new CharacterPortrait(c);
            add(info, BorderLayout.WEST);
            add(portrait, BorderLayout.EAST);
            validate();
            repaint();
        }
    }

    private class ExportListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                c.saveCharacter();
            }
            catch(FileNotFoundException f)
            {
                JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
    }
}
