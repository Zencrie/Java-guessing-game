
/**
 * Assignment 3: Guessing Game GuessingGame Class
 * Completed January 6th, 2021
 * Elyssa Grant
 * Description: A class to hold the number to be guessed and most of the code to play the guessing game. 
 * 
 * Variables: bytGuess.................Holds the guess the user inputted to be checked against the correct number
 *            bytRandomNum.............Holds the randomly generated number the users are trying to guess
 *            bytScoreHolder...........Temporarily holds the score of the player so it can be added to 
 *            players..................An ArrayList that holds all the instances of the user's first names, last names and current scores
 *            finalWinner..............A variable of type Player that takes in the information of the user with the highest score at the end
 *            strYesNo.................Holds the response of the user to various questions that can be answered by yes or no
 *            strTempFName.............Temporarily holds the user's first name so it can be put into the ArrayList
 *            strTempLName.............Temporarily holds the user's last name so it can be put into the ArrayList
 *            Winners..................An ArrayList that holds the first names of all the users who guessed the number correctly this round
 *            strKeepPlaying...........Holds whether or not the user would like to play another round of the guessing game
 *            booRunner................Holds a true or false statement to keep several loops running until the user does what they are supposed to
 *            k........................Holds the counter for a for loop
 *            element..................Temporarily holds the data of another variable to run a for each loop  
 */
//importing ArrayList class from java library 
import java.util.ArrayList;

//importing collections class from java library
import java.util.Collections; 

//importing scanner from java library
import java.util.Scanner;

//importing math logic from java library so random number generator will work
import java.lang.Math;

public class GuessingGame
{
    //declaring variables to 
    //hold the current player’s guess
    private byte bytGuess = 0;  
    
    //hold the computer generated number from 1 to 10 to guess
    private byte bytRandomNum;  
    
    static byte games = 0;
    
    //Keep a list of the current Players
    private ArrayList<Player> players = new ArrayList<Player>(); 
    
    //default constructor
    GuessingGame()
    { 
        bytGuess = 0;
        bytRandomNum = 1;
    }
 
    //method to get the players to add themselves to the game before the game starts
    public void Setup()
    {
        //clearing the screen of previous games
        System.out.print('\u000C');
        
        //outputting how many games have been played
        games++;
        System.out.println(games);
        
        //declaring variables
        //to get the user's answer to various yes or no questions
        String strYesNo;
        
        //to temporarily hold the user's first name
        String strTempFName;
        
        //to temporarily hold the user's last name
        String strTempLName;
        
        //to keep the loops for incorrect string answers running until the user enters a valid response
        boolean booRunner = true;
        
        //to count the number of players that exist in order to find the correct one to reset
        byte bytCounter=0;
        
        //looping as long as the users want to add more players
        do
        {
            //adding 1 to the counter 
            bytCounter++;
            
            //prompting user for their first name
            System.out.println("Please enter your first name");
            strTempFName= new Scanner(System.in).nextLine();
            
            //prompting user for their first name
            System.out.println("Please enter your last name");
            strTempLName= new Scanner(System.in).nextLine();
            
            
            
            //checking if both the first and last names are blank. If so, calling default and otherwise inputting normally
            if((strTempFName.equalsIgnoreCase(""))&&(strTempLName.equalsIgnoreCase("")))
            {
                //calling default constructor 
                players.add(new Player());
            }
            else
            {
                //setting the information into a new slot of the players arraylist and placing their score at zero
                players.add(new Player(strTempFName,strTempLName, (byte)0));
            }
            
            //looping until the user enters a correct answer to the yes/no question
            do
            {
                //asking user if they would like to add another player
                System.out.println("Would you like to add another player?");
                strYesNo = new Scanner(System.in).nextLine();
                
                //checking to see if the user has made a valid response
                if((strYesNo.equalsIgnoreCase("yes"))||(strYesNo.equalsIgnoreCase("no")))
                {
                    //breaking the loop by setting the boolean to false 
                    booRunner = false;
                }
                else
                {
                    //letting user know they have not entered a valid response
                    System.out.println("Invalid answer. Please enter 'yes' or 'no'");
                }
            }while(booRunner);
            
            //resetting the boolean loop runner to true so it can be used in the next cycle of the loop
            booRunner= true;
        }while(strYesNo.equalsIgnoreCase("Yes"));
        
        //going to the playGame method when done inputting players
        playGame();
    }
    
