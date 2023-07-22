import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;

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
    private int cont = 0;
    
    public void act()
    {
        // Add your action code here.
        if(firstTime){
            //turn(90);
            GreenfootImage image = getImage();  
            image.scale(110, 110);
            setImage(image);
            firstTime = false;
        }
        
        int moveDistance = 2;
        setLocation(getX(), getY() + moveDistance);
        
        if (isAtEdge()){
        getWorld().removeObject(this);
        }
        
        cont++;
        if (cont==100){
            getWorld().addObject(new Jack(),100,100);
        }

    }


    public JackType getJackType(){
        return jackType;
    }
}
