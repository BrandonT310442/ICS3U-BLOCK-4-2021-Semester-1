package week7;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    public static final String ANSI_CYAN = "\033[32;1m"; // changes terminal color
    public static final String ANSI_RESET = "\u001B[0m"; // changes terminal color back to normal
    
    /**
     * The global class creates global variables so they can be changed easily
     */
    public class Global {
      public static String topcard = "";
      public static int playerPoints = 0;
      public static int c1Points = 0;
      public static int c2Points = 0;
  
  }
  /**
   * The main method runs all the methods needed to run the game. 
   * It first runs the textBloccks mathod which prints out the Crazy Eight sign at the start of the game.
   * Following that it creates a scanner 
   * A while loop is then created and it keeps running the game untill any player exceeds 100 points
   * Inside the while loop 3 different hands are created (one for the player, two for the computer players)
   * It then ensures that all of the players have more than one card in their hand if not, the game is either over or the round is over. 
   * It then calls the process player method and it takes in the scanner and player hand. 
   * It then makes makes sure that the opponent hands still have more than card, that way it doesn't continue the game from running if someone has gotten rid of all their cards. 
   * In addition Thread.sleep is used to ensure that there is a delay so it doesn't all print at once. 
   * After that the processComputer() method is called. 
   * Lastly it calls the getWinner() method after someone has exceeded 100 points. 
   */
    public static void main(String[] args) {
        
      
      textBlocks();
      
        Scanner in = new Scanner(System.in);

while (Global.playerPoints < 100 && Global.c1Points < 100 && Global.c2Points < 100){
        String playerHand = CreateHand();
        String c1Hand =  CreateHand();
        String c2Hand = CreateHand();
       Global.topcard = "";
        
        
   
     while (playerHand.length() >=4 && c1Hand.length() >=4 && c2Hand.length()>=4){

     
      


        playerHand = processPlayer(in, playerHand);
        if (playerHand.length() <= 2){
           
System.out.println("▒█▀▀█ ▒█▀▀▀█ ▒█░▒█ ▒█▄░▒█ ▒█▀▀▄ 　 ▒█▀▀▀█ ▒█░░▒█ ▒█▀▀▀ ▒█▀▀█"); 
System.out.println("▒█▄▄▀ ▒█░░▒█ ▒█░▒█ ▒█▒█▒█ ▒█░▒█ 　 ▒█░░▒█ ░▒█▒█░ ▒█▀▀▀ ▒█▄▄▀"); 
System.out.println("▒█░▒█ ▒█▄▄▄█ ░▀▄▄▀ ▒█░░▀█ ▒█▄▄▀ 　 ▒█▄▄▄█ ░░▀▄▀░ ▒█▄▄▄ ▒█░▒█");
System.out.println();
System.out.println();
updatePoints(playerHand, c1Hand,c2Hand);
         System.out.println("You Won The Round!!!");
         System.out.println();
         System.out.println();
        }

        if (c2Hand.length() > 3 && playerHand.length() >3){
         try
         {
             Thread.sleep(1000);
         
        c1Hand = processComputer(c1Hand, "Computer 1",playerHand,c2Hand);
         }catch(InterruptedException ex)
         {
             Thread.currentThread().interrupt();
         }
        }
        if (c1Hand.length() <=2){
         System.out.println("▒█▀▀█ ▒█▀▀▀█ ▒█░▒█ ▒█▄░▒█ ▒█▀▀▄ 　 ▒█▀▀▀█ ▒█░░▒█ ▒█▀▀▀ ▒█▀▀█"); 
         System.out.println("▒█▄▄▀ ▒█░░▒█ ▒█░▒█ ▒█▒█▒█ ▒█░▒█ 　 ▒█░░▒█ ░▒█▒█░ ▒█▀▀▀ ▒█▄▄▀"); 
         System.out.println("▒█░▒█ ▒█▄▄▄█ ░▀▄▄▀ ▒█░░▀█ ▒█▄▄▀ 　 ▒█▄▄▄█ ░░▀▄▀░ ▒█▄▄▄ ▒█░▒█");
         System.out.println();
         System.out.println();
         updatePoints(playerHand, c1Hand,c2Hand);
         System.out.println("Computer 1 Won The Round!!!");
         System.out.println();
         System.out.println();
      
      }

      if (c1Hand.length() > 3 && playerHand.length() > 3){
         try
         {
             Thread.sleep(1500);
         
             c2Hand = processComputer(c2Hand, "Computer 2",playerHand,c1Hand);
         }catch(InterruptedException ex)
         {
             Thread.currentThread().interrupt();
         }
   
      }
        if (c2Hand.length() <=2){
         System.out.println("▒█▀▀█ ▒█▀▀▀█ ▒█░▒█ ▒█▄░▒█ ▒█▀▀▄ 　 ▒█▀▀▀█ ▒█░░▒█ ▒█▀▀▀ ▒█▀▀█"); 
         System.out.println("▒█▄▄▀ ▒█░░▒█ ▒█░▒█ ▒█▒█▒█ ▒█░▒█ 　 ▒█░░▒█ ░▒█▒█░ ▒█▀▀▀ ▒█▄▄▀"); 
         System.out.println("▒█░▒█ ▒█▄▄▄█ ░▀▄▄▀ ▒█░░▀█ ▒█▄▄▀ 　 ▒█▄▄▄█ ░░▀▄▀░ ▒█▄▄▄ ▒█░▒█");
         System.out.println();
         System.out.println();
         updatePoints(playerHand, c1Hand,c2Hand);
System.out.println("Computer 2 Won The Round!!!"); 
System.out.println();
         System.out.println();
        
        }
     }
    }

    getWinner();

   }


    private static void getWinner() {

      if (Global.playerPoints < Global.c1Points && Global.playerPoints < Global.c2Points){
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("You Won!!!");
      }else if (Global.c1Points < Global.playerPoints && Global.c1Points < Global.c2Points){
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("Computer 1 Won!!!");
      }else if (Global.c2Points < Global.playerPoints && Global.c2Points < Global.c1Points){
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("Computer 2 Won!!!");
      }else if (Global.playerPoints == Global.c1Points){
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("You and Computer 1 Have Tied!!!");
      }else if (Global.playerPoints == Global.c2Points){
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("You and Computer 2 Have Tied!!!");
      }else{
         System.out.println("                                                     ");
         System.out.println("░█▀▀█ ─█▀▀█ ░█▀▄▀█ ░█▀▀▀ 　 ░█▀▀▀█ ░█──░█ ░█▀▀▀ ░█▀▀█"); 
         System.out.println("░█─▄▄ ░█▄▄█ ░█░█░█ ░█▀▀▀ 　 ░█──░█ ─░█░█─ ░█▀▀▀ ░█▄▄▀"); 
         System.out.println("░█▄▄█ ░█─░█ ░█──░█ ░█▄▄▄ 　 ░█▄▄▄█ ──▀▄▀─ ░█▄▄▄ ░█─░█");
         System.out.println();
         System.out.println("Computer 1 and Computer 2 Have Tied!!!");
      }

   }

   public static void textBlocks(){

System.out.println();

System.out.println(ANSI_CYAN+"▒█▀▀█ ▒█▀▀█ ░█▀▀█ ▒█▀▀▀█ ▒█░░▒█ 　 ▒█▀▀▀ ▀█▀ ▒█▀▀█ ▒█░▒█ ▀▀█▀▀ ▒█▀▀▀█"); 
System.out.println(ANSI_CYAN+"▒█░░░ ▒█▄▄▀ ▒█▄▄█ ░▄▄▄▀▀ ▒█▄▄▄█ 　 ▒█▀▀▀ ▒█░ ▒█░▄▄ ▒█▀▀█ ░▒█░░ ░▀▀▀▄▄"); 
System.out.println(ANSI_CYAN+"▒█▄▄█ ▒█░▒█ ▒█░▒█ ▒█▄▄▄█ ░░▒█░░ 　 ▒█▄▄▄ ▄█▄ ▒█▄▄█ ▒█░▒█ ░▒█░░ ▒█▄▄▄█");
//System.out.println(ANSI_CYAN +"             █▀▀ █▀█ ▄▀█ ▀█ █▄█   █▀▀ █ █▀▀ █░█ ▀█▀ █▀              ");
//System.out.println(ANSI_CYAN +"             █▄▄ █▀▄ █▀█ █▄ ░█░   ██▄ █ █▄█ █▀█ ░█░ ▄█              ");
System.out.println();

System.out.println("                  𝒜 𝑔𝒶𝓂𝑒 𝒸𝓇𝑒𝒶𝓉𝑒𝒹 𝒷𝓎: 𝐵𝓇𝒶𝓃𝒹𝑜𝓃 𝒯");
System.out.println();
System.out.println("                  ┌─────────┐       ┌─────────┐              ");
System.out.println("                  │8        │       │8        │              ");
System.out.println("                  │         │       │         │              ");
System.out.println("                  │         │       │         │              ");
System.out.println("                  │    ♥    │       │    ♠️    │              ");
System.out.println("                  │         │       │         │              ");
System.out.println("                  │         │       │         │              ");
System.out.println("                  │        8│       │        8│              ");
System.out.println("                  └─────────┘       └─────────┘              ");
System.out.println();

    }

