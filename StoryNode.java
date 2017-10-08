/* StoryNode.java
 Description: This node be used in two cases: questions and story-line passages 
 (story line passages will only have more background text and one "option" that says to continue).
 
 Assignment: CS230 Project
 Written by: Havannah Tran (htran)
 Modified by:
 Modified date: 05/8/2017
 */

import java.util.*;

public class StoryNode extends Node{
  private Hashtable <String,Node> options;
  
  /**
   * Constructor for the StoryNode object
   */
  public StoryNode(String nodeText, String[] answers, Node[] nextNodes){
    super(nodeText);
    this.options = new Hashtable<String, Node>();
    for (int i = 0; i < answers.length; i++){
      this.options.put(answers[i], nextNodes[i]);
    }
  }
  
  /**
   * Getter method for option that the user chooses
   * 
   * @param String choice
   * @return Node object based upon the choice input
   */
  public Node getOption(String choice){
    return options.get(choice);
  }
  
  /**
   * Getter method that returns the Hashtable
   * @return Hashtable options
   */
  public Hashtable<String,Node> getHashtable(){
    return options;
  }
  
  /**
   * Boolean method to check if the user's choice
   * is a valid option.
   * @param String choice
   * @return true if the entered option is found within the
   * Hashtable (options), false if not
   */
  public boolean isOption(String choice){
    return this.getHashtable().containsKey(choice);
  }
  
  /**
   * Static method that will return the original node
   * @return node
   */
  public static StoryNode cloneStoryNode(StoryNode node) {
    return node;
  }
  
}