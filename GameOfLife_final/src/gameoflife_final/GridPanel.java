/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife_final;

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
    boolean nextGen = true; 

    public GridPanel(int width, int height, int cols, int rows){
        this.width = width; this.height = height; this.rows = rows ; this.cols = cols;
        Zellen = new Zelle[cols][rows];
        generation = 0;
        
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                Zellen[i][j] = new Zelle(i,j);
            }
        }
        
        //TEST
        Zellen[6][6].status = true;
        Zellen[6][5].status = true;
        Zellen[5][6].status = true;
        Zellen[4][6].status = true;
        Zellen[7][6].status = true;
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
   
        for (int i = 0 ; i < rows ; i++){
            for ( int j = 0 ; j < cols ; j++){
                g.setColor(Color.GREEN);    if(Zellen[i][j].IsAlive() == true) g.fillOval(i*cell_height, j*cell_width, 20, 20);
                g.setColor(Color.GRAY);     if(Zellen[i][j].IsAlive() == false) g.fillOval(i*cell_height, j*cell_width, 20, 20);
            }
        }
    }
    
    public void testeRegeln(Zelle betrachtendeZelle){
        if(betrachtendeZelle.neighbors == 3 && betrachtendeZelle.IsAlive() == false){       // I
            betrachtendeZelle.status = true;
        }   
        if(betrachtendeZelle.neighbors < 2 && betrachtendeZelle.IsAlive() == true){         // II
            betrachtendeZelle.status = false;
        }
        if(betrachtendeZelle.IsAlive() == true && betrachtendeZelle.neighbors == 2 || betrachtendeZelle.neighbors == 3 ){       // III
            betrachtendeZelle.status = true;
        }  
        if(betrachtendeZelle.neighbors > 3 && betrachtendeZelle.IsAlive() == true){         // IIII
            betrachtendeZelle.status = false;
        }  
    }   
        
    public int getRows(){return this.rows;}
    public int getCols(){return this.cols;}
        
    public int testNeighbors(int posx, int posy){
          int counter = 0;

          try {
           
              if(Zellen[posx][posy-1].status == true) counter++;     //N
              if(Zellen[posx+1][posy-1].status == true) counter++;   //NE
              if(Zellen[posx+1][posy].status == true) counter++;     //E
              if(Zellen[posx+1][posy+1].status == true) counter++;     //SE
              if(Zellen[posx][posy+1].status == true) counter++;     //S
              if(Zellen[posx-1][posy+1].status == true) counter++;     //SW
              if(Zellen[posx-1][posy].status == true) counter++;     //W
              if(Zellen[posx-1][posy-1].status == true) counter++;     //NW
        
              }
          catch(ArrayIndexOutOfBoundsException ignored) {}
        return counter;
    }
}




