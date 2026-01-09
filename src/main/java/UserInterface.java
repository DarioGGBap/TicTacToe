public class UserInterface {
    public void printBoard(Board board) {
        Field[] f = board.getFields();
        System.out.println("\n " + f[0] + " | " + f[1] + " | " + f[2]);
        System.out.println("-----------");
        System.out.println(" " + f[3] + " | " + f[4] + " | " + f[5]);
        System.out.println("-----------");
        System.out.println(" " + f[6] + " | " + f[7] + " | " + f[8] + "\n");
    }

    public void printMessage(String msg) { System.out.println(msg); }
}