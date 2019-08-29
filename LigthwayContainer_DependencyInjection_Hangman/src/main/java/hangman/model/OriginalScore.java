package hangman.model;

public class OriginalScore implements GameScore {

	
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		return 100-(incorrectCount*10)>0?100-(incorrectCount*10):0;
	}

}
