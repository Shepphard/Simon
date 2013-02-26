package de.shepphard.blogspot.simon.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.main.GameStates;

public class WinState extends BasicGameState{
	
	private Image background;
	
	public WinState() {
		super();
	}

	public void enter(GameContainer container, StateBasedGame state) throws SlickException {

		background = new Image("data/img/WonBG.png");
	}
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
	
	}

	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ENTER)){
			state.enterState(GameStates.MenuState);
		}
	}

	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		background.draw();
		
	}

	public void leave(GameContainer container, StateBasedGame state) throws SlickException {
	
	}
	
	public int getID() {
		return GameStates.WinState;
	}
}
