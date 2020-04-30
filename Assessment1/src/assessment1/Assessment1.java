/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment1;

import javax.swing.*;


/**
 *
 * @author RyanHannam
 */
public class Assessment1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        solarWindow solar = new solarWindow(); //constructs a new calculator using the calculator() constructor
        solar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //creates a working exit button
        solar.setSize(600,450); //sets a default window size
        solar.setVisible(true); //lets the window be seen
    }
    
}
