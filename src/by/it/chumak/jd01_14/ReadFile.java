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

    @Override
    public void readFile(String path, StringBuilder stringBuilder) throws IOException {
        BufferedReader inputFileReader = getInputFileReader(path);
        int count;

        while ((count = inputFileReader.read()) != -1) {
            stringBuilder.append((char) count);
        }

    }

    private BufferedReader getInputFileReader(String path) throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        return new BufferedReader(fileReader);
    }

    private DataInputStream getDataInputStream(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        return new DataInputStream(bufferedInputStream);
    }
}
