package hangman.model;

public class PowerScore implements GameScore {

	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
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
