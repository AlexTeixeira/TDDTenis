import java.util.ArrayList;
import java.util.List;

public class Player {
    private String fullName;
    private String point = "0";
    private int gamePoint = 0;
    private int tieBreakPoint = 0;
    private boolean onAdvantage = false;
    private final int INCREASE_POINT_VALUE = 1;
    private final int INITIAL_POINT_INDEX = 0;

    private final List<String> points = new ArrayList<String>(){{
        add("0");
        add("15");
        add("30");
        add("40");
    }};

    public Player(String fullName) {
        this.fullName = fullName;
    }

    public void increasePoint() {
        int currentIndex = points.indexOf(this.point) + INCREASE_POINT_VALUE;

        currentIndex = currentIndex > (points.size() - 1) ? INITIAL_POINT_INDEX : currentIndex;

        this.point = points.get(currentIndex);

        if(this.point.equals("0")){
            if(this.onAdvantage){
                this.toggleAdvantage();
            }
            increaseGamePoint();
        }
    }

    public int increaseGamePoint() {
        return this.gamePoint++;
    }

    public void increaseTieBreakPoint(){
        this.tieBreakPoint++;
    }

    public String getPoint() {
        String tempPoint = this.point;

        if(onAdvantage){
            tempPoint += "A";
        }
        return tempPoint;
    }

    public int getGamePoint() {
        return this.gamePoint;
    }

    public void toggleAdvantage() {
        this.onAdvantage = !this.onAdvantage;
    }

    public int getTieBreakPoint() {
        return this.tieBreakPoint;
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + fullName + '\'' +
                ", point='" + point + '\'' +
                ", gamePoint=" + gamePoint +
                ", tieBreakPoint=" + tieBreakPoint +
                ", onAdvantage=" + onAdvantage +
                ", INCREASE_POINT_VALUE=" + INCREASE_POINT_VALUE +
                ", INITIAL_POINT_INDEX=" + INITIAL_POINT_INDEX +
                ", points=" + points +
                '}';
    }
}
