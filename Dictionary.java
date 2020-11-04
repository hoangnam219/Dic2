import java.util.ArrayList;

public class Dictionary {
    ArrayList<Word> word_list = new ArrayList<Word>();

    public void AddWord(Word newWord){
        word_list.add(newWord);
    }

    public void showAllWords(){
        for (int i = 0 ; i < word_list.size() ; i++ )
        {
            System.out.printf("%4d | %-15s | %s%n",i+1,word_list.get(i).getWord_target(),word_list.get(i).getWord_explain());
        }
    }

    public String findWord(String Lookup){
        for (Word word:word_list){
            String eng = word.getWord_target();
            if (eng.compareTo(Lookup) == 0 ) return word.getWord_explain();
        }
        return "Khong tim thay";
    }

    public void delWord( String delWord1 ){
        for (Word word:word_list) {
            if (delWord1.compareTo(word.getWord_target()) == 0) word_list.remove(word);
        }
        showAllWords();
    }

    public void editWord(String editWord1,String editWord2 ){
        for (int i = 0 ; i < word_list.size(); i++ ){
            if (editWord1.compareTo(word_list.get(i).getWord_target()) == 0 ) word_list.get(i).setWord_explain(editWord2);
        }
    }

    public ArrayList<Word> getWord_list() {
        return word_list;
    }

    public void setWord_list(ArrayList<Word> word_list) {
        this.word_list = word_list;

    }
}
