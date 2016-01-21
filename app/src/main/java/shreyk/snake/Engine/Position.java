package shreyk.snake.Engine;

import shreyk.snake.Framework.Game;

/**
 * Created by Shrey on 1/12/2016.
 */
public class Position {
    public float x;
    public float y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public void set(Position pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public int getX() {
        return Math.round(x);
    }

    public int getY() {
        return Math.round(y);
    }

    public boolean isInScreen(Position pos) {
        return isWithin(pos.x, 0, Game.WIDTH) && isWithin(pos.y, 0, Game.HEIGHT);
    }

    public boolean isWithin(float pos, int start, int end) {
        return (pos >= start && pos <= end);
    }

    /**
     * Overriding equals method so as to make sure both x and y co ordinates are equal.
     * Currently only checks with other position objects
     *
     * @param o
     * @return boolean equals value
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position p = (Position) o;
            if (p.getX() == getX() && p.getY() == getY()) {
                return true;
            }
        }
        return false;
    }

    public void print(String name) {
        System.out.println(name + ": " + x + ", " + y);
    }
}
