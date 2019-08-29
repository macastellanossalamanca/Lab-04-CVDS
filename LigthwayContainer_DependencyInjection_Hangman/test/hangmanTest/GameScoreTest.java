package hangmanTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import hangman.model.*;

public class GameScoreTest {

	@Test
	public void OriginalScore() {
		OriginalScore os = new OriginalScore();
		assertEquals(0, os.calculateScore(5, 20));
		assertEquals(0, os.calculateScore(5, 10));
		assertEquals(50, os.calculateScore(5, 5));
	}
	
	@Test
	public void bonusScore() {
		BonusScore os = new BonusScore();
		
		assertEquals(0, os.calculateScore(1, 3));
		assertEquals(0, os.calculateScore(1, 2));
		assertEquals(45, os.calculateScore(5, 1));
	}
	
	@Test
	public void powerBonusScore() {
		PowerScore os = new PowerScore();
		System.out.println(os.calculateScore(2, 4));
		assertEquals(0, os.calculateScore(2, 4));
		assertEquals(30, os.calculateScore(2, 0));
		
	}
}
