package task2;

public class gameMethods {
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
