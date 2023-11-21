package com.solvd.zoomaven;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NinthHomework {
    /*
    Read text from the file and calculate the numbers of the unique words. Write the result to the file.
    The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.
    to leave only letters in your text you can use your_string.replaceAll("[^A-Za-z ]", "")
    */
    public static void main(String[] args) {

        try {

            File inputFile = new File("src/main/resources/file.txt");
            File outputFile = new File("src/main/resources/output.txt");

            Map<String, Long> words = exerciseWithStreams(inputFile);
            Map<String, Long> words2 = exercise(inputFile);

            outputFile.delete();

            writeFile(words, outputFile);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, Long> exercise(File inputFile) throws IOException {
        List<String> lines = FileUtils.readLines(inputFile, Charset.defaultCharset());
        Map<String, Long> wordsMap = new HashMap<>();

        for (String line : lines) {

            line = line.replaceAll("[^A-Za-z ]", "");
            String[] words = StringUtils.split(line, " ");
            for (String word : words) {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1L);
                } else {
                    wordsMap.put(word, 1L);
                }
            }
        }

        return wordsMap;

    }

    public static Map<String, Long> exerciseWithStreams(File inputFile) throws IOException {

        Map<String, Long> words = Arrays.stream(
                        FileUtils.readFileToString(inputFile, Charset.defaultCharset())
                                .replaceAll("[^A-Za-z ]", "")
                                .split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        return words;
    }

    public static void writeFile(Map<String, Long> map, File outputFile) {
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
            String data = k + " = " + v + "\n";
            try {
                FileUtils.writeStringToFile(outputFile, data, Charset.defaultCharset(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