    //method to hold the code to play the main game
    public void playGame()
    {
        //declaring variables
        //arraylist to hold all the player's first names who won this round
        ArrayList<String> Winners = new ArrayList<String>();
        
        //to hold whether the user wants to keep playing or not
        String strKeepPlaying;
        
        //to keep the loop for the yes/no question running until the user enters a valid answer
        boolean booRunner = true;
        
        //declaring a variable to hold the score of the player
        byte bytScoreHolder;
        
        //explaining the game to the user
        System.out.println("Welcome to GuessIt!\nIn this game,each player will guess a number between 1 and 10");
        System.out.println("Any player who guesses the correct number - chosen randomly at the start of each round- will win a point.");
        System.out.println("Play for as many rounds as you like!\nAt the end of the game, the player with the most points wins!");
        
        //looping code until the users want to quit playing
        do
        {
            //randomly generating a new number for the round
            bytRandomNum = (byte)(Math.random() * (byte)10+1); 
            
            //looping for as many players as there are so they can all guess
            for(int k=0; k<players.size();k++)
            {
                //looping until the user enters a correct data type
                do
                {
                    //resetting the boolean loop runner to true so the loop will function
                    booRunner = true;
                    
                    //catching runtime errors for incorrect data type
                    try
                    {
                        //taking in the guess of each player
                        System.out.println(players.get(k).getFName()+", please enter your guess between 1 and 10.");
                        bytGuess = new Scanner(System.in).nextByte();
                        
                        //making sure the user entered a number within the parameters given
                        if((bytGuess<=0)||(bytGuess>10))
                        {
                            System.out.println("Error. Please enter a number between 1 and 10");
                        }
                        else
                        {
                            //checking whether the user's guess was correct
                            if(bytGuess == bytRandomNum)
                            {
                                //temporarily holding the previous score of the player in another variable 
                                bytScoreHolder = players.get(k).getScore();
                                
                                //adding 1 to the score
                                bytScoreHolder++;
                                
                                //updating information in the arraylist
                                players.get(k).setScore(bytScoreHolder);
                                
                                //adding the names of the person who won this round to the arraylist
                                Winners.add(players.get(k).getFName());
                                
                            }
                            
                            //breaking the loop by setting the boolean to false
                            booRunner = false;
                        }
                    }
                    catch(Exception e)
                    {
                        //telling the user they inputted an incorrect value
                        System.out.println("ERROR. Please enter a number between 1 and 10");
                    }
                }while(booRunner);
            }
            
            //checking if there were any winners this round and if so, outputting them
            if(Winners.size()==0)
            {
                System.out.println("There were no winners this round");
            }
            else
            {
                //looping for the number of winners there were
                for(String element: Winners)
                {
                    //outputting each user who won this round
                    System.out.println(element+" won this round");
                }
            }
            
            //resetting the boolean loop runner so it can be used again
            booRunner= true;
            
            //looping until the user enters a correct answer to the yes/no question
            do
            {
                //asking user if they would like to add another player
                System.out.println("Would you like to play another round?");
                strKeepPlaying = new Scanner(System.in).nextLine();
                
                //checking to see if the user has made a valid response
                if((strKeepPlaying.equalsIgnoreCase("yes"))||(strKeepPlaying.equalsIgnoreCase("no")))
                {
                    //breaking the loop by setting the boolean to false 
                    booRunner = false;
                }
                else
                {
                    //letting user know they have not entered a valid response
                    System.out.println("Invalid answer. Please enter 'yes' or 'no'");
                }
            }while(booRunner);
            
            //clearing the names of those who won in preparation for the next round
            Winners.clear();
            
            //resetting the loop runner to true in order for the loops to run next round
            booRunner = true;
            
        }while(strKeepPlaying.equalsIgnoreCase("yes"));
        
        //calling method to output the score and calculate the overall winner
        winnerCalculator();
    }
    
    //method to calculate the winners and output the scores of each player
    public void winnerCalculator()
    {
        //creating an instance of type Player to hold the information about the final winner and populating it to be replaced
        Player finalWinner = new Player("PLACEHOLDER", "PLACEHOLDER", (byte)0);
        
        /*setting the score of the final winner placeholder to a negative number so it will always be replaced by the player's name
          this is needed because the constructor automatically sets whatever score it is given at first to zero, 
          and must be overruled by a set method*/
          finalWinner.setScore((byte)-1);
        
        //looping to output each player and their score
        for(Player element: players)
        {
            //outputting the final scores of the players using the ToString from the player class
            System.out.println(element);
            
            
            //checking if the score of the current person is higher than the current recorded highest score
            if(element.getScore() > finalWinner.getScore())
            {
                //if so, replacing the previous information using get ans set methods
                finalWinner.setFName(element.getFName());
                finalWinner.setLName(element.getLName());
                finalWinner.setScore(element.getScore());
                
            }
        }
        
        //checking that there actually was a point won and thus a possible winner
        if(finalWinner.getScore()==0)
        {
            //telling the users there was no winner
            System.out.println("No points were gained, and thus there were no winners.\nTry again some other time!");
        }
        else
        {
            //ouputting the final winner and their score
            System.out.println(finalWinner.getFName()+" "+finalWinner.getLName()+" won the game with a score of "+finalWinner.getScore());
        }
    }
}
