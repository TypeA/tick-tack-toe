package task2;

import java.util.Scanner;

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

    public static void printTable(String array[][]) {
        System.out.println("-------------");
        for(int i=0;i<array[0].length;i++) {
            for (int j = 0; j < array[0].length;j++) {
                System.out.print("| " + array[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static String[][] setPlayerTurn(String[][] array) {
        Boolean flag=true;
        while (flag) {
            Position pos=getPosition();
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

    public static String[][] setAiTurn(String[][] array) {
        Position pos= new Position();
        Boolean flag=true;
        while(flag){
            pos.x=(int)(Math.random()*3);
            pos.y=(int)(Math.random()*3);
            if (array[pos.x][pos.y].equals("-")) {
                flag=false;
                array[pos.x][pos.y]="O";
                System.out.println("\nComputer turn is line:"+pos.x+" column:"+pos.y);
            }
        }
        return array;
    }

    public static Position getPosition() {
        Position pos = new Position();
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

    public static Boolean checkWinner(String[][] array) {
        Boolean result=true;
        Boolean deadHeat = true;
        for(int i=0;i<array[0].length;i++) {
            if (array[i][0].equals(array[i][1])&&(array[i][0].equals(array[i][2]))) {
                if (array[i][0].equals("X")) {
                    System.out.println("Player is a winner!");
                    result=false;
                } else if (array[i][0].equals("O")){
                    System.out.println("Computer is a winner");
                    result=false;
                }
            }
        }
        if (result) {
            for(int i=0;i<array[0].length;i++) {
                if (array[0][i].equals(array[1][i])&&(array[2][i].equals(array[0][i]))) {
                    if (array[0][i].equals("X")) {
                        System.out.println("Player is a winner!");
                        result=false;
                    } else if (array[0][i].equals("O")){
                        System.out.println("Computer is a winner");
                        result=false;
                    }
                }
            }
        }
        if ((result)&&((array[0][0].equals(array[1][1])&&array[1][1].equals(array[2][2]))||(array[0][2].equals(array[1][1])&&array[1][1].equals(array[2][0])))){
                if (array[1][1].equals("X")) {
                    System.out.println("Player is a winner!");
                    result = false;
                } else if (array[1][1].equals("O")) {
                    System.out.println("Computer is a winner");
                    result = false;
                }
        }
        if (result) {
            int i=0,j;
            while (deadHeat&&array[0].length>i) {
                j=0;
                while (deadHeat&&array[0].length>j) {
                    if(array[i][j].equals("-")) {
                        deadHeat=false;
                    } else {
                        j++;
                    }
                }
                i++;
            }
            if (deadHeat) {
                System.out.println("Dead heat!");
                return !deadHeat;
            }
        }
        return result;
    }
}
