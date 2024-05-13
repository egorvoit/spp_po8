class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean contains(Point point) {
        double x = point.getX();
        double y = point.getY();

        double topLeftX = topLeft.getX();
        double topLeftY = topLeft.getY();
        double bottomRightX = bottomRight.getX();
        double bottomRightY = bottomRight.getY();

        return x >= topLeftX && x <= bottomRightX && y >= topLeftY && y <= bottomRightY;
    }

    public double getTopLeftX() {
        return topLeft.getX();
    }

    public double getTopLeftY() {
        return topLeft.getY();
    }

    public double getBottomRightX() {
        return bottomRight.getX();
    }

    public double getBottomRightY() {
        return bottomRight.getY();
    }

}

