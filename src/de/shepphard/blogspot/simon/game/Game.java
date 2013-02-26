// Wrapper Class for the Games Mechanics.

package de.shepphard.blogspot.simon.game;

public abstract class Game {
	private int numberOfGuesses;  // Number of Guesses
	private int numberOfSounds;   // Number of Sounds
	private int currentMax = 1;	  // Current maximum stage
	private int current = 0;	  // The current sound
	
	private boolean show = true;  // Is it time to show the new sequence?
	private boolean dead = false; // Have you died a tragic death?
	private boolean win = false;  // Have you been victorious?
	
	protected int[] soundArray;  // Array which contains the Sequence. Available throughout the package

	//General Constructor. Initialises the "difficulty" given by the length of the Sequence and the Number of Guesses
	protected Game(int numberOfGuesses, int numberOfSounds){
		this.numberOfGuesses = numberOfGuesses;
		this.numberOfSounds = numberOfSounds;
		this.soundArray = new int[numberOfSounds];
	}
	
	// Getter and Setter
	protected void setNumberOfGuesses(int numberOfGuesses){
		this.numberOfGuesses = numberOfGuesses;
	}
	
	protected int getNumberOfGuesses(){
		return this.numberOfGuesses;
	}
	
	protected void setNumberOfSounds(int numberOfSounds){
		this.numberOfSounds = numberOfSounds;
	}
	
	protected int getNumberOfSounds(){
		return this.numberOfSounds;
	}
	
	protected void setSoundArray(int index, int value){
		this.soundArray[index] = value;
	}
	
	protected void setCurrent(int current){
		this.current = current;
	}
	
	protected int getCurrent(){
		return this.current;
	}
	
	protected void setCurrentMax(int currentMax){
		this.currentMax = currentMax;
	}
	
	protected int getCurrentMax(){
		return this.currentMax;
	}
	
	protected void setShow(boolean show){
		this.show = show;
	}
	
	protected boolean getShow(){
		return this.show;
	}
	
	protected void setDead(boolean dead){
		this.dead = dead;
	}
	
	protected boolean getDead(){
		return this.dead;
	}
	
	protected void setWin(boolean win){
		this.win = win;
	}
	
	protected boolean getWin(){
		return this.win;
	}

	//This Method returns a given Element from the Sequencearray.
	protected int getCurrentItem(int index) {
		return soundArray[index];
	}
	
	public void finalize(){
		this.numberOfGuesses = 0;
		this.numberOfSounds = 0;
		this.soundArray = null;
	}
	
}
