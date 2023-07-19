import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jack extends Actor
{
    private boolean firstTime = true;
    /**
     * Act - do whatever the Jack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private JackType jackType = JackType.Flow;
  
    
    public void act()
    {
        // Add your action code here.
        if(firstTime){
            turn(90);
            GreenfootImage image = getImage();  
            image.scale(100, 100);
            setImage(image);
            firstTime = false;
        }
        
        move(2);
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    public JackType getJackType(){
        return jackType;
    }
}
