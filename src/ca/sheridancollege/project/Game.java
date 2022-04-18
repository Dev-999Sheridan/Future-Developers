/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;


import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {

    private static String playerName;
    private static int money;
    private static int playerBet;
    private static Card[] hand;
    private static int FaceValue;
    private static int AceCount;

   public static void main(String[] args){
       //take user input
       System.out.println("HELLO! What is your name?");
       Scanner input = new Scanner(System.in);
       playerName = input.nextLine();
       System.out.println("Enter your id");
       String id = input.nextLine();
       System.out.println("Hello, "+playerName+", lets play!!!");
       System.out.println("How much money do you want to start with?");
       money = input.nextInt();
       System.out.println("You start with: "+money);
    
    GroupOfCards Cards=new GroupOfCards(); //create object for group of cards that stores 52 cards
    Cards.shuffle();
    
        System.out.println("How much would you like to bet?");
        playerBet=playerBet(money);
        System.out.println("Money:"+money);
        System.out.println("Money on the table:"+playerBet);
        System.out.println("Here is your hand: "+hand);
        int handvalue = handTotal(hand);
         Player dealer = new Player("dealer") {};
        System.out.println("The dealer is showing: ");
        dealer.showHand();
        if(hasBlackJack(handvalue))//if the player has blackjack then player win the game.
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win your money back!");
            money=money+playerBet;
            Win();
   }
        else if(dealer.hasBlackJack())//if the dealer has blackjack then player lose the game.
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            Lose();
        }
        else
        {
            if(2*playerBet<money)//if the player want for double down then it checks the condition 
            {
                System.out.println("Would you like to double down?");
                String doubleDown = input.nextLine();
                while(!isyesorno(doubleDown))
                {
                    System.out.println("Please enter yes or no."); //take player's input 
                    doubleDown= input.nextLine();
                }
                if(doubleDown.equals("yes")) //if player say yes for double down then player bet will increase 2 times.
                {
                    System.out.println("You have opted to double down!");
                    playerBet=2*playerBet;
                    System.out.println("Cash:"+ money);
                    System.out.println("Money on the table:"+playerBet);
                }
            }
            System.out.println("Would you like to hit or stand?");//ask the player if he or she want to hit or stand
            String hit= input.nextLine();
            while(!isHitorStand(hit))
            {
                System.out.println("Please enter 'hit' or 'stand'.");
                hit = input.nextLine();
            }
            while(hit.equals("hit"))//if player say hits then if check if face value is bigger than 21. if its bigger then player lose.
            {
                hit(Cards, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                FaceValue = handTotal(hand);
                if(FaceValue>21) {
                    Lose();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hit = input.nextLine();
            }
            if(hit.equals("stand"))//player on stand.
            {
                int dealerhand = dealer.takeTurns(Cards);//if he or she say stand then the dealer take turn.
                System.out.println("");
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                if(dealerhand>21)//if the dealer has face value bigger than 21 then player wins else lose.
                {
                    Win();
                }
                else {
                    Lose();
                }
                
                
   }
             }
   }
   
    /**
     * A method for bet
     *
     */
    private static int playerBet(int money) {
    Scanner input=new Scanner(System.in);
    int playerBet=input.nextInt();
    while(playerBet>money)
    {
        System.out.println("You cannot bet with more money than you have");
        System.out.println("How much would you like to bet?");
        playerBet=input.nextInt();
    }
    return playerBet;
}
    /**
     * A method for blackjack card
     * 
     */
    private static boolean hasBlackJack(int Facevalue) {
        if(FaceValue==21)
    {
        return true;
    }
    return false;
}
    /**
     * A method for win game
     * 
     */
    private static void Win() {
    System.out.println("Congratulations, you win!!!");
    money=money+playerBet;
    System.out.println("your winning Cash: "+money);
}
    /**
     * A method for lose game
     * 
     */
    private static void Lose() {
    System.out.println("Sorry, you lose!!");
    money=money-playerBet;
    System.out.println("your total Cash: "+money);

    }
    public static boolean isyesorno(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
    /**
     * A method for calculate hand total
     * 
     */
    private static int handTotal(Card[] hand) {
    int FaceValue=0;
   

    for (int i=0; i<hand.length; i++){
        FaceValue = Game.hand[i].getFaceValue();
      
        if(Game.hand[i].getFaceValue()== 11){
           AceCount++;
            
            } 

    }
   while(FaceValue >21 && AceCount > 0){
        AceCount--;
        FaceValue-=10;
  
}
   return FaceValue;
    }
    
    private static boolean isHitorStand(String hit) {
        if(hit.equals("hit") || hit.equals("stand"))
    {
        return true;
    }
    return false;

    }
    /**
     * A method for hit
     * 
     */
    private static void hit(GroupOfCards Cards, Card[] hand) {
        int FaceValue=0;
   

    for (int i=0; i<hand.length; i++){
        FaceValue = Game.hand[i].getFaceValue();
      
        if(Game.hand[i].getFaceValue()== 11){
           AceCount++;
            
            } 

    }
   while(FaceValue >21 && AceCount > 0){
        AceCount--;
        FaceValue-=10;
  
}
    }
}

    
    
   

   
