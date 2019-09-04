package hangman.model;

import Excepciones.HangmanException;

public class PowerScore implements GameScore {

        private int score;
        
        
        public  PowerScore(){
            score=0;
        }
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		if(incorrectCount > 25) throw new HangmanException(HangmanException.EXCESO_ERROR);
		if((incorrectCount + correctCount)>27) throw new HangmanException(HangmanException.EXCESO_TOTAL);
		int puntaje = 0;
		for(int i=1; i <= correctCount; i++) {
			puntaje+=Math.pow(5, i);
		}
		if (puntaje-(8*incorrectCount)>500) {
			return 500;
		}
		else if(puntaje-(8*incorrectCount)<0) {
			return 0;
		}
		else {
			return puntaje-(8*incorrectCount);
		}
	}

}
