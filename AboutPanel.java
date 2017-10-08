/* AboutPanel.java
 Description: This panel will include information of the 3 different characters in the game.

 CS230 Project
 Written by: Dominique Huang (dhuang2)
 Modified by:
 Modified date: 05/07/2017
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;


public class AboutPanel extends JPanel
{
  public JLabel aboutText; 
  public BufferedImage groupPic;
  
  /**Constructor for the AboutPanel that
   * Sets up in this panel a picture and a label introducing the game
   */
  public AboutPanel() {
    setLayout(new BorderLayout(2,2));
    setBackground(Color.pink);
    
    //Add a group picture
    //Use a try catch statement to catch IOException errors
    try {                
      groupPic = ImageIO.read(new File("GroupPicture.png"));
    } catch (IOException ex) {
      System.out.println(ex);
    }
    
    JLabel group = new JLabel(new ImageIcon(groupPic));
    
    
    //Create the paragraph to describe us and our project
    aboutText = new JLabel("<html> <b>About Us </b> <br><br>" + 
                         "Dominique, Kaylie, and Havannah are students at Wellesey College. "+
                         "They took CS230: Data Structures together, and made this game to apply the skills and " + 
                         "structures they learned. This game is built using a graph and hashtables." + 
                         "<br><br>Hope you enjoy our project, and find love, probably?<html>");
    
    group.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));
    aboutText.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

    
    

    //Add the picture and text to the panel
    add(group, BorderLayout.CENTER);
    add(aboutText, BorderLayout.SOUTH);
  } 
}