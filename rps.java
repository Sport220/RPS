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
    public static int pfirst = 0;
    public static int psecond = 0;
    public static int pthird = 0;
    public static int pfourth = 0;
    public static int pfifth = 0;
    public static int psixth = 0;
    public static int playerrocks =0;
    public static int playerpapers = 0;
    public static int playerscissors = 0;
    public static int plan=0;
    public static int random=0;
    public static int next=0;
    public static int losenumber=0;
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
        AI();
        cpuChoice();
        record();
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
        random=random(1,3);

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
            case 1: System.out.println("you win!");losenumber=0; pscore=pscore+1; System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check(); break;
            case 2: System.out.println("you lost :(");losenumber=losenumber+1; cpuscore= cpuscore+1; System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check();  break;
            case 3: System.out.println("its a tie"); System.out.print("the score is "+name +pscore); System.out.println("  Andrew:"+cpuscore); check();  break;
        }
    }

    public static void check(){

        round = round+1;
        if(pscore == 50){ //temp changed to 50 for testing
            System.out.print("\f");
            System.out.print("FUCK YEAH "+name); System.out.print(" YOU KICKED HIS ASS!!");
        }
        else if (cpuscore == 50){
            System.out.print("\f");
            System.out.print(name+ ",you have dishonored family...you end life now");
        }
        else if(pscore < 50 || cpuscore < 50){

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
            if (go == 'm'){
                cpuscore=50;
                check();
            }
        }

        //try{Thread.sleep(100);}catch(Exception exc){}
        System.out.print("\f");
        run();
    }

    public static int random(int min,int max){
        return (int)Math.floor(max*Math.random())+min;
    }

    public static void AI(){
        plan=1;
        boolean brainblast=true;
        while (brainblast==true){
            switch (plan){
                case 1:   

                if(pfirst == 1 && psecond==2){next=1;}
                else if(pfirst == 2 && psecond==3){next=2;brainblast=false;}
                else if(pfirst == 3 && psecond==1){next=3;brainblast=false;}
                else if(pfirst == 3 && psecond==2){next=2;brainblast=false;}
                else if(pfirst == 2 && psecond==1){next=1;brainblast=false;}
                else if(pfirst == 1 && psecond==3){next=3;brainblast=false;} 
                else{ plan++; } break;
                case 2: 
                if(playerrocks > playerscissors+5){if(playerrocks> playerpapers+5){if (pfirst!=1 && psecond!=1){{next=2;brainblast=false;}}}}
                        else if(playerpapers> playerrocks+5){if(playerpapers>playerscissors+5){if (pfirst!=2 && psecond!=2){{next=3;brainblast=false;}}}}
                        else if(playerscissors> playerrocks+5){if(playerscissors>playerpapers+5){if (pfirst!=3 && psecond!=3){{next=1;brainblast=false;}}}}
                        else{plan++;} break;
                case 3: if(losenumber>5){random=random(1,3); next=random;brainblast=false;}else{plan++;} break;
                case 4:if(playerrocks > playerscissors+3){if(playerrocks> playerpapers+3){next=2;brainblast=false;}}
                        else if(playerpapers> playerrocks+3){if(playerpapers>playerscissors+3){next=3;brainblast=false;}}
                        else if(playerscissors> playerrocks+3){if(playerscissors>playerpapers+3){next=1;brainblast=false;}}
                        else{plan++;}break; 
                case 5:random=random(1,3); next=random;brainblast=false;     break;
            }
        }
    }

    public static void cpuChoice(){
        cChoice=next;
        if(next==0){next=3;}
        if(next==4){next=1;}
        if (cChoice == 1){
            System.out.println("Andrew chose rock.");

        } else if (cChoice == 2){
            System.out.println("Andrew chose paper.");

        } else if (cChoice == 3){
            System.out.println("Andrew chose scissors.");

        } 

    }

    public static void record(){
        if (choice == 1){
            playerrocks++;   
        }
        if (choice == 2){
            playerpapers++;   
        }
        if (choice == 3){
            playerscissors++;   
        }
        psixth= pfifth;
        pfifth = pfourth;
        pfourth = pthird;
        pthird = psecond;
        psecond = pfirst; 
        pfirst = choice;

    }
}
