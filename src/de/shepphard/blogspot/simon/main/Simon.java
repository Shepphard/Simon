package de.shepphard.blogspot.simon.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.states.*;

public class Simon extends StateBasedGame{
	
	public Simon(String title) {
		super(title);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Menu());
		addState(new Credits());
		addState(new Easy());
		addState(new Normal());
		addState(new Hard());
		addState(new Instructions());
		addState(new WinState());
		addState(new LostState());
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Simon("Simon 1.0"));
		app.setDisplayMode(500, 500, false);
		app.setShowFPS(false);
	    app.start();
	}
}