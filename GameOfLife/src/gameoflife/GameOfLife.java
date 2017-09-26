/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





/**
 *
 * @author reynevan
 */
public class GameOfLife {

    public GameOfLife(){
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        // Quelle: Oracle
                JTextField colsX = new JTextField();
		JTextField rowsY = new JTextField();
                Object[] gridSize = {"GameGrid Größe X:", colsX , 
                                     "GameGrid Größe Y:", rowsY};
                JOptionPane pane = new JOptionPane( gridSize, JOptionPane.PLAIN_MESSAGE); 
                                               // JOptionPane.OK_CANCEL_OPTION);
                pane.createDialog(null, "Gridsize").setVisible(true);

        //        System.out.println("Eingabe: " + colsX.getText() + ", " + rowsY.getText());
        //        System.exit(0);
        //
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
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
            System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);
            game.Zellen[pxNeu][pyNeu-1].status = true;
            game.repaint();
            
            
          }

        @Override
        public void mousePressed(MouseEvent e) {
            int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
            System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);
      //      game.Zellen[pxNeu-1][pyNeu-1].status = true;
      //      game.Zellen[pxNeu-1][pyNeu+1].status = true;
      //      game.Zellen[pxNeu][pyNeu-1].status = true;
      //      game.Zellen[pxNeu-1][pyNeu].status = true;
            //game.Zellen[pxNeu][pyNeu-1].status = true;
      //      game.Zellen[pxNeu+1][pyNeu].status = true;
      //      game.Zellen[pxNeu][pyNeu+1].status = true;
      //      game.Zellen[pxNeu+1][pyNeu-1].status = true;
      //      game.Zellen[pxNeu-1][pyNeu-1].status = true;
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
      int test = 0;
      while(true){
      test++;
      System.out.println("TEST"+test);
          
       // TEST
       for (int i = 1 ; i < cols-1 ; i++){
           for ( int j = 1 ; j < rows-1 ; j++){
              game.Zellen[i][j].neighbors = game.testNeighbors(i,j);
             // game.test(game.Zellen[i][j]);
           //   game.Zellen[i][j].nachbarn = game.getNeighbors(Zellen[i][j]);
                
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
        //game.revalidate();
        //game.repaint();
        // game.testeRegeln(betrachtendeZelle);
        
        // count cells
        
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
           //System.out.println(counter);
       }
    }
    
  }
}
 
/*    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
 /*           System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);}

    @Override
    public void mousePressed(MouseEvent e) {
        int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
  /*          System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);}

    @Override
    public void mouseReleased(MouseEvent e) {
        int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
 /*           System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);}

    @Override
    public void mouseEntered(MouseEvent e) {
        int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
/*            System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);}

    @Override
    public void mouseExited(MouseEvent e) {
        int px = e.getX();
            int py = e.getY();
            /*Zellen life = new Life();
            px=life.row;
            py=life.column;
            life.gamefield[px][py]='1'; */
/*            System.out.println("X : "+px+
                               "  Y  : "+py);   
            
            int pxNeu = (px-(px%10))/20;
            int pyNeu = (py-(py%10))/20;
            System.out.println("X : "+pxNeu);
            System.out.println("Y : "+pyNeu);}
    
}

*/

/*if(Zellen[posx][posy-1].status == true) counter++;     //N
        if(Zellen[posx+1][posy-1].status == true) counter++;   //NE
        if(Zellen[posx+1][posy].status == true) counter++;     //E
        if(Zellen[posx+1][posy+1].status == true) counter++;     //SE
        if(Zellen[posx][posy+1].status == true) counter++;     //S
        if(Zellen[posx-1][posy+1].status == true) counter++;     //SW
        if(Zellen[posx-1][posy].status == true) counter++;     //W
        if(Zellen[posx-1][posy-1].status == true) counter++;     //NW
        


/*

//Erstellung Array vom Datentyp Object, Hinzufügen der Optionen		
		Object[] options = {"START", "STEP", "EXIT", "160*160", "320*320"};
                
           //     JFrame frameTest = new JFrame();
           //     frameTest.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                
          /*      JOptionPane test = new JOptionPane();
                test = new JOptionPane("Hello world",
                        JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.DEFAULT_OPTION, null,
                        new Object[]{}, null);  */
                
        /*        JFrame test = new JFrame();
                
                
                int selected =  JOptionPane.showOptionDialog(test,
                                                            "Wählen Sie aus:",
                                                            "Menü",
							    JOptionPane.DEFAULT_OPTION, 
                                                            JOptionPane.INFORMATION_MESSAGE,
							    null, options, options[0]);
                
                JOptionPane.setRootFrame(test);     */
                
                
           /*   final JDialog dialog = new JDialog();
                dialog.setTitle("Message");
                dialog.setModal(true);

                dialog.setContentPane(test);

                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                dialog.setVisible(true);        */
                

                
              //  test.set
               
                
                
               // int selected = 1;
	/*	System.out.println(selected);
                

                
                
                
                
                
                if(selected == 0) System.out.println("START");
                
                
                
                if(selected == 1) System.out.println("STEP");
                
                
                
                
                if(selected == 2) System.out.println("EXIT");       */








/// ONE STEP:
/*

        for (int i = 1 ; i < cols-1 ; i++){
           for ( int j = 1 ; j < rows-1 ; j++){
              game.testeRegeln(Zellen[i][j]); 
            }  
        }  

        for (int i = 1 ; i < cols-1 ; i++){
            for ( int j = 1 ; j < rows-1 ; j++){
               game.Zellen[i][j].neighbors = game.testNeighbors(i,j);
            }
        }  
       
           game.repaint();
           counter++;
           TimeUnit.SECONDS.sleep(1);
           System.out.println(counter);


*/
    