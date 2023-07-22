import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fondo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fondo extends World
{

    /**
     * Constructor for objects of class Fondo.
     * 
     */
    Counter counter = new Counter();
    private GreenfootSound backgroundMusic;
    
    
    public Fondo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(610,610, 1);
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private void prepare()
    {
        //backgroundMusic = new GreenfootSound("../sonido/song.mp3");
        
        Score_down score_down = new Score_down();
        addObject(score_down,2,466);
        score_down.setLocation(365,485);

        Score_up score_up = new Score_up();
        addObject(score_up,229,474);
        score_up.setLocation(225,455);

        Score_left score_left = new Score_left();
        addObject(score_left,101,465);
        score_left.setLocation(100,468);

        Score_right score_right = new Score_right();
        addObject(score_right,458,479);
        score_right.setLocation(485,455);
        
        
        addObject(counter,71,66);
        counter.setLocation(87,36);
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public void act() {
    if (!backgroundMusic.isPlaying()) {
        backgroundMusic.play();
    }
}

    
}