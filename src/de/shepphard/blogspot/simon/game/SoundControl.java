package de.shepphard.blogspot.simon.game;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundControl {

	private Sound[] sounds;
	private int numberOfColors;
	public SoundControl(int numberOfColors){
		sounds = new Sound[numberOfColors];
		this.numberOfColors = numberOfColors;
	}
	
	public void fill() throws SlickException {
		for(int i = 1; i <= numberOfColors; i++){
			sounds[i-1] = new Sound("data/sound/"+i+".wav");
		}
	}
	
	public Sound getSound(int number){
		return sounds[number];
	}
	
}
