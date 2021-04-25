package tubes;

public class Coordinate {
    public Integer x;
    public Integer y;
    public Coordinate() {x = 0; y = 0;}
    public Coordinate(Integer a, Integer b) {x = a; y = b;}
    public void setCoordinate(Integer a, Integer b) {x = a; y = b;}
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}