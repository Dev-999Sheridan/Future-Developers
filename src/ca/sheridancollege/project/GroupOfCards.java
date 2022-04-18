/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.Random;


/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    
private Card[] Cards; //The group of cards, stored in an Array
private int numOfCards;

// This constructor builds a deck of 52 cards.
public GroupOfCards()
{
    int cards = 0;
    this.numOfCards = 52;
    this.Cards = new Card[this.numOfCards];

    for(int i = 0; i < 4; i++){
        for(int j = 1; j <= 13; j++){
            this.Cards[cards] = new Card (i, j) {};
            cards++;
        }
    }
  }

    

    /**
     * A method that will get shuffle cards.
     *
     * 
     */
    

    public void shuffle() {
        Random r = new Random();

    Card temp;

    int j;
    for(int i = 0; i < this.numOfCards; i++){
        j = r.nextInt(this.numOfCards);
        temp = this.Cards[i]; 
        this.Cards[i]= this.Cards[j];
        this.Cards[j] = temp;
    }
}

    
    }


    

   


