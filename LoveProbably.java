/* LoveProbably.java
 Description: This class construct the GUI that the user interacts with. It connects 
 the panel to the story tree to build the game.
 
 Assignment: CS230 Project
 Written by: Havannah Tran (htran)
 Modified by: Kaylie Cox (kcox3)
 Modified date: 05/8/2017
 */
import javax.swing.*;

public class LoveProbably {
  
  /**
   * Main method constructs the GUI and connects it to 
   * the story tree.
   */
  public static void main (String args[]){
    JFrame frame = new JFrame ("Love, Probably");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
    StoryTree story = new StoryTree();
    JTabbedPane tp = new JTabbedPane();
    
    //create the main game panel and add that panel
    JPanel game = new GeneralPanel(story);
    JPanel info = new InfoPanel();
    JPanel about = new AboutPanel();
    tp.addTab("Main Game", game);
    tp.addTab("Love Interests", info);
    tp.addTab("About Us", about);
    
    //add content and set window size
    frame.getContentPane().add(tp);
    frame.setSize(700,550);
    
    //center the window on screen
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);      
  }
}