package shreyk.snake;

import shreyk.snake.Framework.Game;
import shreyk.snake.Framework.Screen;

/**
 * Created by Shrey on 1/12/2016.
 */
public class SnakeGame extends Game {

    @Override
    public Screen getInitScreen(){
        return new GameScreen(this);
    }
}
