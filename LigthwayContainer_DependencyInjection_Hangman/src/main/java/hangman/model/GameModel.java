/***************************************************************
* file: GameModel.java
* author:   Christopher Santos
*           Omar Rodriguez
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 10/11/2016
*
* purpose: This is the model component for the game screen
*
****************************************************************/ 
package hangman.model;

import hangman.model.dictionary.HangmanDictionary;
import hangman.setup.guice.HangmanFactoryServices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Excepciones.HangmanException;

public class GameModel {
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private GameScore gameScore;
    private int[] lettersUsed;

    private HangmanDictionary dictionary;

    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;

    public GameModel(HangmanDictionary dictionary) {
        Injector in = Guice.createInjector(new HangmanFactoryServices());
        // this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary = dictionary;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = in.getInstance(GameScore.class);

    }

    // method: reset
    // purpose: reset this game model for a new game
    public void reset() {
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        Injector in = Guice.createInjector(new HangmanFactoryServices());
        gameScore = in.getInstance(GameScore.class);
    }

    // setDateTime
    // purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    // method: makeGuess
    // purpose: check if user guess is in string. Return a
    // list of positions if character is found in string
    public ArrayList<Integer> makeGuess(String guess) {
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < randomWordCharArray.length; i++) {
            if (randomWordCharArray[i] == guessChar) {
                positions.add(i);
            }
        }
        if (positions.size() == 0) {
            incorrectCount++;

        } else {
            correctCount += positions.size();
        }
        return positions;

    }

    // getDateTime
    // purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    // setScore
    // purpose: sets score value to points
    public void setScore(GameScore score) {
        this.gameScore = score;
    }

    // getScore
    // purpose: returns current score value
    public int getScore() {
        try {
            return gameScore.calculateScore(correctCount, incorrectCount);
        } catch (HangmanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
       
    }

    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //method: getIncorrectCount
    //purpose: return number of incorrect guesses made so far
    public int getIncorrectCount() {
        return incorrectCount;
    }

    //method: getCorrectCount
    //purpose: return number of correct guesses made so far
    public int getCorrectCount() {
        return correctCount;
    }

    //method: getGameScore
    //purpose: return current score
    public int getGameScore() {
        try {
            return gameScore.calculateScore(correctCount, incorrectCount);
        } catch (HangmanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    //method: setGameScore
    //purpose: set current game score
    public void setGameScore(GameScore gameScore) {
        this.gameScore = gameScore;
    }
    
    //method: getWordLength
    //purpose: return length of current word
    public int getWordLength(){
        return randomWord.length();
    }

    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
