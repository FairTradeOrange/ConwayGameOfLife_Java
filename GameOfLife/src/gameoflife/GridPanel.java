/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author reynevan
 */
public class GridPanel extends JPanel  {

    int width,height,rows,cols;
    int cell_height = 20;
    int cell_width = 20;
    Zelle[][] Zellen; 
    int generation;
   // int size = 30;
   // boolean[][] ZellenAmLeben = new boolean[size][size];
    boolean nextGen = true;
    
    
    

    public GridPanel(int width, int height, int cols, int rows){
        //setSize(900, 600);
        this.width = width; this.height = height; this.rows = rows ; this.cols = cols;
        Zellen = new Zelle[cols][rows];
        generation = 0;
      //  this.addMouseListener(this.mouse);
        
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                Zellen[i][j] = new Zelle(i,j);
                Zellen[i][j].grid = this;
                //Zellen[i][j].status = false;
                //this.test(Zellen[i][j]);
                
                
            }
        }
        
        /*
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                test(Zellen[i][j]);
            }
        } 
        
        
        
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                getNeighbors(Zellen[i][j]);
            }
        }  
       */
        
        
        Zellen[6][6].status = true;
        Zellen[6][5].status = true;
        Zellen[5][6].status = true;
        Zellen[4][6].status = true;
        Zellen[7][6].status = true;
     
        
        //Zellen[9][9].status = true;
        Zellen[12][12].status = true;
        Zellen[12][13].status = true;
        Zellen[13][12].status = true;
        Zellen[15][14].status = true;
        Zellen[14][15].status = true;
        Zellen[15][15].status = true;
        
        
    }
    
    public void paint(Graphics g){
        for ( int i = 0; i < cols+1 ; i++) g.drawLine(0, i*cell_height, width, i*cell_height);
        for ( int j = 0; j < rows+1 ; j++) g.drawLine(j*cell_width, 0, j*cell_width, height);
   
      //  g.setColor(Color.GREEN);
        
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                g.setColor(Color.GREEN);
                if(Zellen[i][j].IsAlive() == true) g.fillOval(i*cell_height, j*cell_width, 20, 20);
               // test(Zellen[i][j]);
                g.setColor(Color.GRAY);
                if(Zellen[i][j].IsAlive() == false) g.fillOval(i*cell_height, j*cell_width, 20, 20);
            }
        }
    
    
    }
    
    public void updateGraphics(){
        repaint();
    }
    
  /*  public void paintZellen(Graphics g, Zelle[][] Zellen){
        for (int i = 0 ; i < 30 ; i++){
            for ( int j = 0 ; j < 30 ; j++){
                if(Zellen[i][j].getIsAlive() == true) g.fillRect(i, j, 20, 20);
                
            }
        }
        
    } */
    
    public void testeRegeln(Zelle betrachtendeZelle){
        // I
        if(betrachtendeZelle.neighbors == 3 && betrachtendeZelle.IsAlive() == false){
            betrachtendeZelle.status = true;
        }
      
        // II
        if(betrachtendeZelle.neighbors < 2 && betrachtendeZelle.IsAlive() == true){
            betrachtendeZelle.status = false;
        }
        
        // III
        if(betrachtendeZelle.IsAlive() == true && betrachtendeZelle.neighbors == 2 || betrachtendeZelle.neighbors == 3 ){
            betrachtendeZelle.status = true;
        }
        
        // IIII
        if(betrachtendeZelle.neighbors > 3 && betrachtendeZelle.IsAlive() == true){
            betrachtendeZelle.status = false;
        }  
    }   
    
    public int getNeighbors(Zelle betrachtendeZelle){
       
        //test(betrachtendeZelle);
        
        int counter = 0;
        /*
        North = posy-1
        NE = posy-1 posx+1
        East = posx+1
        SE = posx+1 posy +1
        South = posy +1
        SW = posy+1, posx - 1
        West = posx-1
        NW = posx-1 posy-1
        */
       
        
        
        if(betrachtendeZelle.ZelleNord.IsAlive() == true) counter++;     //N
        if(betrachtendeZelle.ZelleNO.IsAlive() == true) counter++;   //NE
        if(betrachtendeZelle.ZelleOst.IsAlive() == true) counter++;     //E
        if(betrachtendeZelle.ZelleSO.IsAlive() == true)counter++;     //SE
        if(betrachtendeZelle.ZelleSued.IsAlive() == true) counter++;     //S
        if(betrachtendeZelle.ZelleSW.IsAlive() == true) counter++;     //SW
        if(betrachtendeZelle.ZelleWest.IsAlive() == true)counter++;     //W
        if(betrachtendeZelle.ZelleNW.IsAlive() == true) counter++;     //NW
        
        
        
    /*    try {
                //code related  something to array
         
                
                


        if(Zellen[betrachtendeZelle.posx][betrachtendeZelle.posy-1].status == true) counter++;     //N
        if(Zellen[betrachtendeZelle.posx+1][betrachtendeZelle.posy-1].status == true) counter++;   //NE
        if(Zellen[betrachtendeZelle.posx+1][betrachtendeZelle.posy].status == true) counter++;     //E
        if(Zellen[betrachtendeZelle.posx+1][betrachtendeZelle.posy+1].status == true) counter++;     //SE
        if(Zellen[betrachtendeZelle.posx][betrachtendeZelle.posy+1].status == true) counter++;     //S
        if(Zellen[betrachtendeZelle.posx-1][betrachtendeZelle.posy+1].status == true) counter++;     //SW
        if(Zellen[betrachtendeZelle.posx-1][betrachtendeZelle.posy].status == true) counter++;     //W
        if(Zellen[betrachtendeZelle.posx-1][betrachtendeZelle.posy-1].status == true) counter++;     //NW
        
         }
            catch(ArrayIndexOutOfBoundsException ignored) {

            } */
        //Zellen[posx][posy].neighbors = counter;
        return counter;
    }
    
    
    public void test(Zelle betrachtendeZelle){
    
    int[] ZelleWest = new int[2];   // colsX , rowsY 
    int[] ZelleOst = new int[2];
    int[] ZelleNord = new int[2];
    int[] ZelleSued = new int[2];
    int[] ZelleNW = new int[2];
    int[] ZelleSW = new int[2];
    int[] ZelleSO = new int[2];
    int[] ZelleNO = new int[2];
        
    
    try {
                //code related  something to array
           
    
        ZelleWest[0] = betrachtendeZelle.position[0] - 1 ;   ZelleWest[1] = betrachtendeZelle.position[1];
        if (ZelleWest[0] <= 0) ZelleWest[0] = getCols(); 
        betrachtendeZelle.ZelleWest = this.Zellen[ZelleWest[0]][ZelleWest[1]];
        
        ZelleOst[0] = betrachtendeZelle.position[0] + 1 ;   ZelleOst[1] = betrachtendeZelle.position[1];
        if (ZelleOst[0] >= getCols()) ZelleOst[0] = 0; 
        betrachtendeZelle.ZelleOst = this.Zellen[ZelleOst[0]][ZelleOst[1]];
        
        ZelleNord[0] = betrachtendeZelle.position[0] ;   ZelleNord[1] = betrachtendeZelle.position[1] - 1;
        if (ZelleNord[1] <= 0) ZelleNord[0] = getRows(); 
        betrachtendeZelle.ZelleNord = this.Zellen[ZelleNord[0]][ZelleNord[1]];
        
        ZelleSued[0] = betrachtendeZelle.position[0] ;   ZelleSued[1] = betrachtendeZelle.position[1] + 1;
        if (ZelleSued[0] >= getRows()) ZelleSued[0] = 0; 
        betrachtendeZelle.ZelleSued = this.Zellen[ZelleSued[0]][ZelleSued[1]];
        
        ZelleSW[0] = betrachtendeZelle.position[0] - 1 ;   ZelleSW[1] = betrachtendeZelle.position[1] + 1;
        if (ZelleSW[0] <= 0) ZelleSW[0] = getCols();
        if (ZelleSW[1] >= getRows()) ZelleSW[1] = 0;
        betrachtendeZelle.ZelleSW = this.Zellen[ZelleSW[0]][ZelleSW[1]];
        
        ZelleSO[0] = betrachtendeZelle.position[0] + 1 ;   ZelleSO[1] = betrachtendeZelle.position[1] + 1;
        if (ZelleSO[0] <= 0) ZelleSO[0] = getCols(); 
        if (ZelleSO[1] >= getRows()) ZelleSO[1] = 0;
        betrachtendeZelle.ZelleSO = this.Zellen[ZelleSO[0]][ZelleSO[0]];
        
        ZelleNO[0] = betrachtendeZelle.position[0] + 1 ;   ZelleNO[1] = betrachtendeZelle.position[1] - 1;
        if (ZelleNO[0] <= 0) ZelleNO[0] = getCols(); 
        if (ZelleNO[1] <= 0) ZelleNO[1] = getCols();
        betrachtendeZelle.ZelleNO = this.Zellen[ZelleNO[0]][ZelleNO[1]];
        
        ZelleNW[0] = betrachtendeZelle.position[0] - 1 ;   ZelleNW[1] = betrachtendeZelle.position[1] - 1;
        if (ZelleNW[0] <= 0) ZelleNW[0] = getCols(); 
        if (ZelleNW[1] <= 0) ZelleNW[1] = getCols();
        betrachtendeZelle.ZelleNW = this.Zellen[ZelleNW[0]][ZelleNW[1]];
   
    }
            catch(ArrayIndexOutOfBoundsException ignored) {

            }
    
    
    }  
        
        public int getRows(){
        return this.rows;
          }
        public int getCols(){
        return this.cols;
            }
        
        
        public int testNeighbors(int posx, int posy){
        int counter = 0;
        /*
        North = posy-1
        NE = posy-1 posx+1
        East = posx+1
        SE = posx+1 posy +1
        South = posy +1
        SW = posy+1, posx - 1
        West = posx-1
        NW = posx-1 posy-1
        */
        

        try {
                //code related  something to array
           


        if(Zellen[posx][posy-1].status == true) counter++;     //N
        if(Zellen[posx+1][posy-1].status == true) counter++;   //NE
        if(Zellen[posx+1][posy].status == true) counter++;     //E
        if(Zellen[posx+1][posy+1].status == true) counter++;     //SE
        if(Zellen[posx][posy+1].status == true) counter++;     //S
        if(Zellen[posx-1][posy+1].status == true) counter++;     //SW
        if(Zellen[posx-1][posy].status == true) counter++;     //W
        if(Zellen[posx-1][posy-1].status == true) counter++;     //NW
        
         }
            catch(ArrayIndexOutOfBoundsException ignored) {

            }
        //Zellen[posx][posy].neighbors = counter;
        return counter;
    }
        
   
        
}




