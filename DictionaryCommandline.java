import application.MainLunch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DictionaryCommandline {
    static Dictionary Dict = new Dictionary();
    public static void showAllWords(){
        Dict.showAllWords();
    }
    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline(Dict);
        System.out.printf("%4s | %-15s | %s%n","No","English","Vietnamese");

        showAllWords();

    }
    public static void dictionaryAdvanced(){
        DictionaryManagement.insertFromFile(Dict);
        showAllWords();
        String s = DictionaryManagement.dictionaryLookup(Dict);
        System.out.println("Nghia tu do la : " + s );
        DictionaryManagement.fixOrDelWord(Dict);
    }

    public static void dictionarySearcher(Dictionary dict) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban muon tim tu gi?");
        String FindingWord = sc.nextLine();
        int lengthFWord = FindingWord.length();
        ArrayList<Word> string = Dict.getWord_list();
        System.out.println("Co nhung tu sau: ");
        for (Word word : Dict.getWord_list()) {
            if (word.getWord_target().startsWith(FindingWord)) {
                System.out.println(word.getWord_target());
            }
        }
    }

    public static void main(String[] args){
        //dictionaryAdvanced();
        //dictionarySearcher(Dict);
        //DictionaryManagement.dictionaryExportToFile(Dict);
        MainLunch.launch();
    }






}
