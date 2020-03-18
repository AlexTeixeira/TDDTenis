import org.junit.Assert;
import org.junit.Test;

public class GameSetTest {

    private GameSet gameSet;
    private final int FIFTEEN_POINT = 1;
    private final int THIRTY_POINT = 2;
    private final int FORTY_POINT = 3;
    @Test
    public void gameSet_Initialisation_AllShouldBeZero(){
        //arrange & Act
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //assert
        Assert.assertEquals("0", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(0, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1WinPoint_ShouldBe15(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), FIFTEEN_POINT);

        //assert
        Assert.assertEquals("15", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
    }

    @Test
    public void gameSet_Player1WinPoint_ShouldBe30(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), THIRTY_POINT);


        //assert
        Assert.assertEquals("30", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
    }

    @Test
    public void gameSet_Player1WinPoint_ShouldBe40(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), FORTY_POINT);

        //assert
        Assert.assertEquals("40", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
    }

    @Test
    public void gameSet_Player1WinPoint_GamePointShouldBe1AndPointReset(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), Helpers.WINNED_POINT);

        //assert
        Assert.assertEquals("0", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(1, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1WinPoint_GamePointShouldBe2AndPointReset(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), Helpers.WINNED_POINT);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), Helpers.WINNED_POINT);


        //assert
        Assert.assertEquals("0", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(2, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1_HaveAdvantage(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), FORTY_POINT);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), FORTY_POINT);

        gameSet.increasePointOfPlayer(gameSet.getPlayer1());

        //assert
        Assert.assertEquals("40A", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(0, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1_LoseAdvantage(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), FORTY_POINT);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), FORTY_POINT);

        gameSet.increasePointOfPlayer(gameSet.getPlayer1());
        gameSet.increasePointOfPlayer(gameSet.getPlayer2());

        //assert
        Assert.assertEquals("40", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(0, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1_WinPointAfterAdvantage(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), FORTY_POINT);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), FORTY_POINT);

        gameSet.increasePointOfPlayer(gameSet.getPlayer1());
        gameSet.increasePointOfPlayer(gameSet.getPlayer1());

        //assert
        Assert.assertEquals("0", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(1, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_Player1_WinPointIfOponnentAsNo40Points(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        gameSet.increasePointOfPlayer(gameSet.getPlayer2());
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), Helpers.WINNED_POINT);

        //assert
        Assert.assertEquals("0", gameSet.getPointOfPlayer(gameSet.getPlayer1()));
        Assert.assertEquals(1, gameSet.getPlayer1().getGamePoint());
    }


    @Test
    public void gameSet_NoPlayerAsWinASet(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //assert
        Assert.assertEquals(null, gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_Player1WinASet(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);

        //assert
        Assert.assertEquals(gameSet.getPlayer1(), gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_Player2WinASet(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);

        //assert
        Assert.assertEquals(gameSet.getPlayer2(), gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_IfOponnentHaveFivePoints_SoudHave7WinGamesToWinASet(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),5);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),7);

        //assert
        Assert.assertEquals(gameSet.getPlayer2(), gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_BothPlayerWin6Games_ShouldHaveNoWinner(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);

        //assert
        Assert.assertEquals(null, gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_BothPlayerWin6Games_BothWinOnePoint_ShouldHaveOneTieBreakPoint(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 1);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), 1);

        //assert
        Assert.assertEquals(1, gameSet.getPlayer1().getTieBreakPoint());
        Assert.assertEquals(1, gameSet.getPlayer2().getTieBreakPoint());
    }

    @Test
    public void gameSet_BothPlayerWin6Games_Player1WinGamePoint(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 7);

        //assert
        Assert.assertEquals(7, gameSet.getPlayer1().getGamePoint());
    }

    @Test
    public void gameSet_BothPlayerWin6Games_BothWin6TieBreak_NoGamePointBecauseNeedDifferenceOfTwoPoint(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), 6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 1);

        //assert
        Assert.assertEquals(6, gameSet.getPlayer1().getGamePoint());
        Assert.assertEquals(7, gameSet.getPlayer1().getTieBreakPoint());
        Assert.assertEquals(null, gameSet.getGameSetWinner());
    }

    @Test
    public void gameSet_BothPlayerWin6Games_BothWin6TieBreak_SetShouldBeWinByPlayer1(){
        //arrange
        gameSet = new GameSet(new Player("Gael Monfils"), new Player("Novak Djokovic"));

        //act
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer1(),6);
        Helpers.playerWinXGamePoint(gameSet, gameSet.getPlayer2(),6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer2(), 6);
        Helpers.playerWinXPoint(gameSet, gameSet.getPlayer1(), 2);

        //assert
        Assert.assertEquals(8, gameSet.getPlayer1().getTieBreakPoint());
        Assert.assertEquals(7, gameSet.getPlayer1().getGamePoint());
        Assert.assertEquals(gameSet.getPlayer1(), gameSet.getGameSetWinner());
    }


}

