package helloworld;

import java.util.ArrayList;

public class JogoVelha {

    public static void main(String args[]) {
    }

    private int[] board;

    //From API
    JogoVelha(ArrayList<String> boardAsArray) {
		//cast to int[] but the input was char[]... in java char = int code so it will work
		int[] cvtBoard = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cvtBoard[(i * 3) + j] = boardAsArray.get(i).charAt(j);
			}
		}
		this.board = cvtBoard;
	}


	public boolean isVelha(){
    	return isVelha(this.board);
	}

	public static boolean isVelha (int[] jogo){

		for (int i=0; i<3; i++){
			int rowFirst = jogo[i*3];
			int rowSecond = jogo[(i*3)+1];
			int rowThird = jogo[(i*3)+2];

			int columnFirst = jogo[i];
			int columnSecond = jogo[i+3];
			int columnThird = jogo[i+6];

			//Rows check
			if (rowFirst == rowSecond && rowFirst == rowThird){
				return false;
			}
			//Columns check
			if (columnFirst == columnSecond && columnFirst == columnThird){
				return false;
			}
		}
		
		//Diagonal
			if ((jogo[0] == jogo[4] && jogo[0] == jogo[8]) || (jogo[2] == jogo[4] && jogo[2] == jogo[6])){
				return false;
			}

		return true;
	}
}
