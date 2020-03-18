import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Test
    public void GameTest_Init_ShouldHaveOneDefaultSetInSetList(){
        //act & arrange
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //assert
        Assert.assertEquals(1, game.getGameSetList().size());
    }

    @Test
    public void GameTest_OneSetWin_ShouldCreateNewSet(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);

        //assert
        Assert.assertEquals(2, game.getGameSetList().size());
        Assert.assertEquals(null, game.getCurrentGameSet().getGameSetWinner());
    }

    @Test
    public void GameTest_GetGameWinner_ShouldBePlayer1(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);

        //assert
        Assert.assertEquals(2, game.getGameSetList().size());
        Assert.assertEquals(game.getCurrentGameSet().getPlayer1(), game.getGameWinner());
    }

    @Test
    public void GameTest_GetGameWinner_ShouldBePlayer2(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);

        //assert
        Assert.assertEquals(2, game.getGameSetList().size());
        Assert.assertEquals(game.getCurrentGameSet().getPlayer2(), game.getGameWinner());
    }
    @Test
    public void GameTest_GetGameWinner_ShouldBeNoBody(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);

        //assert
        Assert.assertEquals(3, game.getGameSetList().size());
        Assert.assertEquals(null, game.getGameWinner());
    }

    @Test
    public void GameTest_GetGameWinner_With3Set_ShouldBePlayer1(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);

        //assert
        Assert.assertEquals(3, game.getGameSetList().size());
        Assert.assertEquals(game.getCurrentGameSet().getPlayer1(), game.getGameWinner());
    }

    @Test
    public void GameTest_GetGameWinner_With3Set_ShouldBePlayer2(){
        //act
        Game game = new Game(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //arrange
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer1(), 6);
        Helpers.playerWinXGamePoint(game, game.getCurrentGameSet().getPlayer2(), 6);

        //assert
        Assert.assertEquals(3, game.getGameSetList().size());
        Assert.assertEquals(game.getCurrentGameSet().getPlayer2(), game.getGameWinner());
    }
}
