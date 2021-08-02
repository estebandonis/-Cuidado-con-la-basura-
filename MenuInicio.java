import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuInicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInicio extends World
{
    private GreenfootSound sonidoMenuInicio;
    /**
     * Constructor for objects of class MenuInicio.
     * 
     */
    public MenuInicio()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        LetrasInicio letras = new LetrasInicio();
        addObject(letras, 300, 200);
        
        sonidoMenuInicio = new GreenfootSound("Fluidity.mp3");
    }
    
    public void act()
    {
        sonidoMenuInicio.play();
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld());
            sonidoMenuInicio.stop();
        }
    }
}
