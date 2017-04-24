package domain;

public class Player {
    private String name;
    private Integer position;

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void play(Dice dice, Board board) {
        int roll = dice.roll();
        System.out.println("Player " + this.name + " roll = " + roll);
        if (this.position != null) {
            int newPosition = this.position + roll;
            if (newPosition <= Board.FINISHING_POINT) {
                this.position = board.positionOnBoard(newPosition);
            }
        } else if (roll == 1) {
            this.position = board.positionOnBoard(1);
        }
        if (this.position != null) {
            System.out.println("Player " + this.name + " Position = " + this.position);
        }
    }

    public boolean isWinner() {
        return Board.FINISHING_POINT.equals(this.position);
    }
}
