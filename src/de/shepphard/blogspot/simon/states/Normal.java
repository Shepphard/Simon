package de.shepphard.blogspot.simon.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.game.TheSimon;
import de.shepphard.blogspot.simon.game.illegalImageException;
import de.shepphard.blogspot.simon.main.GameStates;

public class Normal extends BasicGameState{

	private TheSimon simon;
	
	public Normal() {
		super();
	}
	
	public void enter(GameContainer container, StateBasedGame state) throws SlickException {
		simon = new TheSimon(5,20,7,"Player");
		simon.init(container);
		simon.setShowKeysfalse();
	}
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		
	}

	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		try {
			simon.update(container, delta, state);
		} catch (illegalImageException e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		simon.render(container, g);
		
	}
	
	public void leave(){
		simon.finalize();
	}

	public int getID() {
		return GameStates.MediumState;
	}
}
