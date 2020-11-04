import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {
    public static void insertFromCommandline(Dictionary dict){
        System.out.print("Nhap so tu them vao : ");
        int sotu;
        Scanner sc = new Scanner(System.in);
        sotu = sc.nextInt();
        sc.nextLine();
        for(int i = 1 ; i <= sotu ; i++ )
        {
            System.out.println("Tu tieng Anh thu " + i);
            String EngWord = sc.nextLine();
            System.out.println("Tu tieng Viet thu " + i);
            String VieWord = sc.nextLine();
            Word newWord = new Word();
            newWord.setWord_target(EngWord);
            newWord.setWord_explain(VieWord);
            dict.AddWord(newWord);
        }
    }

    public static void insertFromFile(Dictionary dict){
        File file = new File("C:\\Users\\asus\\IdeaProjects\\dic\\src\\dictionaries.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String Vocabulary;
                Vocabulary = sc.nextLine();
                String[] Split = Vocabulary.split("\t");
                Word newWord = new Word();
                newWord.setWord_target(Split[0]);
                newWord.setWord_explain(Split[1]);
                dict.AddWord(newWord);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static String dictionaryLookup(Dictionary dict){
        System.out.println("Nhap tu muon tim : ");
        Scanner sc = new Scanner(System.in);
        String Lookup = sc.nextLine();
        return dict.findWord(Lookup);
    }

    public static void fixOrDelWord(Dictionary dict){
        String cmd;
        System.out.println("Ban co muon sua hay xoa tu gi khong?(3 lenh : sua,xoa,khong)");
        Scanner sc = new Scanner(System.in);
        cmd = sc.nextLine();
        switch(cmd) {

            case "xoa":
                String delWord1;
                System.out.println("Nhap tu muon xoa : ");
                delWord1 = sc.nextLine();
                dict.delWord(delWord1);
                break;

            case "sua":
                String editWord1;
                String editWord2;
                System.out.println("Nhap tu muon sua : ");
                editWord1 = sc.nextLine();
                System.out.println("Sua thanh : ");
                editWord2 = sc.nextLine();
                dict.editWord(editWord1,editWord2);
                break;

            default:
                System.out.println("Khong thay doi tu dien!");
                break;

        }
    }
    public static void dictionaryExportToFile(Dictionary dict){
        try {
            FileWriter ExportFile = new FileWriter("ExportFile0.txt");
            ArrayList<Word> string = dict.getWord_list();
            for (int i = 0; i < dict.word_list.size(); i++) {
                ExportFile.write(dict.getWord_list().get(i).getWord_target() + "     ");
                ExportFile.write(dict.getWord_list().get(i).getWord_explain() + "\n");
            }
            ExportFile.close();

        System.out.println("Da xuat file (Ten file : ExportFile0.txt)");
        } catch (IOException e){
            System.out.println("Da co loi khi xuat file!");
        }


    }
}
