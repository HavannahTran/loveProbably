/* Node.java
 Description: This node will have the general text; other nodes will inherit from this class.
 
 Assignment: CS230 Project
 Written by: Havannah Tran (htran)
 Modified by:
 Modified date: 05/8/2017
 */

import java.util.*;

public class Node{
  protected String text;
  
  /**
   * Constructor for the node
   * @param takes in a String, nodeText
   */
  public Node(String nodeText){
    text = nodeText;
  }
  
  /**
   * Getter method for the text on the node
   * @return text of that node 
   */
  public String getText(){
    return text;
  }
  
  /**
   * Setter method for the text on the node
   * @param takes in String newText 
   */
  public void setText(String newText){
    text = newText;
  }
  
  /*
   * toString method for the node
   * @returns String representation of the node
   */
  public String toString() {
    return "node text:\n\n" + text;
  }
}