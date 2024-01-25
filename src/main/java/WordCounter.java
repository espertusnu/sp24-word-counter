import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordCounter {
    public int getCountOfWordInFile(String word, Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String fileContents = String.join("\n", lines);
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
