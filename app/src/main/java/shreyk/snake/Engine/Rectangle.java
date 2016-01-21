package shreyk.snake.Engine;

/**
 * Created by Shrey on 1/12/2016.
 */
public class Rectangle {

    private float x;
    private float y;
    private float w;
    private float h;

    public Rectangle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.h = height;
        this.w = width;
    }

    public boolean collides(Rectangle rect) {
        float rx, ry, rw, rh;
        rx = rect.getX();
        ry = rect.getY();
        rw = rect.getW();
        rh = rect.getHeight();

        if (x >= rx && x <= rx + rw) {
            if (y >= ry && y <= ry + rh) {
                return true;
            }
        } else if (rx >= x && rx <= x + w) {
            if (ry >= y && ry <= y + h) {
                return true;
            }
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return h;
    }

    public float getW() {
        return w;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setHeight(float height) {
        this.h = height;
    }
}
