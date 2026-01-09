public class Board {
    private final Field[] fields = new Field[9];

    public Board() {
        for (int i = 0; i < 9; i++) fields[i] = Field.EMPTY;
    }

    public boolean setField(int index, Field symbol) {
        if (index < 0 || index > 8 || fields[index] != Field.EMPTY) return false;
        fields[index] = symbol;
        return true;
    }

    public Field[] getFields() { return fields; }

    public boolean checkWin(Field s) {
        int[][] wins = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        for (int[] w : wins) {
            if (fields[w[0]] == s && fields[w[1]] == s && fields[w[2]] == s) return true;
        }
        return false;
    }

    public boolean isFull() {
        for (Field f : fields) if (f == Field.EMPTY) return false;
        return true;
    }
}