/**
 * The update method takes in all of the hands.
 * @param playerHand // This is a string and it is the player hand after the round is over.
 * @param c1Hand // This is a string and is is the c1 hand after the round is over
 * @param c2Hand // This is a string and it is the c2 hand after the round is over. 
 * Its void so it doesn't return anything instead it prints out the score for each player at the end of a round. 
 */


private static void updatePoints(String playerHand, String c1Hand, String c2Hand) {

String temp = "";
String temp2 = "";
String temp3 = "";
 for (int i = 0; i < playerHand.length(); i++){

 temp = playerHand.substring(i,i+1);
   if (temp.indexOf("2") >= 0){
Global.playerPoints+=2;
   }

   if (temp.indexOf("3") >= 0){
      Global.playerPoints+=3;
         }

   if (temp.indexOf("4") >= 0){
            Global.playerPoints+=4;
               }

   if (temp.indexOf("5") >= 0){
      Global.playerPoints+=5;
   }

if (temp.indexOf("6") >= 0){
      Global.playerPoints+=6;
}

if (temp.indexOf("7") >= 0){
   Global.playerPoints+=7;
 }
if (temp.indexOf("8") >= 0){
  Global.playerPoints+=50;
    }

    if (temp.indexOf("9") >= 0){
       Global.playerPoints+=9;
         }

         if (temp.indexOf("1") >= 0 ||temp.indexOf("J") >= 0 ||temp.indexOf("Q") >= 0 ||temp.indexOf("K") >= 0){
            Global.playerPoints+= 10;
         }

         if (temp.indexOf("A") >= 0){

            Global.playerPoints+=1;
         }

         
      }


      for (int i = 0; i < c1Hand.length(); i++){
         temp2 = c1Hand.substring(i,i+1);
   if (temp2.indexOf("2") >= 0){
Global.c1Points+=2;
   }

   if (temp2.indexOf("3") >= 0){
      Global.c1Points+=3;
         }

   if (temp2.indexOf("4") >= 0){
            Global.c1Points+=4;
               }

   if (temp2.indexOf("5") >= 0){
      Global.c1Points+=5;
   }

if (temp2.indexOf("6") >= 0){
      Global.c1Points+=6;
}

if (temp2.indexOf("7") >= 0){
   Global.c1Points+=7;
 }
if (temp2.indexOf("8") >= 0){
  Global.c1Points+=50;
    }

    if (temp2.indexOf("9") >= 0){
       Global.c1Points+=9;
         }

         if (temp2.indexOf("1") >= 0 ||temp2.indexOf("J") >= 0 ||temp2.indexOf("Q") >= 0 ||temp2.indexOf("K") >= 0){
            Global.c1Points+= 10;
         }

         if (temp2.indexOf("A") >= 0){

            Global.c1Points+=1;
         }

      }
         
      for (int i = 0; i < c2Hand.length(); i++){
         temp3 = c2Hand.substring(i, i+1);
   if (temp3.indexOf("2") >= 0){
      Global.c2Points+=2;
         }
      
         if (temp3.indexOf("3") >= 0){
            Global.c2Points+=3;
               }
      
         if (temp3.indexOf("4") >= 0){
                  Global.c2Points+=4;
                     }
      
         if (temp3.indexOf("5") >= 0){
            Global.c2Points+=5;
         }
      
      if (temp3.indexOf("6") >= 0){
            Global.c2Points+=6;
      }
      
      if (temp3.indexOf("7") >= 0){
         Global.c2Points+=7;
       }
      if (temp3.indexOf("8") >= 0){
        Global.c2Points+=50;
          }
      
          if (temp3.indexOf("9") >= 0){
             Global.c2Points+=9;
               }
      
               if (temp3.indexOf("1") >= 0 ||temp3.indexOf("J") >= 0 ||temp3.indexOf("Q") >= 0 ||temp3.indexOf("K") >= 0){
                  Global.c2Points+= 10;
               }
      
               if (c2Hand.indexOf("A") >= 0){
      
                  Global.c2Points+=1;
               }

            }
                  
System.out.println("Your Score: "+Global.playerPoints);
System.out.println("C1 Score: "+Global.c1Points);
System.out.println("C2 Score: "+Global.c2Points);
   }

 /**
  * This method process the player and it essentially runs the game for the player 
  * @param in // is the scanner and it is used to ask which card the player would like to play and what card they want to change to if they play an 8
  * @param playerHand // is the generated playerHand that was created in the main method.
  * @return // returns the updated playerHand after a player plays a card
  * 
  */

