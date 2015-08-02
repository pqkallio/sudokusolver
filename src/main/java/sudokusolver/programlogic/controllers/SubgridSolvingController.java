/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver.programlogic.controllers;

import java.util.Collections;
import sudokusolver.utils.*;
import java.util.Set;
import java.util.TreeSet;
import sudokusolver.programlogic.domain.Grid;
import sudokusolver.programlogic.domain.Square;
import sudokusolver.programlogic.domain.Subgrid;

/**
 *
 * @author kallionpetri
 */
public class SubgridSolvingController {
    private Set<Integer> possibleNumbers;
    private final Grid GRID;
    private final Subgrid SUBGRID;
    
    public SubgridSolvingController(Grid grid, Subgrid subgrid) {
        this.GRID = grid;
        this.SUBGRID = subgrid;
        this.possibleNumbers = new TreeSet<>();
        Collections.addAll(this.possibleNumbers, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        this.possibleNumbers = SetOperations.relativeComplement(this.possibleNumbers, subgrid.getSolvedNumbers());
    }

    public boolean grind() {
        for (Square square : this.SUBGRID.getSolvedSquares(false)) {
            Set<Integer> unsolved = new TreeSet<>(this.possibleNumbers);
            unsolved = SetOperations.relativeComplement(unsolved, this.GRID.getNumbersFromASubgridRow(this.SUBGRID.getLocation().getX(), square.getLocation().getX()));
            unsolved = SetOperations.relativeComplement(unsolved, this.GRID.getNumbersFromASubgridCol(this.SUBGRID.getLocation().getY(), square.getLocation().getY()));
            if (unsolved.size() == 1) {
                square.setNumber((Integer)unsolved.toArray()[0]);
                return true;
            }
        }
        
        return false;
    }
}
