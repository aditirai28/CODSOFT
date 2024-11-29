import java.util.Scanner;
public class NumberGame
{
 public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int chances=8;
    int finals=0;
    boolean playAgain=true;
    System.out.println("Ello Mate!");
    System.out.println("Hey Mate you have about " +chances+ " to win this game.");
    System.out.println("Good Luck!");
    while(playAgain){
        int rand=getrandN(1,100);
        boolean guess=false;
        for(int i=0;i<chances;i++){
            System.out.println("Chance "+(i+1)+" Enter your guess:");
            int user=sc.nextInt();
            if(user==rand){
                guess=true;
                finals+=1;
                System.out.println("YOU DID IT !!! (^ U ^)<3");
                break;
            }
            else if(user>rand){
                System.out.println("NAH TOO HIGH MATE:(");
            }
            else{
                System.out.println("nope too low mate  :(");
            }
        }
        if(guess==false){
            System.out.println("Oh noo (T_T) I'm sorry mate. You've Lost all your chances .The number is -> "+rand);
        }
        System.out.println("Do you wanna play Again??(y/n)?");
        String pA=sc.next();
        playAgain=pA.equalsIgnoreCase("y");
    }
    System.out.println("That's it for today mate , hope you enjoyed :) see you soon!!");
    System.out.println("Oh yeah! Your Score:"+finals);
 }
     public static int getrandN(int min,int max){
        return(int)(Math.random()*(max-min+1)+min);
     }

}
