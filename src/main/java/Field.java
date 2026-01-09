public enum Field {
    EMPTY(" "), X("X"), O("O");

    private final String symbol;
    Field(String symbol) { this.symbol = symbol; }
    @Override public String toString() { return symbol; }
}