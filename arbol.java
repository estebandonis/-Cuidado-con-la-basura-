import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arbol extends Actor
{
    private int speed;
    
    public arbol(int v){
        speed = v;
    }
    /**
     * Act - do whatever the arbol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        if (getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.disminuir_num_arboles();
        }
    }
}
