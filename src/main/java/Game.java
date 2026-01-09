public class Game {
    private final Board board;
    private final UserInterface ui;
    private final ConsoleInput input;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.ui = new UserInterface();
        this.input = new ConsoleInput();
        this.player1 = new Player(Field.X);
        this.player2 = new Player(Field.O);
        this.currentPlayer = player1;
    }

    public void run() {
        ui.printMessage("Welcome to Tic-Tac-Toe!");
        ui.printMessage("Positions are numbered 1-9:");
        ui.printMessage(" 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ");

        boolean running = true;
        while (running) {
            draw();
            handleInput();
            running = update();
        }
        destroy();
    }

    private void draw() {
        ui.printBoard(board);
    }

    private void handleInput() {
        boolean valid = false;
        while (!valid) {
            ui.printMessage("Player " + currentPlayer.getSymbol() + ", enter position (1-9): ");
            int pos = input.getInt() - 1;
            if (pos < 0 || pos > 8) {
                ui.printMessage("Fehler: Nur Zahlen von 1 bis 9 sind erlaubt!");
            } else {
                valid = board.setField(pos, currentPlayer.getSymbol());
                if (!valid) {
                    ui.printMessage("Fehler: Dieses Feld ist bereits belegt!");
                }
            }
        }
    }

    private boolean update() {
        if (board.checkWin(currentPlayer.getSymbol())) {
            draw();
            ui.printMessage("Player " + currentPlayer.getSymbol() + " wins!");
            return false;
        }
        if (board.isFull()) {
            draw();
            ui.printMessage("It's a draw!");
            return false;
        }
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        return true;
    }

    private void destroy() {
        ui.printMessage("Game Over.");
    }
}