package by.it.chumak.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class ReadFile implements ReadFileMethods {

    @Override
    public void readFile() {
    }

    @Override
    public void readFile(String path, ArrayList<Integer> integerArrayList) throws IOException {
        DataInputStream dataInputStream = getDataInputStream(path);

        while (dataInputStream.available() > 0) {
            integerArrayList.add(dataInputStream.readInt());
        }
        dataInputStream.close();
    }

    private DataInputStream getDataInputStream(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        return new DataInputStream(bufferedInputStream);
    }
}
