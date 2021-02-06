import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOExamplle {
    public static void main(String[] args) throws IOException {

        newTxt("file1.txt","First Text");
        redTxt("file1.txt");
        newTxt("file2.txt","Second Text");
        redTxt("file2.txt");
        ConcatFile("file1.txt","file2.txt","file3.txt");
        redTxt("file3.txt");
        System.out.println(SearchText("file3.txt", "First"));
        System.out.println(SerchTexFileDirectory("FilePath","First"));
    }

    public static void newTxt(String fileName, String text) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(text.getBytes(StandardCharsets.UTF_8));
        fos.close();

    }

    public static String redTxt(String fileName) throws IOException{
        FileInputStream fis = new FileInputStream(fileName);
        int b;
        String text = "";
        while ((b=fis.read())!=-1){
            text+=((char)b);
        }
        System.out.println(text);
        return text;

    }

    public static void ConcatFile(String fileFirst,String fileSecond,String fileThird) throws IOException {
        String textThird = "";
        textThird += redTxt(fileFirst);
        textThird += " ";
        textThird += redTxt(fileSecond);
        newTxt(fileThird, textThird);
    }

    public static boolean SearchText(String fileName, String text) throws IOException {
        String[] fileText =redTxt(fileName).split(" ");
        for (String s: fileText) {
            if (s.equals(text))
                return true;
        }
        return false;
    }

    public static boolean SerchTexFileDirectory(String path, String text)throws IOException{
        File file = new File(path);
        String[] fileList = file.list();
        System.out.println(fileList);
        for (String s:fileList) {
            if(SearchText(s,text))
                return true;
        }
        return false;
    }
}
