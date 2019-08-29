package hangman.model;

public class BonusScore implements GameScore {

	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		return (correctCount*10)-(incorrectCount*5)>0?(correctCount*10)-(incorrectCount*5):0;
	}

}
