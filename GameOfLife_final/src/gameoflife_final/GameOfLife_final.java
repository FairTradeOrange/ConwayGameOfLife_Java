/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife_final;


import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author reynevan
 */

public class GameOfLife_final {

    public static void main(String[] args) throws InterruptedException {
                JTextField colsX = new JTextField();
		JTextField rowsY = new JTextField();
                Object[] gridSize = {"GameGrid Größe X:", colsX , 
                                     "GameGrid Größe Y:", rowsY};
                JOptionPane pane = new JOptionPane( gridSize, JOptionPane.PLAIN_MESSAGE); 
                pane.createDialog(null, "Gridsize").setVisible(true);
                int cols = Integer.parseInt(colsX.getText());
                int rows = Integer.parseInt(rowsY.getText());
                
       GridPanel game = new GridPanel(cols*20,rows*20, cols, rows);
       JFrame frame = new JFrame("TEST");
       frame.add(game);
       frame.setSize(cols*20+10, rows*20+30);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       MouseListener mouse = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            int px = e.getX();
            int py = e.getY();
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            game.Zellen[pxNeu][pyNeu-1].status = true;
            game.repaint();
          }
        @Override
        public void mousePressed(MouseEvent e) {
            int px = e.getX();
            int py = e.getY();
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            game.Zellen[pxNeu][pyNeu-1].status = false;
            game.repaint();
          }
        @Override
        public void mouseReleased(MouseEvent e) {
            
          }
        @Override
        public void mouseEntered(MouseEvent e) {
            game.nextGen = false;
          }
        @Override
        public void mouseExited(MouseEvent e) {
            game.nextGen = true;   
        }
       };
       frame.addMouseListener(mouse);
       
       JFrame info = new JFrame("Info");
       info.setSize(200, cols*20+20);
       info.setLocation(frame.getX()+cols*20+10, frame.getY());
       info.setVisible(true);
       info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       TextArea area = new TextArea();
       info.add(area);
       
       
       int AmountOfCells = 0;
       int counter = 0; 
       
       while(true){
        // TEST
       for (int i = 1 ; i < cols-1 ; i++){
           for ( int j = 1 ; j < rows-1 ; j++){
              game.Zellen[i][j].neighbors = game.testNeighbors(i,j);
            }  
        }   

        // GAMELOOP
       while( game.nextGen == true){
           
        for (int i = 1 ; i < cols-1 ; i++){
           for ( int j = 1 ; j < rows-1 ; j++){
              game.testeRegeln(game.Zellen[i][j]);
            }  
        }  
        
         //Turn :
           
        for (int i = 1 ; i < cols-1 ; i++){
            for ( int j = 1 ; j < rows-1 ; j++){
               game.Zellen[i][j].neighbors = game.testNeighbors(i,j);
            }
        }  
        
        for (int i = 1 ; i < cols-1 ; i++){
           for ( int j = 1 ; j < rows-1 ; j++){
              if( game.Zellen[i][j].IsAlive() == true) AmountOfCells++;
                
            }  
        }  
        
        
           /////////////////////////////
           area.append("Runde: "+Integer.toString(counter)+"\n");
           area.append("Anzahl Zellen: "+Integer.toString(AmountOfCells)+"\n");
           AmountOfCells = 0;
           game.repaint();
           counter++;
           TimeUnit.SECONDS.sleep(1);
       }
    }
    
  }
}
    