private static String processPlayer(Scanner in, String playerHand) {

   int counter2 = 1;
   int counter3 = 0;
   if (Global.topcard.equals("")){
      Global.topcard = deck();
      System.out.println("The current top card is: "+Global.topcard);
   }
    boolean validInput = false;


    String facetop = "";
    String suittop = Global.topcard.substring(Global.topcard.length()-1);
    
    if (Global.topcard.length() >= 3){
    facetop = Global.topcard.substring(0,2);
    }else{
       facetop = Global.topcard.substring(0,1);
    }


    if (playerHand.indexOf(facetop) < 0 && playerHand.indexOf(suittop) < 0){
      while (playerHand.indexOf(facetop) < 0 && playerHand.indexOf(suittop) < 0 && playerHand.indexOf("8") <0){
   
         if (counter2 <= 5){
         
            String getcard = getCard();
         playerHand = playerHand+getcard+" ";
         
       System.out.println("You have no avaialble card to play, You have picked up a : "+getcard);
       counter2++;
         }else{
            System.out.println("You have picked up a maximum of 5 cards your turn has been skipped");
            System.out.println("The current top card is: "+Global.topcard);
            System.out.println();
            System.out.println();
            return playerHand;
         }
        
      }
   }

         System.out.println("Your hand is: "+playerHand);
      

      
          
     
        while (!validInput){

        
            System.out.print("Type the card you would like to play: ");
        String removeCard = in.nextLine().toUpperCase();
        if (removeCard.length() >1){
        if (removeCard.indexOf("8") >= 0){
         String suit = "";
         boolean validInput2 = false;
         boolean validInput3 = false;
         while(!validInput2){
            System.out.println("What suit would you like to change to? [H, S, D, C]");
             suit = in.nextLine().toUpperCase();
      
             if (suit.equals("H")){
counter3++;
               Global.topcard = "8H";
               validInput2 = true;
             }else if (suit.equals("S")){
               counter3++;
                Global.topcard = "8S";
                validInput2 = true;
             }else if (suit.equals("D")){
               counter3++;
                Global.topcard = "8D";
                validInput2 = true;
             }else if (suit.equals("C")){
               counter3++;
               Global.topcard = "8C";
               validInput2 = true;
             }else{
                System.out.println("Invalid Input!");
             }
         }
            
      
      
            System.out.println("Current Top Card: "+Global.topcard);
         
     
      }
        int occ = playerHand.indexOf(removeCard);

        String face = "";
        String suit = removeCard.substring(removeCard.length()-1);
        
        if (removeCard.length() >= 3){
        face = removeCard.substring(0,2);
        }else{
           face = removeCard.substring(0,1);
        }

        if ((occ >= 0 && removeCard.indexOf(" ")<0) && counter3 == 0 && (face.equals(facetop) || suit.equals(suittop) || removeCard.indexOf("8") < 0)){

         Global.topcard = removeCard;
         System.out.println("The current top card is: "+Global.topcard);

        }

// 
        if ((occ >= 0 && removeCard.indexOf(" ")<0) && (face.equals(facetop) || suit.equals(suittop) || removeCard.indexOf("8") >= 0)){
         int index = playerHand.indexOf(removeCard);
           System.out.println("Your hand is now: "+playerHand.replaceFirst(playerHand.substring(index, playerHand.indexOf(" ", index) + 1), ""));
           System.out.println();
           System.out.println();
           System.out.println();
         return playerHand.replaceFirst(playerHand.substring(index, playerHand.indexOf(" ", index) + 1), "");
        }else{
           System.out.println("Invalid Input!");
        }

        
  
        }else{
         System.out.println("Invalid Input!");
      }
   }
        return playerHand;
      }


      /**
       * Proccesses the computer and essientially runs the game for the computer
       * @param cHand // takes in the computer hand that was created in the main method
       * @param name // takes in the computer name
       * @param opphand1 // its is the first opponent hand that way  the computer knows when the opponent hand has one card left, to change the suit if possible. 
       * @param opphand2 // its the second opponent hand that way the computer knows when the opponent hand has one card left, to change the suit if possible.
       * @return // returns the computer hand after the computer has played
       */

