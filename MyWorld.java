import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private carro esteban;
    private contador score;
    private contador level;
    private arbol tree1;
    private arbol tree2;
    
    private int velocidad_carro;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private int num_rivales;
    private int num_arboles;
    
    public GreenfootSound sonidoMyWorld = new GreenfootSound("FutureBass.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 700, 1); 
        
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_carro = 2;
        
        score = new contador("Score: ");
        level = new contador("Level: ");
        level.add(1);
        esteban = new carro(velocidad_carro);
        tree1 = new arbol(velocidad_carro);
        tree2 = new arbol(velocidad_carro);
        
        int carril1 = getRandomNumber(50, 300);
        int carril2 = getRandomNumber(50, 300);
        num_arboles = 2;
        
        addObject(esteban, 325, 600);
        addObject(level, 320, 60);
        addObject(score, 145, 60);
        addObject(tree1, 17, carril1);
        addObject(tree2, 390, carril2);
        
        sonidoMyWorld.play();
    }
    
    public void act(){
        aumentar_dificultad();
        add_rivales();
        add_arboles();
    }
    
    public int getRandomNumber(int start,int end){
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public void aumentar_puntuacion(int valor){
        score.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void disminuir_num_rivales(){
        num_rivales--;
    }
    
    public void disminuir_num_arboles(){
        num_arboles--;
    }
    
    public void aumentar_dificultad(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 2;
            velocidad_carro++;
            level.add(1);
            esteban.aumenta_velocidad();
        }
    }
   
    public void add_rivales(){
        
        if(num_rivales == 0){
            
            int carril = getRandomNumber(0,4);
            
            if(carril == 0){
                addObject(new basura(velocidad_carro),80, 0);
            }
            else if(carril == 1){
                addObject(new basura(velocidad_carro),155, 0);
            }
            else if(carril == 2){
                addObject(new basura(velocidad_carro),245, 0);
            }
            else{
                addObject(new basura(velocidad_carro), 325,0);
            }
            carril++;
            carril = carril % 4;
            
            if(carril == 0){
                addObject(new basura(velocidad_carro),80, 0);
            }
            else if(carril == 1){
                addObject(new basura(velocidad_carro),155, 80);
            }
            else if(carril == 2){
                addObject(new basura(velocidad_carro),245, 80);
            }
            else{
                addObject(new basura(velocidad_carro), 325,0);
            }
            
            
            num_rivales = 2;
        }
    }
    
    public void add_arboles(){
        
        if(num_arboles == 0){
            
            int carril = getRandomNumber(0,1);
            
            if(carril == 0){
                addObject(new arbol(velocidad_carro),17, 0);
            }
            else{
                addObject(new arbol(velocidad_carro),390, 0);
            }
            
            if(carril == 1){
                addObject(new arbol(velocidad_carro),17, 0);
            }
            else {
                addObject(new arbol(velocidad_carro),390, 0);
            }
            
            num_arboles = 2;
        }
    }
}
