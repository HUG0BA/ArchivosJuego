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
    private static int cont = 0;
    
    private Timer timer  = new Timer();
    
    public void act()
    {
        // Add your action code here.
        if(firstTime){
            //turn(90);
            GreenfootImage image = getImage();  
            image.scale(110, 110);
            setImage(image);
            firstTime = false;

            
            timer.schedule(new AgregarJackTask(), 2000, 2000);

        }
        
        int moveDistance = 2;
        setLocation(getX(), getY() + moveDistance);
        
        if (isAtEdge()){
        getWorld().removeObject(this);
        }
    }

    
    
    private class AgregarJackTaskle extends TimerTask {
        @Override
        public void run() {
            agregar_jack(110, 50);
        }
    }
    
    public void agregar_jack(int x, int y){
        getWorld().addObject(new Jack(),x,y);
    }
    

    public JackType getJackType(){
        return jackType;
    }
    
    public static void resetContador() {
        cont = 0; // Reinicia el contador estático
    }
}

