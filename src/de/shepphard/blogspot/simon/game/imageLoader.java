package de.shepphard.blogspot.simon.game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class imageLoader {

	private boolean all;
	
	private Image image;
	private int numberOfColors;
	
	public imageLoader(int numberOfColors){
		this.all = false;
		this.numberOfColors = numberOfColors;
	}
	
	public void setAll(boolean all){
		this.all = all;
	}
	
	public Image showImage(int number) throws SlickException {
		image = new Image("data/img/"+number+".png");
		return image;
	}
	
	public Image showInImage() throws SlickException {
		if(this.all == true){
			image = new Image("data/img/all"+numberOfColors+".png");
		}
		return image;
	}
	
	public Image showOutImage() throws SlickException {
		if(this.all == true){
			image = new Image("data/img/all"+numberOfColors+"Out.png");
		}
		return image;
	}
	
	public Image showImage() throws SlickException, illegalImageException{
		if(this.all == true){
			image = new Image("data/img/all"+numberOfColors+".png");
		}else{
			throw new illegalImageException("Not all can be shown.");
		}
		return image;
	}
}
