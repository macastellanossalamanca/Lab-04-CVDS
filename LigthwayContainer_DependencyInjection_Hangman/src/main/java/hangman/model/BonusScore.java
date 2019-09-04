package hangman.model;

import Excepciones.HangmanException;

public class BonusScore implements GameScore {
    private int score;
        
    
    public BonusScore(){
    	score=0;
    }
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		if(incorrectCount > 25) throw new HangmanException(HangmanException.EXCESO_ERROR);
		if((incorrectCount + correctCount)>27) throw new HangmanException(HangmanException.EXCESO_TOTAL);
		return (correctCount*10)-(incorrectCount*5)>0?(correctCount*10)-(incorrectCount*5):0;
	}

}
