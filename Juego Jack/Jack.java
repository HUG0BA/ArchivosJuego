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
    private static Timer timer = new Timer(); // Instancia estática del Timer

    
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
        
        int moveDistance = 3;
        setLocation(getX(), getY() + moveDistance);
        
        if (isAtEdge()){
            getImage().setTransparency(0);
        }
    }

    
    //public void agregar_jack(int x, int y, int delayInSeconds) {
    //    final Jack currentJack = this; // Store reference to the current Jack object
    //    timer.schedule(new TimerTask() {
    //        @Override
    //        public void run() {
    //            if (!currentJack.isRemoved()) {
    //           getWorld().addObject(new Jack(), x, y);
    //        }}
    //    }, delayInSeconds * 1000);
    //}
    
    
    //private boolean isRemoved() {
    //    return getWorld() == null; // Verificar si el objeto Jack ha sido eliminado
    //}

    public JackType getJackType(){
        return jackType;

    }
    
    public static void resetContador() {
        cont = 0; // Reinicia el contador estático
    }
}

