/* InfoPanel.java
 Description: This panel will include information about the 3 different characters in the game.

 CS230 Project
 Written by: Havannah Tran (htran) & Kaylie Cox (kcox3)
 Modified by: Kaylie Cox (kcox3)
 Modified date: 05/08/2017
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class InfoPanel extends JPanel
{
  public JLabel vanText, shaynText, kavaText; //prompt text and directions
  public BufferedImage van, shayn, kavanique;
  
  /**
   * Sets up in this panel a label introducing this application and subsequent options
   */
  public InfoPanel() {
    setLayout(new GridLayout(3,2));
    setBackground(Color.pink);
    
    //Create the three character images
    //Use try catch statements to catch IOException errors
    try {                
      van = ImageIO.read(new File("van.png"));
    } catch (IOException ex) {
      System.out.println(ex);
    }
    
    try {                
      shayn = ImageIO.read(new File("shayn.png"));
    } catch (IOException ex) {
      System.out.println(ex);
    }
    
    try {                
      kavanique = ImageIO.read(new File("kavanique.png"));
    } catch (IOException ex) {
      System.out.println(ex);
    }
    
    JLabel vanPic = new JLabel(new ImageIcon(van));
    JLabel shaynPic = new JLabel(new ImageIcon(shayn));
    JLabel kavaPic = new JLabel(new ImageIcon(kavanique));
    
    //Create the corresponding text for the three characters
    vanText = new JLabel("<html> <b>Alixanzar Van Endirgraflirgrlre (Van) </b> <br>" + 
                         "<i>Pronouns</i>: she/her/hers <br>"+
                         "<i>Age</i>: 18 <br>" + 
                         "<i>Background</i>: Shy scientist/student <br>" + 
                         "<i>Alignment</i>: Lawful Evil <br>" +
                         "<i>Class</i>: Astronomy 218: Planetary Happenings of "+
                         "Ryder Prime (with field trips!)<br><html>");
    
    shaynText = new JLabel ("<html><b>Shayn</b><br>" + 
                            "<i>Pronouns</i>: they/them <br>" + 
                            "<i>Age</i>: 19 <br>"+ 
                            "<i>Background</i>: Grew up at Ryder Prime, has military parents, " + 
                            "moved around a lot, has no close friends <br>" +
                            "<i>Alignment</i>: Chaotic Neutral<br>" + 
                            "<i>Class: Ecology 263</i>: Plants, Animals, and " + 
                            "the Dangerous Ecology of our New Planet</html>");
    
    kavaText = new JLabel ("<html><b>Kavanique</b><br>"+
                           "<i>Pronouns</i>: they/them <br>"+
                           "<i>Age</i>: 22 <br>" + 
                           "<i>Background</i>: prodigy child, also really "+ 
                           "good/passion at d&d (roleplaying), "+
                           "#savethegoat (goats are endangered on this planet)<br>"+
                           "<i>Alignment</i>: True Neutral<br>" +
                           "<i>Class</i>: Theater 342: Old McDonald’s Farm</html>");
    
    //Add the pictures and text to the panel
    add(vanPic);
    add(vanText);
    add(shaynPic);
    add(shaynText);
    add(kavaPic);
    add(kavaText);  
  } 
}
