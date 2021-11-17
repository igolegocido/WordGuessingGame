import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
    private String word;
    private String gWord;
    private String guessed;
    public Puzzle(){
        word = "SOMETHING";
        gWord = "";
        guessed = "";
        for(int i =0;i<word.length();i++){
            gWord += "_";
        }
    }
    public boolean isUnsolved(){
        if(gWord.equals(word)){
            return false;
        }else{
            return true;
        }
    }
    public void show(){
        System.out.print("Puzzle: ");
        for(int i= 0;i<gWord.length();i++){
            System.out.print(gWord.substring(i,i+1)+" ");
        }
        System.out.println();
        System.out.print("Guesses: " + guessed);
    }
    public boolean makeGuess(String guess){
        guess = guess.toUpperCase();
        if(guess.length()>1){
            guess = guess.substring(0,1);
        }
        if(guessed.length()>0){
            guessed+=", "+guess;
        }else{
            guessed+= guess;
        }
        if(!word.contains(guess)){
            return false;
        }else{
            for(int i =0;i<word.length();i++){
                if(i<word.length()-1&&word.substring(i,i+1).equals(guess)){
                    gWord = gWord.substring(0,i)+guess+gWord.substring(i+1);
                }else if(word.substring(i,i+1).equals(guess)){
                    gWord = gWord.substring(0,i)+guess;
                }
            }
            return true;
        }
    }
    public String getWord(){
        return word;
    }
   
}
