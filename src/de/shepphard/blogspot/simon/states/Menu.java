package de.shepphard.blogspot.simon.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.main.GameStates;

public class Menu extends BasicGameState{
	private Music music;
	private Image background;
	private Image signOut;
	private Image signIn;
	
	private float angle = 0;
	private float x;
	private float y;
	
	public Menu() {
		super();
	}

	public void enter(GameContainer container, StateBasedGame state) throws SlickException {
		music = new Music("data/sound/menu.wav");
		music.loop();
		background = new Image("data/img/SimonMenu.png");
		signOut = new Image("data/img/signOut.png");
		signIn = new Image("data/img/signIn.png");
	}
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
	
	}

	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		Input input = container.getInput();
		
		float _delta = delta*1000F;
		
		if(input.isKeyPressed(Input.KEY_1)){
			state.enterState(GameStates.EasyState);
		}
		if(input.isKeyPressed(Input.KEY_2)){
			state.enterState(GameStates.MediumState);
		}
		if(input.isKeyPressed(Input.KEY_3)){
			state.enterState(GameStates.DifficultState);
		}
		if(input.isKeyPressed(Input.KEY_I)){
			state.enterState(GameStates.InstructionState);
		}
		if(input.isKeyPressed(Input.KEY_C)){
			state.enterState(GameStates.CreditState);
		}
		if(input.isKeyPressed(Input.KEY_Q)){
			container.exit();
		}
		
		signOut.rotate(-10/_delta);
		signIn.rotate(20/_delta);
		
		if(angle>-2*Math.PI)
			angle += (-10*Math.PI/180)/_delta;
		else
			angle = 0;
		
		x = (float) (130*Math.cos(angle));
		y = (float) (130*Math.sin(angle));
		
	}

	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		g.setColor(Color.white);
		background.draw();
		signOut.drawCentered(250, 250);
		signIn.drawCentered(250, 250);
		g.drawString("1 Easy", 220+x, 250+y);
		g.drawString("2 Normal", 220+y, 250-x);
		g.drawString("3 Hard", 220-x, 250-y);
		g.drawString("Q Quit", 220-y, 250+x);
		g.drawString("I Instructions", 30, 450);
		g.drawString("C Credits", 380, 450);
		
	}

	public void leave(GameContainer container, StateBasedGame state) throws SlickException {
		//music.stop();
		music.fade(1000, 0, true);
	}
	public int getID() {
		return GameStates.MenuState;
	}
}
