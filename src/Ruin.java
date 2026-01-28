import java.util.Scanner;

public class Ruin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter starting amount: ");
        int startAmount = in.nextInt();
        System.out.print("Enter win probability(as a decimal): ");
         double winChance = in.nextDouble();
        System.out.print("Enter winning amount: ");
        double winLimit = in.nextInt();
        System.out.print("Enter number of days to simulate: ");
        int totalSimulations = in.nextInt();
        
        int current;
        int count = 0;
        double wcount = 0;
        double lcount = 0;

        for (int f = 1; f<=totalSimulations;f++){
            current = startAmount;
            count = 0;
            while ((current> 0) && (current< winLimit)) {
                count++;
                if (winChance >= Math.random()) {
                    current++;
                } else {
                    current--;
             }
            }
            System.out.println("Day " + f + " you played this many games: " + count);
            if (current>0){
                System.out.println("You won!");
                wcount++;
            } else {
                System.out.println("You lost!");
                lcount++;
            }
        }

        double rpercent = 100*(lcount/totalSimulations);
        System.out.println("Ruin percentage: " + rpercent);
        
        double a = (1-winChance)/winChance;
        double expectedRuin;
        if(winChance == 0.5){
            expectedRuin = 1-(startAmount/winLimit);
        }
        else{
            expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
        }
        System.out.println("Expected Ruin rate:" + expectedRuin);
    }

}
