package shreyk.snake.Entities;

import android.graphics.Color;

import shreyk.snake.Engine.Position;
import shreyk.snake.Framework.Graphics;

/**
 * Created by Shrey on 1/12/2016.
 */
public abstract class Entity {

    protected final static int DEFAULT_COLOR = Color.WHITE;
    protected final static int SIZE = 10;

    protected boolean mAlive;
    protected Position mPos;
    protected int mSize;
    protected int mColor;

    public Entity(Position pos, int size, int color) {
        mAlive = true;
        mPos = new Position(pos);
        mSize = size;
        mColor = color;
    }

    public abstract void update(float deltaTime);

    public abstract void draw(Graphics g);

    public boolean isAlive() {
        return mAlive;
    }

    public Position getPos() {
        return mPos;
    }

    public void setAlive(boolean alive) {
        mAlive = alive;
    }

    public void setPos(Position pos) {
        mPos = pos;
    }



}
