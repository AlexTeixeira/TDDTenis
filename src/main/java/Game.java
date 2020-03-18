import java.util.Collection;
import java.util.LinkedList;

public class Game {
    private Collection<GameSet> gameSetList;

    public Game(Player player1, Player player2) {
        gameSetList = new LinkedList<>();
        addNewGameSet(player1, player2);
    }

    private void addNewGameSet(Player player1, Player player2) {
        gameSetList.add(new GameSet(player1, player2));
    }

    public Collection<GameSet> getGameSetList() {
        return this.gameSetList;
    }


    public GameSet getCurrentGameSet() {
        GameSet lastElement = null;

        for (GameSet element : this.getGameSetList()) {
            lastElement = element;
        }

        return lastElement;
    }

    public void increasePointOfPlayer(Player player) {
        GameSet currentGameSet = getCurrentGameSet();

        currentGameSet.increasePointOfPlayer(player);

        if(getCurrentGameSet().getGameSetWinner() != null && getGameWinner() == null){
            addNewGameSet(new Player(currentGameSet.getPlayer1().getFullName()), new Player(currentGameSet.getPlayer2().getFullName()));
        }
    }

    public Player getGameWinner() {
        int player1NumberOfSetWin = 0;
        int player2NumberOfSetWin = 0;
        Player playerWhoWin = null;

        if(gameSetList.size() >= 2) {

            for (GameSet element : this.getGameSetList()) {
                if (element.getGameSetWinner() == element.getPlayer1()) {
                    player1NumberOfSetWin++;
                } else if(element.getGameSetWinner() == element.getPlayer2()){
                    player2NumberOfSetWin++;
                }
            }

            if (player2NumberOfSetWin > player1NumberOfSetWin) {
                playerWhoWin = getCurrentGameSet().getPlayer2();
            } else if(player1NumberOfSetWin > player2NumberOfSetWin){
                playerWhoWin = getCurrentGameSet().getPlayer1();
            }

        }

        return playerWhoWin;
    }
}