private static String processComputer(String cHand, String name, String opphand1, String opphand2) {
String temp = "";
int counter3 = 0;
   int counter2 = 1;
   if (Global.topcard.equals("")){
      Global.topcard = deck();
      System.out.println("The current top card is: "+Global.topcard);
   }
    boolean validInput = false;
int counter = 0;

    String facetop = "";
    String suittop = Global.topcard.substring(Global.topcard.length()-1);
    
    if (Global.topcard.length() >= 3){
    facetop = Global.topcard.substring(0,2);
    }else{
       facetop = Global.topcard.substring(0,1);
    }


    if (cHand.indexOf(facetop) < 0 && cHand.indexOf(suittop) < 0){
      while (cHand.indexOf(facetop) < 0 && cHand.indexOf(suittop) < 0 && cHand.indexOf("8") <0){
   
         if (counter2 <= 5){
         
         cHand+=getCard()+" ";
         
       System.out.println("No avaialble card to play,"+" "+name+" "+"picks up a card!");
       counter2++;
         }else{
            System.out.println(name+" has picked up a maximum of 5 cards their turn has been skipped");
            System.out.println("The current top card is: "+Global.topcard);
            System.out.println();
            System.out.println();
            return cHand;
         }
        
      }
   }else{


     
   

      
      System.out.println(name+" hand: "+changetoX(cHand));
      }

      
          
     
        while (!validInput){

        
            System.out.println(name+" is thinking....");
        String removeCard = "";
int suitocc = cHand.indexOf(suittop);
int rankocc = cHand.indexOf(facetop);


if (opphand1.length() <=5 || opphand2.length() <=5){
   String suit = "";
   if (cHand.indexOf("8") >= 0){
      
      removeCard = "8"+cHand.substring(cHand.indexOf("8")+1,cHand.indexOf("8")+2);
      boolean validInput3 = false;
      System.out.println("What suit would you like to change to? [H, S, D, C]");
      int num = 0;
      while(!validInput3){
        
      
         num = (int)(Math.random()*NUM_SUITS);

         if (num == 0){
            counter3++;
            suit = "H";
         }else if (num == 1){
            counter3++;
            suit = "S";
         } else if (num == 2){
counter3++;
            suit = "D";
         }else if (num == 3){
            counter3++;
            suit = "C";
         }
   
         if (cHand.length() <= 5){
            validInput3 = true;
            System.out.println(name+" has decided to change the suit to: "+suit);
            Global.topcard = "8"+suit;
         }else if (cHand.indexOf(suit) >= 0 && !Global.topcard.substring(Global.topcard.length()-1).equals(suit)){
   
            validInput3 = true;
            System.out.println(name+" has decided to change the suit to: "+suit);
            Global.topcard = "8"+suit;
          }
          }
          System.out.println("Current Top Card: "+Global.topcard);
         }else if (rankocc >= 0 && !cHand.substring(rankocc+1, rankocc+2).equals(suittop)){
            String check = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
            if (check.equals("10") || check.equals("0") || check.equals("1")){
               removeCard = cHand.substring(rankocc, rankocc+2)+cHand.substring(rankocc+2, rankocc+3);
               
            }else{
               removeCard = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
            }
         
            System.out.println(name+" has played a "+ removeCard);
         }else if (suitocc >= 0 && !cHand.substring(suitocc-1, suitocc).equals("8")){
            if (cHand.substring(suitocc-1, suitocc).equals("0")){
               
               removeCard = (cHand.substring(suitocc-2, suitocc))+cHand.substring(suitocc,suitocc+1);
            }else{
              
            removeCard = (cHand.substring(suitocc-1, suitocc))+cHand.substring(suitocc,suitocc+1);
            }
            System.out.println(name+" has played a "+ removeCard);
           }else if (rankocc >=0){
           String check = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
            if (check.equals("10") || check.equals("0") || check.equals("1")){
               removeCard = cHand.substring(rankocc, rankocc+2)+cHand.substring(rankocc+2, rankocc+3);
               
            }else{
               removeCard = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
            }
            System.out.println(name+" has played a "+ removeCard);
         }
   
         Global.topcard = removeCard;
     
      
      
      }else if (suitocc >= 0 && !cHand.substring(suitocc-1, suitocc).equals("8")){
         if (cHand.substring(suitocc-1, suitocc).equals("0")){
            
            removeCard = (cHand.substring(suitocc-2, suitocc))+cHand.substring(suitocc,suitocc+1);
         }else{
           
         removeCard = (cHand.substring(suitocc-1, suitocc))+cHand.substring(suitocc,suitocc+1);
         }
         System.out.println(name+" has played a "+ removeCard);
        }else if (rankocc >=0 && Global.topcard.indexOf("8") < 0){
        String check = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
         if (check.equals("10") || check.equals("0") || check.equals("1")){
            removeCard = cHand.substring(rankocc, rankocc+2)+cHand.substring(rankocc+2, rankocc+3);
            
         }else{
            removeCard = cHand.substring(rankocc, rankocc+1)+cHand.substring(rankocc+1, rankocc+2);
         }
         System.out.println(name+" has played a "+ removeCard);
        }else if (cHand.indexOf("8") >= 0){
         String suit = "";
         removeCard = "8"+cHand.substring(cHand.indexOf("8")+1,cHand.indexOf("8")+2);
         boolean validInput2 = false;
         boolean validInput3 = false;
         int num = 0;
         System.out.println("What suit would you like to change to? [H, S, D, C]");
         while(!validInput2){
            
         
            num = (int)(Math.random()*4);

            if (num == 0){
               counter3++;
               suit = "H";
            }else if (num == 1){
               counter3++;
               suit = "S";
            } else if (num == 2){
               counter3++;
               suit = "D";
            }else if (num == 3){
               counter3++;
               suit = "C";
            }
      
            if (cHand.indexOf(suit) >= 0 || cHand.length() == 4){
      
               validInput2 = true;
               System.out.println(name+" has decided to change the suit to: "+suit);
             }
         }
         /** 
            if (Global.topcard.indexOf(suit) >=0){

               while (counter3 == 0){
      
                  counter3++;
                  String tempdeck = deck();
               Global.topcard = tempdeck.substring(0,tempdeck.length()-1)+suit;
            }
            
            }else{
      */
           Global.topcard = "8"+suit;
         
      
            System.out.println("Current Top Card: "+Global.topcard);
         
     
      }
    
        int occ = cHand.indexOf(removeCard);

        String face = "";
       
        String suit = removeCard.substring(removeCard.length()-1);
   
        if (removeCard.length() >= 3){
        face = removeCard.substring(0,2);
        }else{
           face = removeCard.substring(0,1);
        }

        if ((occ >= 0 && removeCard.indexOf(" ")<0) && counter3 == 0 && (face.equals(facetop) || suit.equals(suittop) || removeCard.indexOf("8") < 0)){

         Global.topcard = removeCard;
         System.out.println("The current top card is: "+Global.topcard);

        }

// 
        if ((occ >= 0 && removeCard.indexOf(" ")<0) && (face.equals(facetop) || suit.equals(suittop) || removeCard.indexOf("8") >= 0)){
         int index = cHand.indexOf(removeCard);
         cHand = cHand.replaceFirst(cHand.substring(index, cHand.indexOf(" ", index) + 1), "");
         System.out.println(name+" Hand is now: "+changetoX(cHand));
         
         System.out.println();
           System.out.println();
           System.out.println();
         return cHand;
        }else{
           System.out.println("Invalid Input!");
        }

        
  
        }
        return "";
        
      }

    
