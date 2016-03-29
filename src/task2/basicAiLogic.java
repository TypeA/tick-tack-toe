package task2;

public class basicAiLogic {

    public static String[][] setAiTurn(String[][] array) {
        Boolean flag=true;
        Main.Position pos = new Main.Position();
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
}
