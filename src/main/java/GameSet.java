public class GameSet {
    private Player player1;
    private Player player2;

    private final int BASE_WIN_POINT = 6;
    private final int BASE_WIN_TIEBREAK = 7;
    private final int DIFF_TO_WIN_TIEBREAK_OR_SET = 2;

    public GameSet(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void increasePointOfPlayer(Player player) {
        Player opponent = getOpponent(player);

        if(opponent.getGamePoint() == BASE_WIN_POINT && player.getGamePoint() == BASE_WIN_POINT) {
            player.increaseTieBreakPoint();

            if(opponent.getTieBreakPoint() >= (BASE_WIN_TIEBREAK-1) && player.getTieBreakPoint() >= (BASE_WIN_TIEBREAK-1)
                    && (player.getTieBreakPoint() - opponent.getTieBreakPoint()) == DIFF_TO_WIN_TIEBREAK_OR_SET){
                player.increaseGamePoint();
            } else if(player.getTieBreakPoint() == BASE_WIN_TIEBREAK && opponent.getTieBreakPoint() < (BASE_WIN_TIEBREAK-1)){
                player.increaseGamePoint();
            }
        } else{
            if (opponent.getPoint().contains("40") && player.getPoint().equals("40")) {
                player.toggleAdvantage();

                if (opponent.getPoint().equals("40A")) {
                    opponent.toggleAdvantage();
                }
            } else {
                player.increasePoint();
            }
        }
    }

    private Player getOpponent(Player player) {
        Player opponent = null;

        if(player.equals(player1)){
            opponent = player2;
        } else{
            opponent = player1;
        }
        return opponent;
    }

    public String getPointOfPlayer(Player player) {
        return player.getPoint();
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public Player getGameSetWinner() {
        Player winner = null;

        //si on a plus de 10 point dans un SET alors il faut 7-5 pour qu'un joueur gagne
        if(player1.getGamePoint() + player2.getGamePoint() >= (BASE_WIN_POINT - 1) *2){
            if(player1.getGamePoint() >= BASE_WIN_POINT && player2.getGamePoint() >= BASE_WIN_POINT){
                winner = getWinnerBaseOnDifference();
            } else {
                winner = getWinnerBaseOnPoints(BASE_WIN_POINT + 1);
            }
        } else {
            winner = getWinnerBaseOnPoints(BASE_WIN_POINT);
        }

        return winner;
    }

    private Player getWinnerBaseOnDifference() {
        Player winner = null;
        int diffToWin = player1.getTieBreakPoint() > 0 ? DIFF_TO_WIN_TIEBREAK_OR_SET-1 : DIFF_TO_WIN_TIEBREAK_OR_SET;

        int pointDifference = player1.getGamePoint() - player2.getGamePoint();

        if(pointDifference == diffToWin){
            winner = player1;
        } else if(pointDifference == -diffToWin){
            winner = player2;
        }

        return winner;
    }

    private Player getWinnerBaseOnPoints(int points){
        Player winner = null;

        if (player1.getGamePoint() == points) {
            winner = player1;
        } else if (player2.getGamePoint() == points) {
            winner = player2;
        }

        return winner;
    }
}