/**
 * Takes in the computer hand and changes the computer hand to x's
 * @param cHand // it is the computer hand
 * @return // returns the hand that is converted to x's
 */


private static String changetoX(String cHand) {
String temp = "";

for (int i = 0; i < cHand.length(); i++){
         
   if (cHand.charAt(i) == ' '){
     
      temp+=" ";

   }else{

      temp+="X";
   }
  
}
return temp;

}
/**
 * Creates the starting card and ensures that it is not an 8
 * @return
 */

private static String deck() {
        String flippedCard = getCard();

        while (flippedCard.indexOf("8") >=0){

            flippedCard = getCard();
        }

        return flippedCard;
    }

/**
 * creates a hand
 * @return // returns a hand
 */

private static String CreateHand() {

   String playerHand = " "+getCard()+" "+getCard()+" "+getCard()+" "+getCard()+" "+getCard()+" ";

return playerHand;
    
}

/**
 * Creates a get card method 
 * @return it will return a card
 */
private static String getCard() {
    String card = getFace() + getSuit();

    
    return card;
 }
/**
 * Creates a method to create a suit of a card
 * @return // returns the suit
 */
 private static String getSuit() {
    int suit = (int) (Math.random() * NUM_SUITS);

    if (suit == 0)
       return HEARTS;
    else if (suit == 1)
       return DIAMONDS;
    else if (suit == 2)
       return CLUBS;
    else
       return SPADES;

 }

 /**
  * 
  * Creates a method to create a face of a card
  * Returns the face of the card
  */

 private static String getFace() {
    int suit = (int) (Math.random() * CARDS_PER_SUIT);
    if (suit >= 2 && suit <= 10)
       return suit + "";
    else if (suit == 1)
       return ACE;
    else if (suit == 11)
       return JACK;
    else if (suit == 12)
       return QUEEN;
    else
       return KING;

 }

}
