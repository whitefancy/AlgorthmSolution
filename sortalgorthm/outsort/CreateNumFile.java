package sortalgorthm.outsort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateNumFile {
    public static void main(String[] args) throws IOException {
        File file = new File("test/source.txt");
        int numCount = 10000000;
        Random r = new Random();
        if (file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < numCount; i++) {
            fw.write(r.nextInt() + "\n");
        }
        fw.close();

    }
}
