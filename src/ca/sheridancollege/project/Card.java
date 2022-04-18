/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Siddhi, Dev
 * Date:17/04/2022
 */
public abstract class Card {
    private int Suit;
    private int Rank;
    private int FaceValue;
    private static String[] Suits = {"Diamonds","Clubs","Sprades","Hearts"};
    private static String[] Ranks = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        
    Card(int suit, int Facevalue) //constructor with argument of suit and facevalue
{
    this.Rank=Facevalue;
    this.Suit=suit;
}
/*
 * Return the rank of a card.
 */
public int getRank()
{
    return Rank;
}
/*
 * Return the suit of a card.
 */
public int getSuit()
{
    return Suit;
}
/*
 * Return the value of a card. 
 */
public int getFaceValue()
{
    if(Rank>10)
    {
        FaceValue=10;
    }
    else
    {
        FaceValue=Rank;
    }
    return FaceValue;
}
/*
 * Set the value of a card.
 */
public void setFaceValue(int set)
{
    FaceValue = set;
}
 /*
 * Returns the string.
 */
    @Override
    public String toString() {
          return Ranks[Rank]+" of "+Suits[Suit];
}
}


