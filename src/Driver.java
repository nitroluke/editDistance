
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nitroluke
 */
public class Driver {
    public static void main (String [] args) throws FileNotFoundException
    {
        EditDistance edit = new EditDistance("C://Users/nitroluke/Documents/NetBeansProjects/EditDistance/words.txt");
        edit.initialize();
       // edit.fillTable();
       // edit.solveProblems();
    }
}
