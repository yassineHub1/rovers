package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static List<String> parseInputfile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        }

        return lines;
    }

    public static void checkInputFile(String filename) throws IOException{
        List<String> l = parseInputfile(filename);
        // TODO: Check if the input file is valid.
    }

}


