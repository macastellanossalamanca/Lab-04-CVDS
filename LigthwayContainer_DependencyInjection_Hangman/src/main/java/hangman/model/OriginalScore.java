package hangman.model;

import Excepciones.HangmanException;

public class OriginalScore implements GameScore {

	
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		if(incorrectCount > 25) throw new HangmanException(HangmanException.EXCESO_ERROR);
		if((incorrectCount + correctCount)>27) throw new HangmanException(HangmanException.EXCESO_TOTAL);
		return 100-(incorrectCount*10)>0?100-(incorrectCount*10):0;
	}

}
