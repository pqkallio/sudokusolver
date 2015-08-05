/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver.programlogic.controllers;

import sudokusolver.programlogic.domain.Grid;
import java.util.Scanner;

/**
 *
 * @author kallionpetri
 */
public class SolvingController {
    private final Grid GRID;
    
    public SolvingController(Grid grid) {
        this.GRID = grid;
    }
    
    public boolean grind() {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (!this.GRID.isSolved()) {
            System.out.println("Round " + i);
            GridSolvingController gsc = new GridSolvingController(this.GRID);
            gsc.grind();
            GRID.print();
            scanner.nextLine();
            i++;
            if (!gsc.progress()) return false;
        }
        
        return true;
    }
}
