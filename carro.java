import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carro extends Actor
{
    private int speed;
    
    public carro(int v){
        speed = v;
    }
    
    /**
     * Act - do whatever the carro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("right")){
            if(getX() < 325)
                setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("left")){
            if(getX() > 75)
                setLocation(getX() - speed, getY());
        }
        if(Greenfoot.isKeyDown("up")){
            if(getY() > 80)
                setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("down")){
            if(getY() < 630)    
                setLocation(getX(), getY() + speed);
        }
        checkCollision();
    }
    
    public void checkCollision(){
        Actor collided = getOneIntersectingObject(basura.class);
        if(collided != null){
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    public void aumenta_velocidad(){
        speed++;
    }
}
