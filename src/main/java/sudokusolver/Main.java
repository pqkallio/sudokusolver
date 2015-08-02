package sudokusolver;

import java.util.List;
import sudokusolver.programlogic.controllers.SolvingController;
import sudokusolver.programlogic.domain.Grid;
import sudokusolver.programlogic.domain.Square;
import sudokusolver.programlogic.domain.Subgrid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallionpetri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {-1, -1, -1,  3,  5, -1, -1,  2,  7,
                          5,  8, -1,  2, -1,  6,  1, -1, -1,
                          3, -1, -1,  7,  8,  9,  5, -1, -1,
                         -1, -1, -1, -1, -1, -1, -1, -1, -1,
                         -1,  9, -1, -1, -1, -1, -1, -1, -1,
                         -1, -1, -1, -1, -1, -1,  2,  6,  7,
                         -1, -1,  6,  9,  1, -1,  2,  7,  3,
                         -1,  7, -1,  3,  6, -1,  9, -1, -1,
                         -1, -1, -1,  8, -1,  5, -1,  1, -1};
        
        Grid grid = new Grid(numbers);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Square> squares = grid.getSquaresFromASubgridRow(i, j);
                for (Square sq : squares) {
                    if (sq.getNumber() == -1) {
                        System.out.print("*");
                    } else {
                        System.out.print(sq.getNumber());
                    }
                }
                System.out.println("");
            }
        }
    }
}
