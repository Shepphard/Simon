// Class containing the Controls

package de.shepphard.blogspot.simon.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

// Class is abstract. No instance can be created of this Class
public abstract class Controls extends Game{

	protected SoundControl sounds;
	
	private boolean freeControls = false; // Can you use the controls or are you blocked for the moment?
	private boolean wrong;
	
	protected imageLoader image;
	
	private int numberOfColors;
	
	// General Constructor. No additional variables added
	protected Controls(int numberOfGuesses, int numberOfSounds, int numberOfColors) {
		super(numberOfGuesses, numberOfSounds);
		this.numberOfColors = numberOfColors;
	}
	
	// Getter and Setter for freeControls
	protected void setControls(boolean controls){
		this.freeControls = controls;
		System.out.println("Controls are "+getControls());
	}
	
	protected boolean getControls(){
		return this.freeControls;
	}
	
	protected int getNumberOfColors(){
		return this.numberOfColors;
	}
	
	protected void setWrong(boolean set){
		wrong = set;
		if(set == false)
			setControls(true);
		else
			setControls(false);
	}
	
	protected boolean getWrong(){
		return wrong;
	}
	
	// Unlock the next part of the Sequence
	private void nextStage(){
		if(getCurrent() == getCurrentMax()){  // if the current position in the array is the maximal position
			setCurrentMax(getCurrentMax()+1); // make the maximal position +1
			setCurrent(0);					  // reset current
			setControls(false);				  // Controls are disabled
			setShow(true);					  // The Sequence plus the new element is shown
			image.setAll(false);			  // Don't show the full 100% Opacity Game Element
			System.out.println("Controls are "+getControls()); //debug
		}
	}

	protected void init() throws SlickException{
		sounds = new SoundControl(getNumberOfColors());
		sounds.fill();
	}
	private void goodKey(Input input, int key, int current){
		if(input.isKeyPressed(key)){
			setCurrent(getCurrent()+1);
			sounds.getSound(current).play();
			nextStage();
		}
	}
	private void badKey(Input input, int key, int inwhich){
		if(this.numberOfColors>=inwhich){
			if(input.isKeyPressed(key)){
				System.out.println("Lost 1 life");//debug
				setWrong(true);
				setCurrent(0);
				setNumberOfGuesses(getNumberOfGuesses()-1);
			}
		}
	}
	// Update Method
	protected void update(GameContainer container, int delta, StateBasedGame state) throws SlickException, illegalImageException{
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		if(getControls() && !getDead()){
			if(getCurrentItem(getCurrent()) == 0){
				goodKey(input, Input.KEY_W,0);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_S, 7);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
			}
			if(getCurrentItem(getCurrent()) == 1){
				goodKey(input, Input.KEY_A,1);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_S, 7);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
				
			}
			if(getCurrentItem(getCurrent()) == 2){
				goodKey(input, Input.KEY_Y,2);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_S, 7);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
			}
			if(getCurrentItem(getCurrent()) == 3){
				goodKey(input, Input.KEY_D,3);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_S, 7);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
			}
			
			// For when 7 items
			if(getCurrentItem(getCurrent()) == 4){
				goodKey(input, Input.KEY_S,4);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
			}
			
			if(getCurrentItem(getCurrent()) == 5){
				goodKey(input, Input.KEY_LEFT,5);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_S, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_RIGHT, 7);
			}
			
			if(getCurrentItem(getCurrent()) == 6){
				goodKey(input, Input.KEY_RIGHT,6);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_S, 7);
				
			}
			//for when 9 items
			
			if(getCurrentItem(getCurrent()) == 7){
				goodKey(input, Input.KEY_DOWN,7);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_UP, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_RIGHT, 7);
				badKey(input, Input.KEY_S, 7);
				
			}
			
			if(getCurrentItem(getCurrent()) == 8){
				goodKey(input, Input.KEY_UP,8);
				badKey(input, Input.KEY_A, 4);
				badKey(input, Input.KEY_Y, 4);
				badKey(input, Input.KEY_D, 4);
				badKey(input, Input.KEY_W, 4);
				badKey(input, Input.KEY_DOWN, 9);
				badKey(input, Input.KEY_LEFT, 7);
				badKey(input, Input.KEY_RIGHT, 7);
				badKey(input, Input.KEY_S, 7);
				
			}
		}
	}
	
	public void finalize(){
		super.finalize();
	}
}
