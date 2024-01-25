import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.annotations.VisibleForTesting;

public class WordCounter {
    /**
     * Counts the number of times a word appears in a file.
     *
     * @param word the word to search for
     * @param path the path to the file
     * @return the count
     * @throws IOException if the file cannot be read
     */
    public int getCountOfWordInFile(String word, Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String fileContents = String.join("\n", lines);
        return getCountOfWordInString(word, fileContents);
    }

    @VisibleForTesting
    public int getCountOfWordInString(String word, String fileContents) {
        int count = 0;
        int index = 0;
        while (index < fileContents.length()) {
            index = fileContents.indexOf(word, index);
            if (index == -1) { // not found
                return count;
            }
            count++;
            index += word.length();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        WordCounter counter = new WordCounter();
        Path path = Paths.get("./res/sample-file.txt");
        int count = counter.getCountOfWordInFile("fun", path);
        System.out.printf("The word 'fun' appears %d times.\n", count);
    }
}
