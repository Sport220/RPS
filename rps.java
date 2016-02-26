import java.util.Scanner;
/**
 * Write a description of class rockPaperScissors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rps
{
    public static Scanner input=new Scanner(System.in); //global variable. it can be used at any point in this program
    public static char pChoice='r';
    public static int cChoice=0;
    public static int choice=0;
    public static int pscore=0;
    public static int cpuscore=0;
    public static int round =1;
    public static int first=1;
    public static String name=null;
    public static int begin=0;
    public static void main(String[] args){
        welcome();
        run();
    }

    public static void welcome(){
        System.out.print("\f");
        System.out.println("welcome to the RPS finals!!");
        try{Thread.sleep(1500);}catch(Exception exc){}
        System.out.println("tonight we have our reigning champ Andrew Bladon!!!!!");
        try{Thread.sleep(1500);}catch(Exception exc){}
        System.out.println("against a newcomer ...... um what was your name again?");
        try{Thread.sleep(1500);}catch(Exception exc){}
        System.out.println("please enter name");
        name =input.next();
        System.out.print("\f");
        System.out.print("GREAT!!! good luck tonight folks. This will be a fight to watch!!");
        try{Thread.sleep(1500);}catch(Exception exc){}
    }

    public static void run(){
        if(first == 1){
            System.out.print("\f");
            first =0;
        }
        playerChoice();
        cpu();
        score();
        check();

    }

    public static void playerChoice(){
        boolean choosing=true; // keeps the while loop going, if its false it stops
        
        //System.out.print("\f");
        //try{Thread.sleep(1000);}catch(Exception exc){}
        while (choosing==true)
        {
            System.out.print("round " +round);
            System.out.println(" FIGHT!");
            if (begin==0){
                System.out.print("Enter r for rock, p for paper, or s for scissors.");
                begin++;
            }
            pChoice=input.next().charAt(0);
            if (pChoice == 'r'){
                choice=1;
                System.out.print(name);
                System.out.println(" choose rock.");
                choosing=false;
            }
            else if (pChoice=='p')
            {
                choice=2;
                System.out.print(name);
                System.out.println(" choose paper.");
                choosing=false;
            } 
            else if (pChoice=='s')
            {
                choice=3;
                System.out.print(name);
                System.out.println(" choose scissors.");
                choosing=false;
            } 
            else 
            {
                System.out.print("Please enter only an r, p, or s.");
            }
        }

    }

    public static void cpu(){
        int random=random(1,3);
        cChoice=random;
        if (random == 1){
            System.out.println("Andrew chose rock.");

        } else if (random == 2){
            System.out.println("Andrew chose paper.");

        } else if (random == 3){
            System.out.println("Andrew chose scissors.");

        } 
        else {
            System.out.print("Please enter only an r, p, or s.");
        }
    }

    public static void score(){
        int option=0;
        if(choice == cChoice){option = 3;}
        if(choice == 1 && cChoice== 2){option =2;}
        if(choice == 1 && cChoice== 3){option = 1;}
        if(choice == 2 && cChoice== 1){option = 1;}
        if(choice == 2 && cChoice== 3){option = 2;}
        if(choice == 3 && cChoice== 1){option = 2;}
        if(choice == 3 && cChoice== 2){option = 1;}
        switch(option){
            case 1: System.out.println("you win!"); pscore=pscore+1; System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check(); break;
            case 2: System.out.println("you lost :("); cpuscore= cpuscore+1; System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check();  break;
            case 3: System.out.println("its a tie"); System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check();  break;
        }
    }

    public static void check(){

        round = round+1;
        if(pscore == 5){
            System.out.print("\f");
            System.out.print("FUCK YEAH "+name); System.out.print(" YOU KICKED HIS ASS!!");
        }
        else if (cpuscore == 5){
            System.out.print("\f");
            System.out.print(name+ ",you have dishonored family...you end life now");
        }
        else if(pscore < 5 || cpuscore < 5){

            clear();

        }
    }

    public static void clear(){
        int loop=1;
        while(loop == 1){
            System.out.print("press 'q' to continue the fight!!!!");   
            char go=input.next().charAt(0);
            if(go == 'q'){
                loop=0;
            }
        }

        //try{Thread.sleep(100);}catch(Exception exc){}
        System.out.print("\f");
        run();
    }

    public static int random(int min,int max){
        return (int)Math.floor(max*Math.random())+min;
    }
}
