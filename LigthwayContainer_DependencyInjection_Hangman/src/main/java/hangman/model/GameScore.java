package hangman.model;

public interface GameScore {
	/**
	 * @param correctCount
	 * @param incorrectCount
	 * @return Entero con el puntaje
	 */
	public int calculateScore(int correctCount, int incorrectCount);
}
