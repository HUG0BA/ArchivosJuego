import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private String scoreText = "Puntuación: ";
    private int score = 0;
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage(scoreText + " " + score, 30, Color.GREEN, Color.BLACK));

        
    }
    
    public void addPoints(int points){
        score += points;
    }
    
    public void takePoints(int points){
        score -= points;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScoreText(String text){
        scoreText = text;
    }
    
    public String getScoreText(){
        return scoreText;
    }
}
