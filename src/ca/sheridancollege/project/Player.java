/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

    private String name; //the unique name for this player
    private double balance;
    private Card[] hand;
    private double Bet;
    private int numOfCards = 0;
    private int FaceValue=0;
    private String id; //the unique id for this player


    /**
     * A constructor that allows you to set the player's name 
     *
     * @param name the name is assign to this player.
     * 
     */
    public Player(String name) {
        this.name = name;
        
    }
    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Ensure that the playerID is unique
     *
     * @param id the player id to set
     * @return the player id
     * 
     */
    public String getId(String id) {
        return id;
    }
   public void setId(String id) {
       this.id=id;
   }
    /**
     * @return the bet
     */
    public double getBet() {
    return Bet;
    }

    public void setBet(double Bet) {
    this.Bet =Bet;
    }
    /**
     * @return the player account balance
     */

    public double getBalance() {
    return balance;
    }
    /**
     * @return the player's card in hand
     */
    public Card[] getHand() {
    return hand;
    }

public Player(String name, double amount){ //constructor with argument
    this.name = name;
    this.balance = amount;
    this.Bet = 0;
    this.hand = new Card[11];
}
public void addCard2(Card c){ //method to add another card
    this.hand[this.numOfCards] = c;
    numOfCards ++;
}
public void resetHand(){ //method to reset cards in hand
    this.hand = new Card[11];
    this.numOfCards = 0;
}
public boolean addCard(Card aCard){ //method to add card

    if(this.numOfCards ==10){
        System.err.printf("%s's hand already has 10 cards\n", 

    this.name );
        System.exit(1);
    }
    this.hand[this.numOfCards]=aCard;
    this.numOfCards++;
        return false;
    
}
public void  Hit(){ //method for hit 
    int handTotal = 0;
    int highestTotal=0;
    int cardNumber;
    int total = 0;

    for (int i=0; i<this.numOfCards; i++){
        cardNumber = this.hand[i].getFaceValue();
      
        if(cardNumber== 1){
            total++;
            handTotal+=11;
            } 

    }
   if(handTotal <=21 && handTotal > highestTotal){
        highestTotal=handTotal;
  
}
   
    }
public void showHand() //method to show card in hand
{
    System.out.println(hand);
}
public boolean hasBlackJack() //method if player or dealer have blackjack card in hand
{
        
    if(hand.length==2 && FaceValue==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}

    public int takeTurns(GroupOfCards Cards) { //method for player to take turn 
        System.out.println("The player hits");
        Hit();
      if(FaceValue<=21)
    {
        System.out.print("The dealer stands.");
    }
    return FaceValue;
}
    }

   
