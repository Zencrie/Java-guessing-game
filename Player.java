
/**
 * Assignment 3: Guessing Game Player Class
 * Completed January 4th, 2021
 * Elyssa Grant
 * 
 * Description:  A class to hold data about each player participating the guessing game
 * 
 * Variables: strFName..............A non-static variable that will hold the first name of each player
 *            strLName..............A non-static variable that will hold the last name of each player
 *            bytScore..............A non-static variable that will hold the score of each player
 */
public class Player
{
    //declaring variables 
    //to hold the first and last names of the player
    private String strFName, strLName;
    
    //to hold the score of the player
    private byte bytScore;
    
    //constructor to quickly initialize the instance of the variables
    Player(String fName, String lName, byte score)
    {
        this.strFName = fName;
        this.strLName = lName;
        this.bytScore = 0;
    }
    
    //default constructor
    Player()
    {
        //initializing to pre-coded amounts to prevent errors
        strFName = "UNKNOWN";
        strLName = "UNKNOWN";
        bytScore = 0;
    }
    
    //method to get the first name of the player
    public String getFName()
    {
        return strFName;
    }
    
    //method to set the first name of the player to what they inputted
    public void setFName(String newFName)
    {
        this.strFName = newFName;
    }
    
    //method to get the first name of the player
    public String getLName()
    {
        return strLName;
    }
    
    //method to set the first name of the player to what they inputted
    public void setLName(String newLName)
    {
        this.strLName = newLName;
    }
    
    //method to get the first name of the player
    public byte getScore()
    {
        return bytScore;
    }
    
    //method to set the first name of the player to what they inputted
    public void setScore(byte newScore)
    {
        this.bytScore = newScore;
    }
    
    //toString to output the score of each player
    public String toString()
    {
        return this.strFName+" "+this.strLName+" - Score: "+this.bytScore;
    }
}
