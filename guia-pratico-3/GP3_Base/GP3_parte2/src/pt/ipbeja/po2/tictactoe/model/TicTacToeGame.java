package pt.ipbeja.po2.tictactoe.model;

import pt.ipbeja.po2.tictactoe.gui.TicTacToeGUI;
import pt.ipbeja.po2.tictactoe.gui.TicTacToeButton;

import java.util.ArrayList;

import static pt.ipbeja.po2.tictactoe.gui.TicTacToeGUI.SIZE;

public class TicTacToeGame {

	 public Place[][] boardData = new Place[SIZE][SIZE];

	 TicTacToeGUI ticTacToeGUI;

	 ArrayList<Place> moves = new ArrayList<>();

	 public TicTacToeGame(TicTacToeGUI ticTacToeGUI) {
			this.ticTacToeGUI = ticTacToeGUI;
	 }

	 public enum Place {
			EMPTY,
			O,
			X
	 }

	 enum GameStages {
	    RUNNING,
			DRAW,
			PLAYER1_WIN,
			PLAYER2_WIN
	 }

	 public void placeClicked(int line, int col, TicTacToeButton ticTacToeButton) {
			if (isFree(line, col)) {
				 if (moves.size() == 0 || moves.get(moves.size() - 1) == Place.O) {
						boardData[line][col] = Place.X;
						moves.add(Place.X);
						ticTacToeButton.setTic();
				 } else if (moves.get(moves.size() - 1) == Place.X) {
						boardData[line][col] = Place.O;
						moves.add(Place.O);
						ticTacToeButton.setTac();
				 }

			}

			switch (checkIfEnded(boardData)){
         case RUNNING:
            break;
         case DRAW:
            ticTacToeGUI.draw();
            break;
         case PLAYER1_WIN:
            ticTacToeGUI.playerWins(1);
            break;
         case PLAYER2_WIN:
            ticTacToeGUI.playerWins(2);
            break;
      }

	 }

	 public boolean isFree(int line, int col) {
			return boardData[line][col] == Place.EMPTY;
	 }

	 public GameStages checkIfEnded(Place[][] boardData) {
	    int filledInSpaces = 0;

      for (int line = 0; line < SIZE; line++) {
         for (int col = 0; col < SIZE; col++) {
            if(boardData[line][col] != Place.EMPTY){
               filledInSpaces++;
            }
         }
      }

      GameStages horizontal = isHorizontalWin(boardData);
      GameStages vertical = isVerticalWin(boardData);
      GameStages diagonal = isDiagonalWin(boardData);

			if (horizontal.equals(GameStages.RUNNING) &&
              vertical.equals(GameStages.RUNNING) &&
              diagonal.equals(GameStages.RUNNING)) {
			   if(filledInSpaces == SIZE * SIZE){
            return GameStages.DRAW;
         }else{
			      return GameStages.RUNNING;
         }

			}else if(horizontal.equals(GameStages.PLAYER1_WIN) ||
              vertical.equals(GameStages.PLAYER1_WIN) ||
              diagonal.equals(GameStages.PLAYER1_WIN)){

			   return GameStages.PLAYER1_WIN;

      }else if(horizontal.equals(GameStages.PLAYER2_WIN) ||
              vertical.equals(GameStages.PLAYER2_WIN) ||
              diagonal.equals(GameStages.PLAYER2_WIN)){

         return GameStages.PLAYER2_WIN;
      }

         return GameStages.RUNNING;
	 }

	 private static GameStages isHorizontalWin(Place[][] board) {
			for (int row = 0; row < SIZE; row++) {
				 if (isWin(board[row])) {

						if (board[row][0] == Place.X) {
							 return GameStages.PLAYER1_WIN;
						} else if(board[row][0] == Place.O) {
							 return GameStages.PLAYER2_WIN;
						}else{
						   return GameStages.RUNNING;
            }
				 }
			}
			return GameStages.RUNNING;
	 }

	 private static GameStages isVerticalWin(Place[][] board) {
			Place[] column = null;
			//assuming all rows have same length (same number of cols in each row), use first row
			for (int col = 0; col < SIZE; col++) {
				 column = new Place[SIZE];
				 for (int row = 0; row < SIZE; row++) {
						column[row] = board[row][col];
				 }
				 if (isWin(column)) {

						if (column[col] == Place.X) {
							 return GameStages.PLAYER1_WIN;
						} else if (column[col] == Place.O) {
							 return GameStages.PLAYER2_WIN;
						}else {
               return GameStages.RUNNING;
            }

				 }

			}
			return GameStages.RUNNING;
	 }

	 private static GameStages isDiagonalWin(Place[][] board) {

			int row = 0, col = 0;
			int cols = SIZE;
			int rows = SIZE; //assuming all rows are equal length so just use the first one

			//Create a one-dimensional array to represent the diagonal. Use the lesser
			// of the rows or columns to set its size. If the grid is rectangular then
			// a diagonal will always be the size of the lesser of its two dimensions.
			int size = SIZE;
			Place[] diagonal = new Place[size];

			//Since we know the grid is a square we really could just check one of
			// these - either row or col, but I left both in here anyway.
			while (row < rows && col < cols) {
				 diagonal[col] = board[row][col];

				 row++;
				 col++;
			}
			if (isWin(diagonal)) {
         if (diagonal[0] == Place.X) {
            return GameStages.PLAYER1_WIN;
         } else if(diagonal[0] == Place.O) {
            return GameStages.PLAYER2_WIN;
         }else {
            return GameStages.RUNNING;
         }

			}


			row = rows - 1;
			col = 0;
			diagonal = new Place[size];
			while (row >= 0 && col < cols) {
				 diagonal[col] = board[row][col];
				 row--;
				 col++;
			}

			if (isWin(diagonal)) {
         if (diagonal[0] == Place.X) {
            return GameStages.PLAYER1_WIN;
         } else if(diagonal[0] == Place.O) {
            return GameStages.PLAYER2_WIN;
         }else {
            return GameStages.RUNNING;
         }
			} else {
				 return GameStages.RUNNING;
			}

	 }

	 private static boolean isWin(Place[] lineToProcess) {
			boolean foundWin = true;
			Place prevChar = Place.EMPTY;
			for (Place character : lineToProcess) {
				 if (prevChar == Place.EMPTY)
						prevChar = character;
				 if (Place.O != character && Place.X != character) {
						foundWin = false;
						break;
				 } else if (prevChar != character) {
						foundWin = false;
						break;
				 }
			}
			return foundWin;
	 }

}
