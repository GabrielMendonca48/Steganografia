import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test {

    public static void main(String[] args) {

        File mp3 = new File("bensound-anewbeginning.mp3");

        try {
            FileOutputStream fo = new FileOutputStream(mp3);

            System.out.println(fo);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
