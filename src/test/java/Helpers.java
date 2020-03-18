public class Helpers {
    public static final int WINNED_POINT = 4;

    public static void playerWinXPoint(GameSet gameSet, Player player, int numberOfWinPoints){

        for (int i = 0; i < numberOfWinPoints; i++) {
            gameSet.increasePointOfPlayer(player);
        }
    }

    public static void playerWinXGamePoint(GameSet gameSet, Player player, int numberOfWinGamePoints){
        for (int i = 0; i < numberOfWinGamePoints; i++) {
            playerWinXPoint(gameSet, player, WINNED_POINT);
        }
    }

    public static void playerWinXPoint(Game game, Player player, int numberOfWinPoints){

        for (int i = 0; i < numberOfWinPoints; i++) {
            game.increasePointOfPlayer(player);
        }
    }

    public static void playerWinXGamePoint(Game game, Player player, int numberOfWinPoints){

        for (int i = 0; i < numberOfWinPoints; i++) {
            playerWinXPoint(game, player, WINNED_POINT);
        }
    }

}
