package de.shepphard.blogspot.simon.game;


public class Timer {
	 
    private int finalTime;
    private int currentTime;
    private boolean timeOver;
    
    private int resetTime;

    public Timer(int timeInMillis){
          this.finalTime = 0;
          this.timeOver = false;
          this.currentTime = timeInMillis;
          this.resetTime = timeInMillis;
    }

    public void addTime(int timeInMillis){
          this.currentTime = this.currentTime - timeInMillis;
          if(currentTime <= finalTime){
                timeOver = true;
          }
    }
   
    public int getTime(){
    	return currentTime;
    }
    
    public boolean isTimeOver() {
          return timeOver;
    }
   
    public void reset(){
          this.timeOver = false;
          this.currentTime = this.resetTime;  
    }
}
