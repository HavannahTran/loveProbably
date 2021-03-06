/*StoryTree.java
 Description: This class will build the tree.
 
 Assignment: CS230 Project
 Written by: Kaylie Cox (kcox3), Dominique Huang (dhuang3)
 Modified by:
 Modified date: 05/8/2017
 */

import java.util.*;
import java.io.*;

public class StoryTree {
  
  //Instance variables 
  private Node currentNode;
  private boolean isOver;
  private String playerName; 
  
  /**
   * Helper method that creates the tree by creating
   * StoryNodes for the plot and EndNodes at the end
   * of each storyline.
   */
  public StoryNode createNodeText() {
    
    /***********************************************************************
      *            CONSTRUCTING THE TEXT
      * 
      * Each node is named in a system that helps keep track of where 
      * in the tree it is. For example, the root of the story is text_1. The next 
      * node off of that is 1_1. At this point the first important decision 
      * is made by the player, and the tree branches into 1_1_1, 
      * 1_1_2, and 1_1_3. 1 represents the left-most branch then, and 
      * the highest final number represents the right-most branch.
      * 
      * OpeningNode is the root for the whole tree, and is the intro screen
    ************************************************************************/
    //Opening
    String openingText = "<html> <br> Welcome to...<br><h1>" +
      "Love, Probably? </h1> <br><br><br><i>Enter C to start</i></html>";
    String [] opening_options = {"C"};
    
    //Level 1:
    String text_1 = "<html><p><br><br>Hello! Welcome to Ryder Prime University (RPU). <br>" + 
      "We hope you've awaken from your space-stasis and are ready to join our beautiful <br>" +
      "planet of Ryder Prime!" + 
      "<br><br><i>Enter C to continue</i></p></html>"; 
    String [] node_1_options =  {"C"};
    
    
    //Level 2:
    String text_1_1 = "<html><p><br><br>Great! <br>" +
      "One thing before you begin. Here at RPU we work on a block trimester system.<br>" +
      "This means you'll be taking one class for three weeks! <br>" + 
      "Please pick from one of the fine classes we are currently offering below:<br>" + 
      "<br>A. Ecology 263: Plants, Animals, and the Dangerous Ecology of our New Planet" +
      "<br>B. Astronomy 218: Planetary Happenings of Ryder Prime (with field trips!)" + 
      "<br>C. Theater 342: Old McDonald's Farm" + 
      "<br><br>\t<i>Enter the letter to continue. (i.e. A for Ecology 263)</i></p></html>"; 
    String [] node_1_1_options = {"A","B","C"};
    
    
    //Level 3:
    String text_1_1_1 = "<html><p><br>Great choice! They say Ecology 263: <br>" +
      "Plants, Animals, and the Dangerous Ecology of our New Planet<br>" +
      "is an exciting class here!<br>" + 
      "<br>Now, you should head back to your dorm and get settled before <br>" +
      "class tomorrow! Oh! One more thing! RPU is getting ready for its annual<br>" +
      "Settlement Festival - a celebration of our new life here on Ryder Prime!<br>" + 
      "Legend has it that if you find a date to your first festival,<br>" + 
      "you'll live happily-ever-after together! Good luck!<br><br>" +
      "As you head back to your dorm, you think about the events that led you <br>" +
      "to this point in your life. 300 years ago you left your home planet, Earth.<br>" +
      "Overpopulation and utter lack of care for the planet led to a<br>" + 
      "bio-nuclear war in 3042 over the scarce resources. You managed<br>" +
      "to secure passage on a ship to Ryder Prime, a new hospitable planet<br>" +
      "discovered by NASA in 2017, by agreeing to a series of medical<br>" +
      "tests that were conducted in secret by an anonymous donor.<br>" +
      "After being poked, prodded, and examined for countless<br>" +
      "hours, you overcame the odds and somehow survived.<br>" +
      "They put you in stasis for the flight (which took 300 years) and <br>" +
      "the next thing you knew, here you were on this new planet! <br>" +
      "With this incredible opportunity, you will be able to start a new<br>" +
      "life, and even find love, probably?<br><br><i>Enter C to continue</i></html>";
    String [] node_1_1_1_options =  {"C"};
    
    String text_1_1_2 = "<html><p><br><br>Great choice! They say Astronomy 218: <br>" +
      "Planetary Happenings of Ryder Prime is an exciting class here!<br>" + 
      "<br>Now, you should head back to your dorm and get settled before <br>" +
      "class tomorrow! Oh! One more thing! RPU is getting ready for its annual <br>" +
      "Settlement Festival - a celebration of our new life here on Ryder Prime!<br>" + 
      "Legend has it that if you find a date to your first festival, <br>" + 
      "you'll live happily-ever-after together! Good luck!<br><br>" +
      "As you head back to your dorm, you think about the events that led you <br>" +
      "to this point in your life. 300 years ago you left your home planet, Earth. <br>" +
      "Overpopulation and utter lack of care for the planet led to a <br>" + 
      "bio-nuclear war in 3042 over the scarce resources. You managed <br>" +
      "to secure passage on a ship to Ryder Prime, a new hospitable planet <br>" +
      "discovered by NASA in 2017, by agreeing to a series of medical <br>" +
      "tests that were conducted in secret by an anonymous donor. <br>" +
      "After being poked, prodded, and examined for " +
      "countless hours,<br> you overcame the odds and somehow survived.<br>" +
      "They put you in stasis for the flight (which took 300 years) and <br>" +
      "the next thing you knew, here you were on this new planet! <br>" +
      "With this incredible opportunity, you will be able to start a new<br>" +
      "life, and even find love, probably?<br><br><i>Enter C to continue</i></html>";
    String [] node_1_1_2_options =  {"C"};
    
    String text_1_1_3 = "<html><p><br><br>Great choice! They say Theater 342: <br>" +
      "Old McDonald's Farm, is an exciting class here!<br>" + 
      "<br>Now, you should head back to your dorm and get settled before <br>" +
      "class tomorrow! Oh! One more thing! RPU is getting ready for its annual <br>" +
      "Settlement Festival - a celebration of our new life here on Ryder Prime!<br>" + 
      "Legend has it that if you find a date to your first festival, <br>" + 
      "you'll live happily-ever-after together! Good luck!<br><br>" +
      "As you head back to your dorm, you think about the events that led you <br>" +
      "to this point in your life. 300 years ago you left your home planet, Earth. <br>" +
      "Overpopulation and utter lack of care for the planet led to a <br>" + 
      "bio-nuclear war in 3042 over the scarce resources. You managed <br>" +
      "to secure passage on a ship to Ryder Prime, a new hospitable planet <br>" +
      "discovered by NASA in 2017, by agreeing to a series of medical <br>" +
      "tests that were conducted in secret by an anonymous donor.<br>" +
      "After being poked, prodded, and examined for " +
      "countless hours,<br> you overcame the odds and somehow survived.<br>" +
      "They put you in stasis for the flight (which took 300 years) and <br>" +
      "the next thing you knew, here you were on this new planet! <br>" +
      "With this incredible opportunity, you will be able to start a new<br>" +
      "life, and even find love, probably?<br><br><i>Enter C to continue</i></html>";
    String [] node_1_1_3_options =  {"C"};
    
    
    //Level 4:
    String text_1_1_1_1 = "<html><p><br><br>You wake up to the sound of your alarm the<br>" +
      "next morning. Your mind is foggy and your body is <br>" + 
      "heavy with post-stasis fatigue. You could probably skip class <br>" +
      "today, but maybe you should force yourself to get up <br>" + 
      "and go to class. What will you do?<br>" + 
      "<br>A. Go to class!" + 
      "<br>B. Skip!</p></html>";
    String [] node_1_1_1_1_options =  {"A", "B"};
    
    String text_1_1_2_1 = "<html><p><br><br>You wake up to the sound of your alarm the<br>" +
      "next morning. Your mind is foggy and your body is <br>" + 
      "heavy with post-stasis fatigue. You could probably skip class <br>" +
      "today, but maybe you should force yourself to get up <br>" + 
      "and go to class. What will you do?<br>" + 
      "<br>A. Go to class!" + 
      "<br>B. Skip!</p></html>";
    String [] node_1_1_2_1_options = {"A", "B"};
    
    String text_1_1_3_1 = "<html><p><br><br>You wake up to the sound of your alarm the<br>" +
      "next morning. Your mind is foggy and your body is <br>" + 
      "heavy with post-stasis fatigue. You could probably skip class <br>" +
      "today, but maybe you should force yourself to get up <br>" + 
      "and go to class. What will you do?<br>" + 
      "<br>A. Go to class!" + 
      "<br>B. Skip!</p></html>";
    String [] node_1_1_3_1_options = {"A", "B"};
    
    
    //Level 5:   
    String text_1_1_1_1_1 = "<html><p><br><br>You decide that you'd better get yourself out of<br>" +
      "bed and go to class. Classes won't wait for the weary,<br>" + 
      "and you need to get good grades if you're going to really take <br>" +
      "advantage of this new start! After showering and getting breakfast,<br>" + 
      "you check your holo-watch for the location of your class. You hurry over<br>" +
      "and sneak in just before the starting time, taking<br>" + 
      "a seat near the window.<br><br>The professor starts to lecture about the bomus,<br>" +
      "a native animal similar to Earth's cow, and its impact on the planet's<br>" +
      "ecosystem, and you start to take notes. When the professor asks a question,<br>"+
      "you notice the student sitting beside you raise their hand. They're<br>" +
      "wearing a dark red hoodie with a cool geometric design running over the chest.<br>" + 
      "To be honest, you weren't really expecting them to be the \"raise your hand in<br>" +
      "class\" type of person; especially because you <br>" + 
      "thought they were asleep up until this point.<br>" +
      "<br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_1_1_1_options = {"C"};
    
    String text_1_1_2_1_1 = "<html><p><br><br>You decide that you'd better get yourself out of<br>" +
      "bed and go to class. Classes won't wait for the weary,<br>" +
      "and you need to get good grades if you're going to really take<br>" +
      "advantage of this new start!<br><br>After showering and getting breakfast,<br>" + 
      "you check your holo-watch for the location of your class. You hurry<br>" +
      "over and sneak in just before the starting time, taking a seat<br>" + 
      "near the window. The professor starts their lecture, and you start to<br>" +
      "take notes.<br><br>About an hour into the class, the professor tells<br>" + 
      "you to pair up with someone and begin the lab experiment. You frantically<br>" +
      "glance around the room, and notice that everyone else<br>" + 
      "already seems to have partnered up. You are about to resign yourself<br>" +
      "to working alone when you notice that there is one other<br>" + 
      "student who doesn't have a partner.<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_2_1_1_options = {"C"};
    
    String text_1_1_3_1_1 = "<html><p><br><br>You decide that you'd better get yourself<br>" +
      "out of bed and go to class. Classes won't wait for the weary,<br>" + 
      "and you need to get good grades if you're going to really take<br>" +
      "advantage of this new start! After showering and getting breakfast,<br>" +
      "you check your holo-watch for the location of your class. You hurry<br>" +
      "over to a large outdoor amphitheater. You see most of the students<br>" + 
      "just milling around the area. There seems to be no professor present,<br>" +
      "but you notice an authoritative goat stand up on the stage.<br>" + 
      "\"Attention students! We shall now begin our readthrough of the classical<br>" +
      "play from the 20th century, \"Old McDonald's Farm.\" I shall<br>" + 
      "begin first.\" At this point you realize that the thing that you<br>" +
      "thought was a goat, is actually a person inside of an elaborate goat<br>" + 
      "onesie! The goat person begins handing out scripts, letting out \"baaahhh!\"<br>"+
      "noises as they go.<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_3_1_1_options = {"C"};
    
    
    String text_1_1_1_1_2 = "<html><p><br><br>\"Going to class is for the weak, and I deserve to<br>" +
      "rest since I just got here\" you say to yourself as you grab a<br>" +
      "quick bite to eat and head outside to take a nap. Just as you find<br>" +
      "a nice secluded spot, however, you feel an intense pain in your<br>" + 
      "abdomen. You fall to the ground and curl into ball, clutching your<br>" +
      "stomach. You try to call out for help, but suddenly you find yourself<br>" + 
      "unable to speak, and only a \"bahh!\" noise escapes. You notice your<br>" +
      "arms are beginning to grow hair at an alarming rate, and suddenly it feels<br>" + 
      "like every bone in your body is breaking at once. Your vision goes dark.<br>" +
      "When you awake, you notice you've been turned into a goat! I guess <br>" + 
      "those medical tests weren't so safe after all.<br><br>" +
      "<b>THE END</b></p></html>";
    
    
    //Level 6:
    String text_1_1_1_1_1_1 = "<html><p><br><br>The professor calls on the student. They quickly<br>" +
      "answer the question correctly, then begin doodling in their notebook.<br>" +
      "You look over and try to catch a glance of what it is they're drawing.<br><br>" +
      "You see a comic picture of a bomus and a cow grazing together, with the<br>" +
      "cow saying \"moooove over,\" as it tries to eat the grass in front of the bomus.<br>" +
      "It is quite certainly the cheesiest, and lamest, joke you've ever heard,<br>" +
      "but the person who drew it seems to be quite entertained, as you hear<br>" +
      "them softly laugh to themselves. As the class draws to an end, the<br>" +
      "professor reminds the class that you have an assignment due tomorrow,<br>" +
      "and that you can choose to either work alone or in a pair of two.<br>" +
      "<br>A. Work alone" + 
      "<br>B. Work with the person drawing</p></html>";
    String [] node_1_1_1_1_1_1_options = {"A", "B"};
    
    String text_1_1_2_1_1_1 = "<html><p><br><br>Thinking this is your lucky day, you walk over to<br>" +
      "them and introduce yourself. <br><br>\"Hi! Wanna partner up?\"<br><br>" +
      "It almost feels as if you're invisible to them the way they look you,<br>" +
      "but they introduce themselves.<br><br>" +
      "\"I'm Van. Well. Technically I'm Alixanzar Van Endirgraflirgrlre,<br>" +
      "but everyone calls me Van. She/her pronouns please.\"<br>" +
      "<br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_2_1_1_1_options = {"C"};
    
    String text_1_1_3_1_1_1 = "<html><p><br><br>As the goat person approaches you, they pause, obviously<br>" +
      "not knowing who you are, since you're new and all.<br><br>" +
      "You begin to introduce yourself. \"Oh, uhm, hi, I'm–\"<br><br>" +
      "\"BAHHHH!\" The person yells out a loud goat noise, and begins jumping<br>" +
      "up and down. <br><br>" +
      "Another student comes up to you and says, \"Oh, that's Kavanique,<br>" +
      "they use they/them pronouns. They take their roles very seriously when<br>" +
      "they act, and since we're doing Old McDonald's Farm, well... you see<br>" +
      "the result.\"<br><br>" +
      "Without another word, they walk away leaving you alone with Kavanique.<br>" +
      "<br>A. Continue trying to talk to Kavanique" +
      "<br>B. Walk away slowly, in case they try to attack</p></html>";
    String [] node_1_1_3_1_1_1_options = {"A", "B"};
    
    
    //Level 7:
    String text_1_1_1_1_1_1_1 = "<html><p><br><br>While the person who is drawing is cute, you're<br>" +
      "really nervous and your hands get clammy. You're wiping your<br>" +
      "hands on your jeans and when you look up it looks like your<br>" +
      "friend has found a partner. Looks like you're working alone then.<br><br>" +
      "While you're procrastinating from working, you realize you have<br>" +
      "a knack for the subject of computer science! You start studying<br>" +
      "intensely and somehow solve an NP-complete problem!<br><br>" +
      "Your work awes the world, and you become a millionaire!<br>" +
      "You quit school and live the rest of your life as a recluse." +
      "<br><br><b>THE END</b></p></html>"; 
    
    String text_1_1_1_1_1_1_2 = "<html><p><br><br>Your eyes meet with your drawing friend again.<br>" +
      "You blush out of embarrassment and in a panic, you ask them if<br>" +
      "they want to be partners with you.<br><br>" +
      "They say, \"Sure, but I need to know my partner's name. My name<br>" +
      "is Shayn. I go by they/them.\"<br><br>" + 
      "You shuffle a little bit and Shayn looks at you in anticipation.<br><br>" +
      "You give your name and exchange numbers, and decide to meet<br>" +
      "tomorrow after class to work on your assignment.<br><br>" +
      "<i>Enter C to continue</i></p></html>"; 
    String [] node_1_1_1_1_1_1_2_options = {"C"};
    
    String text_1_1_2_1_1_1_1 = "<html><p><br><br>As she introduces herself, she reaches out and plucks a<br>" +
      "hair from your head. You cringe and ask why she did that,<br>" +
      "but she shrugs and begins working on the experiment.<br><br>" +
      "What do you want to do?<br>" +
      "<br>A. Ignore her and work alone" + 
      "<br>B. Work on the experiment with her</p></html>";
    String [] node_1_1_2_1_1_1_1_options = {"A","B"};
    
    String text_1_1_3_1_1_1_1 = "<html><p><br><br>Sure Kavanique is a little odd, but they seem<br>" +
      "like a really dedicated person! <br><br>" +
      "You decide to try to communicate with them some more. They look<br>" +
      "at you quizzically every time you speak, until finally you<br>" +
      "try to make a goat sound.\"..bahh?\"<br><br>" +
      "Your attempt is pretty pathetic,if you're being honest, but<br>" +
      "Kavanique seems thrilled by it,and a smile lights up their face.<br><br>" +
      "You notice just how nice of a light green shade their eyes are,<br>" +
      "and the cute angle of the cowlick in the front of their hair – or<br>" +
      "should you call it a goatlick?" +
      "<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_3_1_1_1_1_options = {"C"};
    
    String text_1_1_3_1_1_1_2 = "<html><p><br><br>You begin slowly backing away, trying not to<br>" +
      "make eye contact with them. Luckily, they quickly lose interest<br>" +
      "and run/jump/frolic away into the crowd.<br><br>" +
      "You let out a sigh of relief before realizing you never got a script<br>" +
      "from them! You go to turn to the person closest to you, but find<br>" +
      "that everyone else has already received a script and has wandered<br>" +
      "onto the stage.<br><br>" +
      "You decide to go to the bathroom at this point, since you don't<br>" +
      "exactly have any way to participate, and you forgot to go before<br>" +
      "leaving your dorm. Because you don't know where the nearest bathroom is,<br>" +
      "however, you decide to go find somewhere secluded. During your search,<br>" +
      "you stumble across a large deposit of gold within a large boulder!<br><br>" +
      "You come back later that day after buying a pickaxe, and mine as<br>" +
      "much of the metal out as possible. You then sell the gold and become rich!<br><br>" +
      "Who knew going to the bathroom could be so rewarding?!<br><br>" +
      "<b>THE END</b></p></html>";
    
    
    //Level 8:
    String text_1_1_1_1_1_1_2_1 = "<html><p><br><br>You and Shayn see each other after class.<br><br>" +
      "They ask \"So, where should we go?\" <br><br>" +
      "You say you're cool with anywhere. They ponder quizzically and ask<br>" +
      "if you want to work at a library or their apartment.<br>" +
      "<br>A. Go the library and keep this professional" + 
      "<br>B. Their apartment? I mean, yeah.</p></html>";
    String [] node_1_1_1_1_1_1_2_1_options = {"A", "B"};
    
    String text_1_1_2_1_1_1_1_1 = "<html><p><br><br>You decide to ignore Van's strange behavior, " +
      "and instead <br>get to work on the experiment with her. Van seems to know what<br>" +
      "she's doing, expertly handling all of the different chemicals in beakers,<br>" +
      "and putting the solutions through highly advanced machines that you've<br>" +
      "never heard of before; an NP-003, maybe?<br><br>" +
      "She has you hold a few of the beakers at a precarious angle as she threads<br>" +
      "in a rubber tube. Frost covers the inside of the beaker with the other end<br>" +
      "of the tube.<br><br>" +
      "After you've got the beakers bubbling with your final result - a<br>" +
      "liquid cryogenic compound, it seems - the professor comes over to<br>" +
      "commend you on your successful lab. You see Van roll her eyes at<br>" +
      "the comment, as if this were child's play to her. As you gather<br>" +
      "up your things, she approaches you.<br><br>" +
      "\"Thanks for the help. I needed an extra set of hands to handle<br>" +
      "the koronium-3 extract. One splash of that on an exposed limb and<br>" +
      "you can say bye-bye. Anyways, thanks for the hair. It will come in<br>" +
      "handy for my cloning experiment.\"" +
      "<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_2_1_1_1_1_1_options = {"C"};
    
    String text_1_1_2_1_1_1_1_2 = "<html><p><br><br>Van seems a little too strange for your taste. You<br>" +
      "decide to work alone - after all, she would've been alone if you hadn't<br>" +
      "transferred here in time for today. As you begin following the instructions<br>" +
      "in the lab holo, you feel something running down your arm. You look down to<br>" +
      "see some liquid dripping out of one of the beakers... right onto your exposed<br>" +
      "skin! The spot where it has fallen onto you goes numb, and you look on in<br>" +
      "horror as your entire body slowly becomes covered in frost.<br><br>" +
      "A scream escapes your lips before you realize that you're still able to move!<br>" +
      "You face your palm outwards to inspect your arm, and suddenly a bolt of<br>" +
      "frost shoots across the room, and encases the door in ice!<br><br>" +
      "The professor frantically takes you to the school's health services,<br>" +
      "where it is discovered that you've acquired ice powers through some<br>" +
      "incredibly shady and scientifically unexplicable interaction between<br>" +
      "the compound and your DNA! They have no idea how to cure you, so you<br>" +
      "become a superhero and fight crime around Ryder Prime for the rest of<br>" +
      "your life, being loved and admired by all." +
      "<br><br><b>THE END</b></p></html>"; 
    
    String text_1_1_3_1_1_1_1_1 = "<html><p><br><br>They hand you a script for the play, " +
      "and you spend <br>the rest of the class reading over the play. After you've finished,<br>" +
      "Kavanique walks up to you. They look as though they want to say something<br>" +
      "to you, but they're hesitating. They kick the dirt with their foot a couple<br>" +
      "times in angsty-goat form.<br><br>" +
      "\"What's up?\" you ask, initiating the encounter. They answer with goat<br>" +
      "noises, and you can tell this is going to be a game of 20 questions.<br><br>" +
      "After an extensive interrogation with Kavanique nodding or shaking their<br>" +
      "head in answer, you've finally deduced that they are asking you to<br>" +
      "hangout with them!<br><br>What do you think?<br>" +
      "<br>A. Hangout with Kavanique" +
      "<br>B. Go back to your dorm</p></html>";
    String [] node_1_1_3_1_1_1_1_1_options = {"A", "B"};
    
    
    //Level 9:
    String text_1_1_1_1_1_1_2_1_1 = "<html><p><br><br>Shayn looks at you a tad bit disappointing. Did you<br>" +
      "mess up? You barely know them but were they looking for something more?<br>" +
      "<br>Well, it's too late now. You finish your assignment and walk them out.<br>" +
      "You part paths and walk back to your rooms. It turns out that you and Shayn<br>" +
      "earned a 0 on your assignment, and you have now failed your class. I guess<br>" +
      "you and Shayn don't mesh well. You have been placed on academic leave and<br>" +
      "must leave the school.<br><br>Sad reacts.<br><br>" +
      "<b>THE END</b></p></html>"; 
    
    String text_1_1_1_1_1_1_2_1_2 = "<html><p><br><br>Shayn is taken aback, they did not expect you to <br>" +
      "choose that option. You guys go to Shayn's place which is kind of a ways<br>" +
      "off campus because it's cheaper to live there.<br><br>" +
      "On the way there, you two start to talk a little. You learn that Shayn<br>" +
      "grew up on Ryder Prime and moved around a lot. They don't have many close<br>" +
      "friends, but you think that's about to change." +
      "<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_1_1_1_1_2_1_2_options = {"C"};
    
    String text_1_1_2_1_1_1_1_1_1 = "<html><p><br><br>\"Uhm, you're welcome?\" You say slowly, unsure of<br>" +
      "what to make of this strange woman.<br><br>" +
      "\"You know, you aren't so bad,\" she says, as if it's the nicest compliment<br>" +
      "in the world. \"If you'd like, I can show you around campus - or rather,<br>" +
      "the science labs. I've been working on some pretty amazing stuff lately.\"<br>" +
      "<br>A. Hangout with Van" +
      "<br>B. Go back to your room</p></html>";
    String [] node_1_1_2_1_1_1_1_1_1_options = {"A", "B"};
    
    String text_1_1_3_1_1_1_1_1_1 = "<html><p><br><br>\"Of course!\" you exclaim excitedly. " +
      "Kavanique's<br>eyes light up again, and you feel your stomach start to feel tingly.<br>" +
      "Either the breakfast burrito you had earlier today is<br>" +
      "making you sick, or you're starting to think this person is kind of cute!<br><br>" +
      "You follow them as they lead you out of campus and up a hiking trail.<br>" +
      "As a goat, it makes perfect sense that Kavanique would enjoy hiking!<br><br>" +
      "When they finally stop, you find yourself at the top<br>" +
      "of a tall rise that looks out over the campus.<br><br>" +
      "The view is breathtaking. Kavanique looks pleased with themselves as<br>" +
      "they see you enjoying the scenery. Once you return back to campus, you<br>" +
      "part ways after a few more goat noise speeches from Kavanique.<br><br>" +
      "You think it was something along the lines of, \"I hope I'll see you tomorrow.\"<br>" +
      "<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_3_1_1_1_1_1_1_options = {"C"};
    
    String text_1_1_3_1_1_1_1_1_2 = "<html><p><br><br>You return to your room having maybe made a new" +
      "friend<br>today, though you aren't sure if they are someone you actually want<br>" +
      "to spend time with. As you're getting ready for bed, however, you hear a<br>" +
      "large BOOM! from outside your window!<br><br>" +
      "You quickly look outside, and notice a glowing piece of meteorite sitting right<br>" +
      "outside! Naturally, you have a strong desire to pick it up. In fact, it seems<br>" +
      "that it is calling for you, how strange.... <br><br>" +
      "Your mind goes blank and suddenly the only thought you have is to sit down<br>" +
      "and try to solve NP-Complete problems. However, your lack of computer<br>" +
      "science knowledge makes this impossible, and instead you end up going<br>" +
      "insane.<br><br>The doctors all tried to help you, but the power of the meteorite<br>" +
      "was too strong. The good news, however, is that they gave you a giant friendly<br>" +
      "cat to keep you company. Because nobody should be alone, not even pseudo-computer<br>" +
      "scientists.<br><br><b>THE END</b></p></html>";
    
    
    //Level 10:
    String text_1_1_1_1_1_1_2_1_2_1 = "<html><p><br><br>You guys talk a little more and you realize you have<br>" +
      "a lot in common, like your taste in 21st century memes and coffee.<br><br>" +
      "Should you ask them if they want to hang out more? But do you want more<br>" +
      "than friendship?<br><br>You remember that the Settlement festival is coming up...<br>" +
      "<br>A. Go on a date to the Settlement festival" +
      "<br>B. Just be friends" + 
      "<br>C. See them tomorrow in class</p></html>";
    String [] node_1_1_1_1_1_1_2_1_2_1_options = {"A", "B", "C"};
    
    String text_1_1_2_1_1_1_1_1_1_1 = "<html><p><br><br>\"Sure, why not?\" you say as you follow Van " +
      "out of the<br>classroom. She shows you a bunch of highly sophisticated experiments<br>" +
      "she's been working on, but you're not sure how much of it you really understand.<br>" +
      "The new planet seems to have extremely hot summers, and lately the university<br>" +
      "has been trying to create an enviro-stabilizer, which would bring the planet's<br>" +
      "temperature range closer to that of Earth's.<br><br>" +
      "Of course, the ethical debate has become increasingly volatile as to whether<br>" +
      "or not they should ever implement technology if they can develop it successfully.<br><br>" +
      "Van, being an extremely gifted and intelligent scientist, has almost perfected<br>" +
      "her own prototype of such a device - or so she says. She looks at you<br>" +
      "appreciatively, as if no one else hangs out with her enough to listen<br>" +
      "to her talk about this work, which she is obviously extremely passionate<br>" +
      "about. You think you're starting to warm up to this intelligent,<br>" +
      "though somewhat quirky, woman by the end of the day.<br><br>" +
      "Afterwards, you head back to your room and go to sleep." +
      "<br><br><i>Enter C to continue</i></p></html>";
    String [] node_1_1_2_1_1_1_1_1_1_1_options = {"C"};
    
    String text_1_1_2_1_1_1_1_1_1_2 = "<html><p><br><br>You return to your room without having made any " +
      "friends on<br>your first day, but you are determined to do better tomorrow!<br><br>" +
      "As you fall asleep, you feel a heavy fog enter your thoughts.<br>" +
      "You fall into a deep, deep sleep, and awake 80 years later to find<br>" +
      "that you've become a shriveled old person! Blast! Your days of<br>" +
      "youth are spent!<br><br>Woe is you!<br><br>" +
      "<b>THE END</b></p></html>";
    
    String text_1_1_3_1_1_1_1_1_1_1 = "<html><p><br><br>The next day, you walk over to the amphitheater," +
      "prepared<br>for another day of working on the play with Kavanique. When you get<br>" +
      "there, you immediately look for your new friend.<br><br>" +
      "Within no time, they come over and start trying to communicate<br>" +
      "with you through goat noises and gestures once again. They lead you over<br>" +
      "to a small tent that is set up near the amphitheater, and suddenly push you<br>" +
      "into a small room! Before you can ask what's going on, they toss in a<br>" +
      "sheep onesie and slide the curtain door closed. On the onesie, you<br>" +
      "find a small note written in small but neat handwriting.<br><br>" +
      "It says: \"Will you come to the Settlement Festival with me?\"<br><br>" +
      "Judging from the note, if you put on the onesie then you'll be agreeing " + 
      "to go with them.<br>" +
      "<br>A. Go to the Settlement Festival as a date" + 
      "<br>B. Go to the Settlement Festival as friends" +
      "<br>C. Don't go to the Settlement Festival</p></html>";
    String [] node_1_1_3_1_1_1_1_1_1_1_options = {"A", "B", "C"};
    
    
    //Level 11:
    String text_1_1_1_1_1_1_2_1_2_1_1 = "<html><p><br><br>Shayn shuffles around a little and twiddles " +
      "their thumbs.<br>They say yes and grab your hand. You don't resist.<br><br>" +
      "It seems like they want to be more than friends too.<br><br>" +
      "<b>THE END</b></p></html>";
    
    String text_1_1_1_1_1_1_2_1_2_1_2 = "<html><p><br><br>Shayn says yes. You both decide to grab " +
      "lunch sometime<br>after class and talk about the inception of meme culture " +
      "in<br>the early 2000's.<br><br><b>THE END</b></p></html>";
    
    String text_1_1_1_1_1_1_2_1_2_1_3 = "<html><p><br><br>Shayn says they'll see you tomorrow too.<br>" +
      "<br>You guys high five and walk in opposite directions.<br><br><b>THE END</b></p></html>";
    
    String text_1_1_2_1_1_1_1_1_1_1_1 = "<html><p><br><br>The next day, you walk into lab and find " +
      "Van sitting next<br>to your desk, with a large grin on her face that makes you<br>" +
      "think she's up to no good. You sit down cautiously, as she pulls out<br>" +
      "a small box and holds it out to you.<br><br>" +
      "\"Tada! Put your finger right in here, please,\" she says, pointing to a<br>" +
      "suspicious hole in the otherwise featureless box. You oblige, and the<br>" +
      "top seems to dissolve as a crystal-clear hologram begins to play from<br>" +
      "a light shooting out of the dissolved top.<br><br>" +
      "\"Settlement festival?\" it reads in small, elegantly displayed letters.<br><br>" +
      "\"Well?\" Van asks, looking at you eagerly.<br>" +
      "<br>A. Agree to go to the festival with Van, as friends" +
      "<br>B. Agree to go to the festival with Van, and tell her you like her" +
      "<br>C. Decline</p></html>";
    String [] node_1_1_2_1_1_1_1_1_1_1_1_options = {"A","B","C"};
    
    String text_1_1_3_1_1_1_1_1_1_1_1 = "<html><p><br><br>This will be fun! You think to yourself as " +
      "you put<br> on the onesie. When you step back outside of the changing room<br>" +
      "you see Kavanique standing there, looking incredibly nervous. When<br>" +
      "they see you though, they \"bahhh\" in excitement.<br><br>" +
      "\"I guess this can be our first official date then,\" You say<br>" +
      "sheepishly as a deep red blush fills your cheeks.<br><br>" +
      "You spend the rest of the class thinking of how comfortable this<br>" +
      "onesie is and trying not to fall asleep, but are glad that Kavanique<br>" +
      "is excited to go to the festival with you.<br><br>" +
      "You spend an incredible night celebrating at the festival,<br>" +
      "frolicing around making goat noises, and even manage to get<br>" +
      "a quick (human) good-night kiss from your super incredible date.<br><br>" +
      "You don't know what the future will hold, but if anything,<br>" +
      "this is love, probably.<br><br><b>THE END</b></p></html>";
    
    String text_1_1_3_1_1_1_1_1_1_1_2 = "<html><p><br><br>\"Yeah, of course!\" you reply loud enough for " +
      "them to hear you. \"It's<br>nice to know I've made a friend here so quickly!\"<br><br>" +
      "You quickly put on the onesie and jump out through the curtain,<br>" + 
      "embracing your new persona.<br><br>" +
      "Kavanique's face lights up with a grin as they begin jumping<br>" +
      "and stampeding around, challenging you to a goat-parkour-off.<br><br>" +
      "You spend the rest of the class thinking of how incredibly lucky<br>" +
      "you are to have made a friend already, and enjoy a nice evening<br>" +
      "with Kavanique, running through the festival and headbutting stuff.<br><br>" +
      "It isn't romance, but friendship is just as good.<br><br><b>THE END</b></p></html>";
    
    String text_1_1_3_1_1_1_1_1_1_1_3 = "<html><p><br><br>Even though Kavanique is nice and everything, " +
      "it just doesn't<br>feel like you've connected with them well enough to want to<br>" +
      "go to the festival with them. You exit the changing room, and <br>" +
      "even though they seem a bit disappointed, they walk you back outside,<br>" +
      "and you both participate in class.<br><br>" +
      "When the night of the Settlement Festival comes, you decide to stay<br>" +
      "inside and watch your favorite movie. Though you didn't find love,<br>" +
      "at least you're here on Ryder Prime, alive and well." +
      "<br><br><b>THE END</b></p></html>";
    
    
    //Level 12:
    String text_1_1_2_1_1_1_1_1_1_1_1_1 = "<html><p><br><br>\"Yeah, of course!\" you reply enthusiastically. " +
      "Your cheeks flare up red<br>as you add, \"I really liked getting to spend time with<br>" +
      "you yesterday, and I'd really like to get to know you better...\"<br><br>" +
      "Van's eyes go wide for a moment and she seems taken aback, but<br>" +
      "she quickly recovers her composure.<br><br>" +
      "\"I liked hanging out with you too! And you were even attentive<br>" +
      "during my explanation of cryogenic-thermal stabilization theory, and<br>" +
      "how it relates to the ecological balance of native life forms here....<br>" +
      "I guess we can call this date one, and see where it goes from here.\"<br><br>" +
      "You spend the rest of the class thinking of how incredibly awkward<br>" +
      "you are, but are glad that Van seems excited to go to the festival<br>" +
      "with you. You spend an incredible night celebrating at the<br>" +
      "festival, and even manage to get a quick good-night kiss from your<br>" +
      "super incredible date.<br><br>" +
      "You don't know what the future will hold, but if anything,<br>" +
      "this is love, probably.<br><br><b>THE END</b></p></html>"; 
    
    String text_1_1_2_1_1_1_1_1_1_1_1_2 = "<html><p><br><br>\"Yeah, of course!\" you reply enthusiastically. " +
      "\"It's nice<br>to know I've made a friend here so quickly!\"<br><br>" +
      "Van smiles warmly as she answers, \"It's nice to have made a new<br>" +
      "friend; I haven't really gotten to know any of the other people<br>" +
      "in our lab so far, since I spend so much time working on my projects,<br>" +
      "and most other people aren't interested in cryo-thermal stabilization theory.\"<br><br>" +
      "You spend the rest of the class thinking of how incredibly lucky you<br>" +
      "are to have made a friend already, and enjoy a nice relaxing evening with<br>" +
      "Van. <br><br>It isn't romance, but friendship is just as good.<br><br><b>THE END</b></p></html>";
    
    String text_1_1_2_1_1_1_1_1_1_1_1_3 = "<html><p><br><br>You return to your room without having found a " +
      "date to the<br>Settlement Festival, but you are determined to do better next year!<br><br>" +
      "Instead, you find a cute stray dog and name it Havannah. You accompany<br>" +
      "it around the festival, buying it treats because it is just so darn<br>" +
      "cute, and end up adopting the shaggy dog.<br><br><b>THE END</b></p></html>";
    
    /***************************************************
      *            CONSTRUCTING THE TREE
    ***************************************************/
    //Twelvth level:
    EndNode node_1_1_2_1_1_1_1_1_1_1_1_3 = new EndNode(text_1_1_2_1_1_1_1_1_1_1_1_3);
    EndNode node_1_1_2_1_1_1_1_1_1_1_1_2 = new EndNode(text_1_1_2_1_1_1_1_1_1_1_1_2);
    EndNode node_1_1_2_1_1_1_1_1_1_1_1_1 = new EndNode(text_1_1_2_1_1_1_1_1_1_1_1_1);
    
    
    //Eleventh level:
    Node [] node_1_1_2_1_1_1_1_1_1_1_1_nextNode = {node_1_1_2_1_1_1_1_1_1_1_1_2, 
      node_1_1_2_1_1_1_1_1_1_1_1_1, node_1_1_2_1_1_1_1_1_1_1_1_3};
    EndNode node_1_1_3_1_1_1_1_1_1_1_3 = new EndNode(text_1_1_3_1_1_1_1_1_1_1_3);
    EndNode node_1_1_3_1_1_1_1_1_1_1_2 = new EndNode(text_1_1_3_1_1_1_1_1_1_1_2);
    EndNode node_1_1_3_1_1_1_1_1_1_1_1 = new EndNode(text_1_1_3_1_1_1_1_1_1_1_1);
    StoryNode node_1_1_2_1_1_1_1_1_1_1_1 = new StoryNode(text_1_1_2_1_1_1_1_1_1_1_1, 
      node_1_1_2_1_1_1_1_1_1_1_1_options, node_1_1_2_1_1_1_1_1_1_1_1_nextNode);
    EndNode node_1_1_1_1_1_1_2_1_2_1_1 = new EndNode(text_1_1_1_1_1_1_2_1_2_1_1);
    EndNode node_1_1_1_1_1_1_2_1_2_1_2 = new EndNode(text_1_1_1_1_1_1_2_1_2_1_2);
    EndNode node_1_1_1_1_1_1_2_1_2_1_3 = new EndNode(text_1_1_1_1_1_1_2_1_2_1_3);
    
    
    //Tenth level:
    Node [] node_1_1_3_1_1_1_1_1_1_1_nextNode = {node_1_1_3_1_1_1_1_1_1_1_1, 
      node_1_1_3_1_1_1_1_1_1_1_2, node_1_1_3_1_1_1_1_1_1_1_3};
    Node [] node_1_1_2_1_1_1_1_1_1_1_nextNode = {node_1_1_2_1_1_1_1_1_1_1_1};
    Node [] node_1_1_1_1_1_1_2_1_2_1_nextNode = {node_1_1_1_1_1_1_2_1_2_1_1, 
      node_1_1_1_1_1_1_2_1_2_1_2, node_1_1_1_1_1_1_2_1_2_1_3};
    StoryNode node_1_1_3_1_1_1_1_1_1_1 = new StoryNode(text_1_1_3_1_1_1_1_1_1_1, 
      node_1_1_3_1_1_1_1_1_1_1_options, node_1_1_3_1_1_1_1_1_1_1_nextNode);
    EndNode node_1_1_2_1_1_1_1_1_1_2 = new EndNode(text_1_1_2_1_1_1_1_1_1_2);
    StoryNode node_1_1_2_1_1_1_1_1_1_1 = new StoryNode(text_1_1_2_1_1_1_1_1_1_1, 
      node_1_1_2_1_1_1_1_1_1_1_options, node_1_1_2_1_1_1_1_1_1_1_nextNode);
    StoryNode node_1_1_1_1_1_1_2_1_2_1 = new StoryNode(text_1_1_1_1_1_1_2_1_2_1, 
      node_1_1_1_1_1_1_2_1_2_1_options, node_1_1_1_1_1_1_2_1_2_1_nextNode);
    

    //Ninth level:
    Node [] node_1_1_3_1_1_1_1_1_1_nextNode = {node_1_1_3_1_1_1_1_1_1_1};
    Node [] node_1_1_2_1_1_1_1_1_1_nextNode = {node_1_1_2_1_1_1_1_1_1_1, 
      node_1_1_2_1_1_1_1_1_1_2};
    Node [] node_1_1_1_1_1_1_2_1_2_nextNode = {node_1_1_1_1_1_1_2_1_2_1};
    EndNode node_1_1_3_1_1_1_1_1_2 = new EndNode(text_1_1_3_1_1_1_1_1_2);
    StoryNode node_1_1_3_1_1_1_1_1_1 = new StoryNode(text_1_1_3_1_1_1_1_1_1, 
      node_1_1_3_1_1_1_1_1_1_options, node_1_1_3_1_1_1_1_1_1_nextNode);
    StoryNode node_1_1_2_1_1_1_1_1_1 = new StoryNode(text_1_1_2_1_1_1_1_1_1, 
      node_1_1_2_1_1_1_1_1_1_options, node_1_1_2_1_1_1_1_1_1_nextNode);
    StoryNode node_1_1_1_1_1_1_2_1_2 = new StoryNode(text_1_1_1_1_1_1_2_1_2, 
      node_1_1_1_1_1_1_2_1_2_options, node_1_1_1_1_1_1_2_1_2_nextNode);
    EndNode node_1_1_1_1_1_1_2_1_1 = new EndNode(text_1_1_1_1_1_1_2_1_1);
    

    //Eighth level:
    Node [] node_1_1_3_1_1_1_1_1_nextNode = {node_1_1_3_1_1_1_1_1_1, node_1_1_3_1_1_1_1_1_2};
    Node [] node_1_1_2_1_1_1_1_1_nextNode = {node_1_1_2_1_1_1_1_1_1};
    Node [] node_1_1_1_1_1_1_2_1_nextNode = {node_1_1_1_1_1_1_2_1_1, node_1_1_1_1_1_1_2_1_2};
    StoryNode node_1_1_3_1_1_1_1_1 = new StoryNode(text_1_1_3_1_1_1_1_1, 
      node_1_1_3_1_1_1_1_1_options, node_1_1_3_1_1_1_1_1_nextNode);
    EndNode node_1_1_2_1_1_1_1_2 = new EndNode(text_1_1_2_1_1_1_1_2);
    StoryNode node_1_1_2_1_1_1_1_1 = new StoryNode(text_1_1_2_1_1_1_1_1, 
      node_1_1_2_1_1_1_1_1_options, node_1_1_2_1_1_1_1_1_nextNode);
    StoryNode node_1_1_1_1_1_1_2_1 = new StoryNode(text_1_1_1_1_1_1_2_1, 
      node_1_1_1_1_1_1_2_1_options, node_1_1_1_1_1_1_2_1_nextNode);
    
    
    //Seventh level:
    Node [] node_1_1_3_1_1_1_1_nextNode = {node_1_1_3_1_1_1_1_1};
    Node [] node_1_1_2_1_1_1_1_nextNode = {node_1_1_2_1_1_1_1_2, node_1_1_2_1_1_1_1_1};
    Node [] node_1_1_1_1_1_1_2_nextNode = {node_1_1_1_1_1_1_2_1};
    EndNode node_1_1_3_1_1_1_2 = new EndNode(text_1_1_3_1_1_1_2);
    StoryNode node_1_1_3_1_1_1_1 = new StoryNode(text_1_1_3_1_1_1_1, 
      node_1_1_3_1_1_1_1_options, node_1_1_3_1_1_1_1_nextNode);
    StoryNode node_1_1_2_1_1_1_1 = new StoryNode(text_1_1_2_1_1_1_1, 
      node_1_1_2_1_1_1_1_options, node_1_1_2_1_1_1_1_nextNode);
    StoryNode node_1_1_1_1_1_1_2 = new StoryNode(text_1_1_1_1_1_1_2, 
      node_1_1_1_1_1_1_2_options, node_1_1_1_1_1_1_2_nextNode);
    EndNode node_1_1_1_1_1_1_1 = new EndNode(text_1_1_1_1_1_1_1);

    
    //Sixth level:
    Node [] node_1_1_3_1_1_1_nextNode = {node_1_1_3_1_1_1_1, node_1_1_3_1_1_1_2};
    Node [] node_1_1_2_1_1_1_nextNode = {node_1_1_2_1_1_1_1};
    Node [] node_1_1_1_1_1_1_nextNode = {node_1_1_1_1_1_1_1, node_1_1_1_1_1_1_2};
    StoryNode node_1_1_3_1_1_1 = new StoryNode(text_1_1_3_1_1_1, 
      node_1_1_3_1_1_1_options, node_1_1_3_1_1_1_nextNode);
    StoryNode node_1_1_2_1_1_1 = new StoryNode(text_1_1_2_1_1_1, 
      node_1_1_2_1_1_1_options, node_1_1_2_1_1_1_nextNode);
    StoryNode node_1_1_1_1_1_1 = new StoryNode(text_1_1_1_1_1_1, 
      node_1_1_1_1_1_1_options, node_1_1_1_1_1_1_nextNode);
      

    //Fifth level:
    Node [] node_1_1_3_1_1_nextNode = {node_1_1_3_1_1_1};
    Node [] node_1_1_2_1_1_nextNode = {node_1_1_2_1_1_1};
    Node [] node_1_1_1_1_1_nextNode = {node_1_1_1_1_1_1};
    StoryNode node_1_1_3_1_1 = new StoryNode(text_1_1_3_1_1, 
      node_1_1_3_1_1_options, node_1_1_3_1_1_nextNode);
    StoryNode node_1_1_2_1_1 = new StoryNode(text_1_1_2_1_1, 
      node_1_1_2_1_1_options, node_1_1_2_1_1_nextNode);
    EndNode node_1_1_1_1_2 = new EndNode(text_1_1_1_1_2);
    StoryNode node_1_1_1_1_1 = new StoryNode(text_1_1_1_1_1, 
      node_1_1_1_1_1_options, node_1_1_1_1_1_nextNode);
    
    //Fourth level:
    //set the second option all to one node to be more efficient, since result is the same
    Node [] node_1_1_3_1_nextNode = {node_1_1_3_1_1, node_1_1_1_1_2};
    Node [] node_1_1_2_1_nextNode = {node_1_1_2_1_1, node_1_1_1_1_2};
    Node [] node_1_1_1_1_nextNode = {node_1_1_1_1_1, node_1_1_1_1_2};
    StoryNode node_1_1_3_1 = new StoryNode(text_1_1_3_1, node_1_1_3_1_options, 
                                           node_1_1_3_1_nextNode);
    StoryNode node_1_1_2_1 = new StoryNode(text_1_1_2_1, node_1_1_2_1_options, 
                                           node_1_1_2_1_nextNode);
    StoryNode node_1_1_1_1 = new StoryNode(text_1_1_1_1, node_1_1_1_1_options, 
                                           node_1_1_1_1_nextNode);
    
    //Third level:

    Node [] node_1_1_3_nextNode = {node_1_1_3_1};
    Node [] node_1_1_2_nextNode = {node_1_1_2_1};
    Node [] node_1_1_1_nextNode = {node_1_1_1_1};
    StoryNode node_1_1_3 = new StoryNode(text_1_1_3, node_1_1_3_options, 
                                         node_1_1_3_nextNode);
    StoryNode node_1_1_2 = new StoryNode(text_1_1_2, node_1_1_2_options, 
                                         node_1_1_2_nextNode);
    StoryNode node_1_1_1 = new StoryNode(text_1_1_1, node_1_1_1_options, 
                                         node_1_1_1_nextNode);
    
    //Second level:
    Node [] node_1_1_nextNode = {node_1_1_1, node_1_1_2, node_1_1_3};
    StoryNode node_1_1 = new StoryNode(text_1_1, node_1_1_options, node_1_1_nextNode);
    
    //First level:
    Node [] node_1_nextNode = {node_1_1};
    StoryNode node_1 = new StoryNode(text_1, node_1_options, node_1_nextNode);
    
    //Opening
    Node [] opening_nextNode = {node_1};
    StoryNode openingNode = new StoryNode(openingText, opening_options, opening_nextNode);
    
    return openingNode;

  }
  
