package de.shepphard.blogspot.simon.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.main.GameStates;

public class Instructions extends BasicGameState{
	private Music music;
	private Image background;
	
	public Instructions() {
		super();
	}

	public void enter(GameContainer container, StateBasedGame state) throws SlickException {
		music = new Music("data/sound/menu.wav");
		//music.loop();

		background = new Image("data/img/SimonInstructions.png");
	}
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
	
	}

	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_BACK)){
			state.enterState(GameStates.MenuState);
		}
	}

	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		background.draw();
		
	}

	public void leave(GameContainer container, StateBasedGame state) throws SlickException {
		music.stop();
	}
	public int getID() {
		return GameStates.InstructionState;
	}
}
