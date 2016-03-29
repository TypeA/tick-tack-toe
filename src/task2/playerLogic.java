package task2;

import java.util.Scanner;

public class playerLogic {
    public static String[][] setPlayerTurn(String[][] array) {
        Boolean flag=true;
        while (flag) {
            Main.Position pos=getPosition();
            if (array[pos.x-1][pos.y-1].equals("-")){
                flag=false;
                array[pos.x-1][pos.y-1]="X";
                System.out.println("\nYour turn is line:"+pos.x+" column:"+pos.y);
            } else {
                System.out.println("You can't place \"X\" here!");
            }
        }
        return array;
    }

    public static Main.Position getPosition() {
        Main.Position pos = new Main.Position();
        Boolean flag=true;
        while (flag) {
            System.out.print("Please enter the line: ");
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                pos.x = in.nextInt();
                if ((pos.x <= 3) && (pos.x >= 1)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Incorrect line nummber");
            }
        }
        flag=true;
        while (flag) {
            System.out.print("Please enter the column: ");
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                pos.y = in.nextInt();
                if ((pos.y <= 3) && (pos.y >= 1)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Incorrect colunm nummber");
            }
        }
        return pos;
    }
}
