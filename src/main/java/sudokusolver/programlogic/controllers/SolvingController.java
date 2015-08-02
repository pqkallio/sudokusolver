/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver.programlogic.controllers;

import sudokusolver.programlogic.domain.Grid;

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
        while (!this.GRID.isSolved()) {
            GridSolvingController gsc = new GridSolvingController(this.GRID);
            gsc.grind();
            if (gsc.progress()) return false;
        }
        
        return true;
    }
}
