public class AnalogThermometer {
    private double mercuryHeight;
    private final double lowerLimit;
    private final double upperLimit;
    private final double gradeScale;

    public AnalogThermometer(double lowerLimit, double upperLimit) {
        this.mercuryHeight = 0;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.gradeScale = 10;
    }

    public double getMercuryHeight() {
        return mercuryHeight;
    }

    public void setMercuryHeight(double mercuryHeight) {
        try {
            if (mercuryHeight < 0){
                throw new Exception("Вы замёрзли!");
            }
            else if (mercuryHeight > ((upperLimit - lowerLimit)*gradeScale)){
                this.mercuryHeight = (upperLimit - lowerLimit)*gradeScale;
                throw new Exception("Тише-тише, остынь, парень!");
            }
            else {
                this.mercuryHeight = mercuryHeight;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public double getGradeScale() {
        return gradeScale;
    }
}