  /**
   * Constructor method for the StoryTree
   * Initializes the tree and a boolean to indicate when the game is over.
   */
  public StoryTree() {
    currentNode = createNodeText();
    isOver = false;
  }
  
  /**
   * Void method to help traverse the tree
   * Takes in user input, and if the game is not over,
   * traverses to the correct node.
   * 
   * @param String choice
   */
  public void makeChoice(String choice) {
    //System.out.println("inside make choice");
    if (!isOver) {
      if (((StoryNode)currentNode).isOption(choice)) {
      //System.out.println("Testing: " + currentNode);
      currentNode = ((StoryNode)currentNode).getOption(choice);
      }
      //else statement for testing
      //else {
        //System.out.println("User input invalid");
      //}
      if (currentNode instanceof EndNode) {
        isOver = true;
        //System.out.println("game over");
        //System.out.println(currentNode.getText());
      }
    }
    else {
      System.out.println("game is already over");
    }
  }
  
  /**
   * Boolean method to tell whether game is over
   * 
   * @returns true if it is over, false if not
   */
  public boolean isGameOver() {
    return isOver;
  }
  
  /**
   * Getter method to return the text of the node.
   * The text will be displayed on the GUI.
   * 
   * @returns the text of the current node
   */
  public String getText() {
    return currentNode.getText();
  }
  
  /**
   * Getter method for the current node that the
   * user is at.
   * 
   * @return the currentNode
   */
  public Node getCurrentNode() {
    return currentNode;
  }
  
  /**
   * Main method to run the game without the GUI.
   * Mostly for testing purposes.
   */
  public static void main(String [] args) {
    StoryTree test = new StoryTree();
    Scanner scan = new Scanner(System.in);
    while (!test.isGameOver()) {
      //System.out.println(test.getText());
      String option = scan.next().toUpperCase();
      //System.out.println(test.getCurrentNode().getText());
      
      //check if input is valid; if not, repeat getting input until valid
      while (!((StoryNode)test.getCurrentNode()).isOption(option)){
        option = scan.next().toUpperCase();
      }
      test.makeChoice(option);
      //System.out.println(test.getCurrentNode().getText());
    }
    System.out.println(test.getCurrentNode().getText());
  }
  
}