import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {
    WordCounter counter = new WordCounter();

    @Test
    public void getCountOfWordInStringWorksForEmptyString() {
        int count = counter.getCountOfWordInString("hello", "");
        assertEquals(0, count);
    }

    @Test
    public void getCountOfWordInFileThrowsExceptionForBadPath() {
        assertThrows(IOException.class,
                () -> counter.getCountOfWordInFile("word", Paths.get("")));
    }

    @Test
    public void getCountOfWordInFileThrowsExceptionForEmptyWord() {
        assertThrows(IllegalArgumentException.class,
                () -> counter.getCountOfWordInFile("", Paths.get("./res/sample-file.txt")));
    }

}