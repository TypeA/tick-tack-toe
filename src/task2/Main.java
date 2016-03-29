package task2;

import java.util.Scanner;

import static task2.basicAiLogic.setAiTurn;
import static task2.gameMethods.checkWinner;
import static task2.gameMethods.printTable;
import static task2.playerLogic.setPlayerTurn;

public class Main {

   static class Position {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Boolean flag=true,repeat=true;
        int counter=1;
        System.out.println("\n Welcome to tick-tack-toe game!");
        while (repeat){
            String[][] table={{"-","-","-"},{"-","-","-"},{"-","-","-"}};
            printTable(table);
            while(flag) {
                System.out.println("\nThis is round "+counter);
                table=setPlayerTurn(table);
                printTable(table);
                flag=checkWinner(table);
                if(flag) {
                    table = setAiTurn(table);
                    printTable(table);
                    flag=checkWinner(table);
                }
                counter++;
            }
            counter=1;
            flag=true;
            System.out.println("\n==================GAME OVER==================");
            System.out.print("Enter \"y\" to repeat:");
            Scanner in = new Scanner(System.in);
            repeat=in.next().toUpperCase().equals("Y");
            System.out.println("\n\n\n");
        }
        System.out.println("Bye!");
    }

}
