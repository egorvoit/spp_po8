package Task2;

public class Position {
    private float xPosition;
    private float yPosition;

    Position(float xPosition, float yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static double getDistanceBetweenPositions(Position loc1, Position loc2){
        return Math.sqrt(Math.pow(loc1.xPosition - loc2.xPosition, 2) + Math.pow(loc1.yPosition - loc2.yPosition, 2));
    }

    public double getDistanceToPosition(Position loc){
        return Math.sqrt(Math.pow(this.xPosition - loc.xPosition, 2) + Math.pow(this.yPosition - loc.yPosition, 2));
    }

    @Override
    public String toString() {
        return  "{xPosition= " + xPosition + ", yPosition= " + yPosition + "}";
    }
}
