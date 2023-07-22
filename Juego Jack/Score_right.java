import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score_right extends Actor
{
    

    private String scoreKey = "right"; //Nombre de la tecla que se debe presionar 
    private Fondo fondo; //Nombre del mundo utilizando para obtener acceso a contador
    private JackType jackType = JackType.Flow;
    
    private int basePoint = 1;
    private int comboMultiplier = 1;
    private int comboCount = 1;
    private boolean isComboStreak = false;
         
    protected void addedToWorld(World world) {
        // Rotar la imagen en 180 grados una vez al añadir el objeto al mundo
        int initialRotation = 180;
        setRotation(initialRotation);
    }
    
    /**
     * Act - do whatever the ScoreArea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown(scoreKey)){
            CheckInput();
        }
        
    }
    
    public void CheckInput(){
        Jack jack;
        jack = (Jack)getOneIntersectingObject(Jack.class);
        
        if (jack != null){
           if(jack.getJackType() == jackType){
            int points = CalculatePoints();
            AddPoints(points);
            getWorld().removeObject(jack);
            } 
        }
        
        
        
    }  
    
    public void AddPoints(int amount){
        fondo = (Fondo) getWorld();
        Counter counter = fondo.getCounter();
        counter.addPoints(amount);
    }
    
    public int CalculatePoints(){
        int points = basePoint * comboMultiplier;
        return points;
    }
    

}


