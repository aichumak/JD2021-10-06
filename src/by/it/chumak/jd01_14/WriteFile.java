package by.it.chumak.jd01_14;

import java.io.*;
import java.util.List;

public class WriteFile implements WriteFileMethods {
    @Override
    public void writeFile() {
    }

    @Override
    public void writeIntegerToFile(String path, List<Integer> integerList) throws IOException {
        DataOutputStream dataOutputStream = getDataOutputStream(path);
        for (Integer value : integerList) {
            dataOutputStream.writeInt(value);
        }
        dataOutputStream.close();
    }

    @Override
    public void writeIntegerToFile(String path, Integer value) throws IOException {
        DataOutputStream dataOutputStream = getDataOutputStream(path);
        dataOutputStream.writeInt(value);
        dataOutputStream.close();
    }

    private DataOutputStream getDataOutputStream(String path) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        return new DataOutputStream(bufferedOutputStream);
    }
}
