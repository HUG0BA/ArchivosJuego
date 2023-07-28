import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    private int arrayColumnas[] = new int[]{100,225,365,485};
    private int totalColumnas = 4;
    private static Timer songTimer = new Timer();
    private int bpm = 140;
    private int songDuration = 106;
    private double baseMultiplier = 0.25;
    
    private boolean firstTime = true;
    private int actualPhase = 1;
    private int phasePauseSeconds = 1;
    
    private GreenfootImage sprite;
    private String spriteNames[] = new String[]{"matrix_jack.png", "ilusion_jack.png", "shine_jack.png","brave_jack.png", "nebula_jack.png", "fire_jack"}; 
    
    private static Timer timerPhase1 = new Timer();
    private static Timer timerPhase2 = new Timer();
    private static Timer timerPhase3 = new Timer();
    private static Timer timerPhase4 = new Timer();
    private static Timer timerPhase5 = new Timer();
    private static Timer timerPhase6 = new Timer();
    private static Timer timerPhase7 = new Timer();
    private static Timer timerPhase8 = new Timer();
    
    
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        
        if(firstTime){
            int songInterval = calculateSongInterval(songDuration);
            songPhaseTimer(songInterval);
        }
        firstTime = false;
    }
    
    
    public void spawnJack(int x, int y) 
    {
        Jack jack = new Jack();
        
        getWorld().addObject(new Jack(), x, y);
    }
    
    public void spawnJack(int x, int y, String spriteName) 
    {
        sprite = new GreenfootImage(spriteName);
        Jack jack = new Jack();
        jack.setImage(sprite);
        
        getWorld().addObject(jack, x, y);
    }
    
    public ArrayList<Integer> getRandomColumnas(int cantidadColumnas)
    {
        //int resta = new Random().nextInt(2);
        //int cantidadFinal = cantidadColumnas - resta;
        ArrayList<Integer> columnas = new ArrayList<>();
        
        for(int i = 1; i <= cantidadColumnas; i++){
            int randomIndex = new Random().nextInt(totalColumnas);
            int randomNumber = arrayColumnas[randomIndex];
            columnas.add(randomNumber);
        }
        
        return columnas;
    }
    
    public void spawnJackRandom(int cantidadColumnas){
        
        ArrayList<Integer> random = getRandomColumnas(cantidadColumnas);
            for (int i = 0; i < random.size(); i++){
                spawnJack(random.get(i), 100);
                
            }
    }
    
    public void spawnJackRandom(int cantidadColumnas, String spriteName){
        
        ArrayList<Integer> random = getRandomColumnas(cantidadColumnas);
            for (int i = 0; i < random.size(); i++){
                spawnJack(random.get(i), 100, spriteName);
                
            }
    }
    
    public void spawnJackInColumn(int columna){
        if (columna == 1){
            spawnJack(100, 100);
        }
        else if (columna == 2){
            spawnJack(225, 100);
        }
        else if (columna == 3){
            spawnJack(365, 100);
        }
        else if (columna == 4){
            spawnJack(485, 100);
        }
        
    }
    
    
    public void randomJackTimer(long delayFinal ){
        TimerTask task = new TimerTask(){
            public void run(){
                spawnJackRandom(1);
            }
        };
        
        //int delay = delayFinal * 1000;
        
        //jackTimer.scheduleAtFixedRate(task, delayFinal, delayFinal);
    }
    
    public void songPhaseTimer(int phaseDuration){
        TimerTask task = new TimerTask(){
            public void run(){
                
                long delayFinal = caculateBPMDelay(bpm, baseMultiplier);
                
                //System.out.println("Delay final:" + delayFinal);
                
                if (actualPhase == 1){
                    baseMultiplier = baseMultiplier * 2;
                    
                    timerPhase1.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(1);
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                }
                else if (actualPhase == 2){
                    baseMultiplier = baseMultiplier * 2;
                    timerPhase2.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(2, "matrix_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase1.cancel();
                    timerPhase1.purge();
                }
                else if (actualPhase == 3){
                    
                    timerPhase3.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(2, "shine_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase2.cancel();
                    timerPhase2.purge();
                }
                else if (actualPhase == 4){
                    baseMultiplier = baseMultiplier * 2;
                    timerPhase4.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(2, "ilusion_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase3.cancel();
                    timerPhase3.purge();
                }
                else if (actualPhase == 5){
                    baseMultiplier = baseMultiplier * 2;
                    
                    timerPhase5.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(1, "brave_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase4.cancel();
                    timerPhase4.purge();
                }
                else if (actualPhase == 6){
                    
                    timerPhase6.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(1, "nebula_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase5.cancel();
                    timerPhase5.purge();
                }
                else if (actualPhase == 7){
                    baseMultiplier = baseMultiplier * 2;
                    timerPhase7.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(2, "negative_jack.png");
                        }
                    }, delayFinal, delayFinal);
                    randomJackTimer(delayFinal);
                    
                    timerPhase6.cancel();
                    timerPhase6.purge();
                }
                else if (actualPhase == 8){
                    //String spriteName = selectedRandomSprite();
                    timerPhase8.scheduleAtFixedRate(new TimerTask() { 
                        public void run() {
                            spawnJackRandom(1, "fire_jack.png");
                        }
                    }, delayFinal, delayFinal );
                    randomJackTimer(delayFinal);
                    
                    timerPhase7.cancel();
                    timerPhase7.purge();
                }else if (actualPhase == 9){
                    timerPhase8.cancel();
                    timerPhase8.purge();
                    
                }
                
                actualPhase = actualPhase + 1;
            }
        };
        
        songTimer.scheduleAtFixedRate(task, phasePauseSeconds * 1000, phaseDuration);
    }
    
    public long caculateBPMDelay(int bpm, double tempoMultiplier){
        double tempoFinal = bpm * tempoMultiplier;
        double delayMiliSeconds = (60.0 / (double) tempoFinal) * 1000.0;
        double delayFinal = delayMiliSeconds;
        return (long)delayFinal;
    }
    
    public int calculateSongInterval(int songDuration){
        double songInterval = ((double) songDuration / (double) 8) * 1000.0; 
        return (int) songInterval;
    }
    
    public String selectedRandomSprite(){
        int randomIndex = new Random().nextInt(6);
        String spriteName = spriteNames[randomIndex];
        return spriteName;
    }
        
}
