package nivel1; 

public class JogoVelha {
    public static void main(String args[]) {
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
