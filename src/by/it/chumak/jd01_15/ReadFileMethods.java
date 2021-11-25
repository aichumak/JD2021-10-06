package by.it.chumak.jd01_15;

import java.util.ArrayList;
import java.util.List;

public interface ReadFileMethods {

    default void readFile(String path, ArrayList<Integer> integerArrayList) throws ExceptionsInfo {
    }

    default void readFile(String path, StringBuilder stringBuilder) throws ExceptionsInfo {
    }

    default void readClassFile(String path, StringBuilder stringBuilder, Boolean deleteAllComments) throws ExceptionsInfo {
    }

    default void readFile(String path, List<String> arrayList) throws ExceptionsInfo {
    }

}
