/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.util.ArrayList;

/**
 *
 * @author reynevan
 */
 public class Zelle{
    int WIDTH = 20 ; int HEIGHT = 20 ;
    boolean status;     // false = tot - true = lebend
    int[] position = new int[2];    // TEST (int[0] = x ; int[1] = y )
    int posx,posy;
    int neighbors;
    int nachbarn;
    int generation;
    GridPanel grid;
    Zelle ZelleWest;
    Zelle ZelleOst;
    Zelle ZelleNord;
    Zelle ZelleSued;
    Zelle ZelleNW;
    Zelle ZelleNO;
    Zelle ZelleSW;
    Zelle ZelleSO;
    
    
    
           
    
  //  ArrayList<Zelle> Nachbarn = new ArrayList<Zelle>();
    
    
    
    public Zelle ( int posx, int posy){
        this.posx = posx;
        this.posy = posy;
        this.position[0] = posx; this.position[1] = posy;
        
        status = false;
        generation = 0;
        this.neighbors = 0 ;
        //neighbors = getNeighbors();
 
    }
    
        
    public int getRows(){
        return grid.rows;
    }
    public int getCols(){
        return grid.cols;
    }
    
    
  
    public void update(){
        
    }
       
    public boolean IsAlive(){
        return status;
    }
    
    public int[] getCoordinates(){
        int[] coordinates = new int[1];
        
        coordinates[0] = this.posx;
        coordinates[1] = this.posy;
        
        return coordinates;
    }
     
    /*public void setNachbar(Zelle Input_zelle){
        
        Nachbarn.add(Input_zelle);
        
        
        
    } */
    
   /* public int countNeighbors(){
        int counter = 0;
        
        //// COUNTER ZÄHLSCHLEIFE
        
        
        this.neighbors = counter;
        return neighbors;
    } */
    
    
    
    
    
    //TEST
    /*
    public Zelle[] getNachbarn(){

        return this.Nachbarn;
    }
    */
}
