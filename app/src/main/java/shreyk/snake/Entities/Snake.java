package shreyk.snake.Entities;

import android.graphics.Color;

import shreyk.snake.Engine.Position;
import shreyk.snake.Engine.Rectangle;
import shreyk.snake.Framework.Game;
import shreyk.snake.Framework.Graphics;

/**
 * Created by Shrey on 1/12/2016.
 */
public class Snake extends Entity {

    private static final int snake_SIZE = 20;
    private static final int DEFAULT_PARTS = 5;
    private static final int DEFAULT_SPEED = 10;
    private static final int DEFAULT_COLOR = Color.GREEN;

    public enum Direction {UP, DOWN, LEFT, RIGHT}

    private Direction mDir;
    private Position mTarget;
    private int mSpeed;
    private int mParts;
    private Rectangle mRectangle;

    public Snake(Position pos) {
        super(pos, snake_SIZE, DEFAULT_COLOR);
        mDir = Direction.UP;
        mParts = DEFAULT_PARTS;
        mSpeed = DEFAULT_SPEED;

        updateTarget();
    }

    @Override
    public void update(float deltaTime) {
        float xDiff = mTarget.getX() * mSpeed * deltaTime;
        float yDiff = mTarget.getY() * mSpeed * deltaTime;
        mPos.update(xDiff, yDiff);

        checkBounds();
    }

    @Override
    public void draw(Graphics g) {
        int xOffset, yOffset;
        if (mDir == Direction.UP) {
            xOffset = 0;
            yOffset = mSize + 5;
        } else if (mDir == Direction.DOWN) {
            xOffset = 0;
            yOffset = -1 * mSize - 5;
        } else if (mDir == Direction.LEFT) {
            yOffset = 0;
            xOffset = -1 * mSize - 5;
        } else if (mDir == Direction.RIGHT) {
            yOffset = 0;
            xOffset = mSize + 5;
        } else {
            xOffset = 0;
            yOffset = 0;
        }
        for (int i = 0; i < mParts; i++) {
            g.drawRect(mPos.getX() + i * xOffset, mPos.getY() + i * yOffset, mSize, mSize, mColor);
        }
    }

    private void updateTarget() {
        if (mDir == Direction.UP) {
            mTarget.set(0, -1);
        } else if (mDir == Direction.DOWN) {
            mTarget.set(0, 1);
        } else if (mDir == Direction.LEFT) {
            mTarget.set(-1, 0);
        } else if (mDir == Direction.RIGHT) {
            mTarget.set(1, 0);
        }

    }

    public void updateDirection(Direction dir) {
        mDir = dir;
    }

    private void checkBounds(){
        if(mPos.x <= 0 || mPos.x >= Game.WIDTH){
            setAlive(false);
        } else if(mPos.y <= 0 || mPos.y >= Game.HEIGHT){
            setAlive(false);
        }
    }
}
