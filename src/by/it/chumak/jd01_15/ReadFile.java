package by.it.chumak.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFile implements ReadFileMethods {

    @Override
    public void readFile(String path, ArrayList<Integer> integerArrayList) throws ExceptionsInfo {
        try (DataInputStream dataInputStream = getDataInputStream(path)) {
            while (dataInputStream.available() > 0) {
                integerArrayList.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    @Override
    public void readFile(String path, StringBuilder stringBuilder) throws ExceptionsInfo {
        int count;

        try (BufferedReader inputFileReader = getInputFileReader(path)) {
            while ((count = inputFileReader.read()) != -1) {
                stringBuilder.append((char) count);
            }
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    @Override
    public void readClassFile(String path, StringBuilder stringBuilder, Boolean deleteAllComments) throws ExceptionsInfo {
        if (deleteAllComments) {
            int count;
            States state = States.Code;
            StringBuilder buffer = new StringBuilder();

            try (BufferedReader inputFileReader = getInputFileReader(path)) {
                while ((count = inputFileReader.read()) != -1) {
                    stringBuilder.append((char) count);
                }
            } catch (IOException e) {
                throw new ExceptionsInfo();
            }
        } else {
            readFile(path, stringBuilder);
        }
    }

    @Override
    public void readFile(String path, List<String> arrayList) throws ExceptionsInfo {
        try (BufferedReader inputFileReader = getInputFileReader(path)) {
            while (true) {
                String line = inputFileReader.readLine();
                if (!Objects.isNull(line) && !line.isEmpty()) {
                    arrayList.add(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    private BufferedReader getInputFileReader(String path) throws ExceptionsInfo {
        try {
            FileReader fileReader = new FileReader(path);
            return new BufferedReader(fileReader);
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    private DataInputStream getDataInputStream(String path) throws ExceptionsInfo {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            return new DataInputStream(bufferedInputStream);
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }
}
