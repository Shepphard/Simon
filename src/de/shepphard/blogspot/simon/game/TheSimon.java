package de.shepphard.blogspot.simon.game;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.shepphard.blogspot.simon.main.GameStates;

public class TheSimon extends Controls {

	private String name;
	
	private Timer timer;				// Timer during the Presentation of Sequence
	private Timer timer2;				// Timer for big red X
	
	private boolean shownEvt = false;	// Has the Event been shown
	private boolean first = true;
	private boolean showKeys = false;
	
	private Image img;					// img of the current part
	private Image img6;
	
	private Image transpImg;			// transparent image for background
	private Image transpImg6;			// Transparent image for backgroudn outside
	private Image background;			// Background image
	private Image error;				// Big red X
	private Image smallError;			// small red X
		
	private float angle = 0;
	private int countThis = 0;			// Counts through the sequence
	private int initNumOfGuesses;
	
	public TheSimon(int numberOfGuesses, int numberOfSounds, int numberOfColors, String name) {
		super(numberOfGuesses, numberOfSounds, numberOfColors);
		this.name = name;
		this.initNumOfGuesses = numberOfGuesses;
	}

	public String getName(){
		return this.name;
	}
	
	public void setShowKeysfalse(){
		showKeys = false;
	}
	
	public void init(GameContainer container) throws SlickException {
		
		super.init();
		
		//Create the Sequence for this round
		for(int i = 0; i < getNumberOfSounds(); i++){
			setSoundArray(i, (int) (Math.random()*getNumberOfColors()));
		}
		
		for(int i=0;i<soundArray.length;i++){
			System.out.println(getCurrentItem(i)); //debug
		}
		
		image = new imageLoader(getNumberOfColors());
		img = new Image("data/img/all"+getNumberOfColors()+".png");
		img6 = new Image("data/img/all"+getNumberOfColors()+"out.png");
		
		background = new Image("data/img/SimonBG.png");
		transpImg = new Image("data/img/all"+getNumberOfColors()+"Transp.png");
		transpImg6 = new Image("data/img/all"+getNumberOfColors()+"outTransp.png");
		
		timer = new Timer(800);
		timer2 = new Timer(500);
		
		error = new Image("data/img/nope.png");
		smallError = new Image("data/img/nopeSmall.png");
	}
	
	public void update(GameContainer container, int delta, StateBasedGame state) throws SlickException, illegalImageException {
		super.update(container, delta, state);
		
		Input input = container.getInput();
		
		timer.addTime(delta); // Add Time to the timer
		float _delta = delta*1000F;
		
		if(input.isKeyPressed(Input.KEY_SPACE)){
			showKeys = !showKeys;
			System.out.println("ShowKeys is "+showKeys); //debug
		}
		
		// Set the Win Variable
		if(getCurrentMax()-1 == getNumberOfSounds()){
			setWin(true);
		}
		
		// Gives a message that we won the Game!
		if(getWin()){
			state.enterState(GameStates.WinState);
			System.out.println("You won the Game!"); //debug
		}
		
		// Show the big red X
		if(getWrong()){
			timer2.addTime(delta);
			if(timer2.isTimeOver()){
				System.out.println("Time was over!"); // debug
				setWrong(false);
				timer2.reset();
			}
		}
		
		//Jumps you to the next State
		if(getNumberOfGuesses() == 0){
			setDead(true); // Not necessary anymore
			System.out.println("You lost!"); //debug
			state.enterState(GameStates.LostState);
		}
		
		
		// Show Elements
		if(timer.isTimeOver() && getShow() && shownEvt == false && !getWin()){
			if(first == true){
				first = false;
				timer.reset();
			}else{
				System.out.println("Current Item "+getCurrentItem(countThis)); //Debug
				if(getCurrentItem(countThis)<5){
					img = image.showImage(getCurrentItem(countThis));
					img6 = image.showImage(99);
				}else{
					img6 = image.showImage(getCurrentItem(countThis));
					img = image.showImage(99);
				}
				sounds.getSound(getCurrentItem(countThis)).play();
				countThis++;
				timer.reset();
				if(countThis == getCurrentMax()){
					shownEvt = true;
					countThis = 0;
				}
			}
		}

		// Continue Game when not won yet
		if(!getWin() && shownEvt == true && timer.isTimeOver()){
			System.out.println("In good"); //Debug
			image.setAll(true);
			img = image.showInImage();
			img6 = image.showOutImage();
			setShow(false);
			setControls(true);
			shownEvt = false;
			first = true;
		}
		
		transpImg.rotate(10/_delta);
		transpImg6.rotate(-5/_delta);
		img.setRotation(transpImg.getRotation());
		img6.setRotation(transpImg6.getRotation());
		
		if(angle>-2*Math.PI)
			angle += (10*Math.PI/180)/_delta;
		else
			angle = 0;
		
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.draw();
		transpImg.drawCentered(250,250);
		transpImg6.drawCentered(250, 250);
		
		
		
		//draw the next part of sequence
		img.drawCentered(250,250);
		img6.drawCentered(250, 250);
		
		//  If one entry has been wrong
		if(getWrong()){
			error.drawCentered(250,250);
		}
		
		g.setColor(Color.white);
		// Stagenumber
		g.drawString("Stage: "+getCurrentMax()+"/"+getNumberOfSounds(), 380, 470);
		
		g.setColor(Color.red);
		// Show number of wrong guesses
		for(int i=this.initNumOfGuesses;i>=getNumberOfGuesses();i--){
			smallError.draw(10, 465);
			g.drawString("x "+(-getNumberOfGuesses()+this.initNumOfGuesses+"/"+this.initNumOfGuesses), 45, 470);
		}
		
		g.setColor(Color.black);
		if(showKeys){
			if(getNumberOfColors() >= 4){
				//System.out.println("Should work?"); // debug
				g.drawString("W", (float) (245+120*Math.cos(angle-3*Math.PI/4)), (float) (245+120*Math.sin(angle-3*Math.PI/4)));
				g.drawString("A", (float) (245+120*Math.cos(angle-Math.PI/4)), (float) (245+120*Math.sin(angle-Math.PI/4)));
				g.drawString("D", (float) (245+120*Math.cos(angle+Math.PI/4)), (float) (245+120*Math.sin(angle+Math.PI/4)));
				g.drawString("Y", (float) (245+120*Math.cos(angle+3*Math.PI/4)), (float) (245+120*Math.sin(angle+3*Math.PI/4)));
			}
			if(getNumberOfColors() >= 7){
				//System.out.println("Should work?"); // debug
				g.drawString("S", 245, 245);
				g.drawString("<", (float) (245+190*Math.cos(-angle/2-Math.PI)), (float) (245+190*Math.sin(-angle/2-Math.PI)));
				g.drawString(">", (float) (245+190*Math.cos(-angle/2)), (float) (245+190*Math.sin(-angle/2)));
			}
			if(getNumberOfColors() >= 9){
				//System.out.println("Should work?"); // debug
				g.drawString("^", (float) (245+190*Math.cos(-angle/2-Math.PI/2)), (float) (245+190*Math.sin(-angle/2-Math.PI/2)));
				g.drawString("v", (float) (245+190*Math.cos(-angle/2+Math.PI/2)), (float) (245+190*Math.sin(-angle/2+Math.PI/2)));
			}
		}
		
	}
	
	public void finalize(){
		super.finalize();
	}

}
