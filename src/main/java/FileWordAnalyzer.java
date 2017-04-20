import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by trixi on 2017.04.18..
 */
public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.filePartReader = fpr;
    }

    public ArrayList wordsByABC() throws IOException
    {
        String linesFromFile = filePartReader.readLines();

        linesFromFile = linesFromFile.replaceAll("[.|,]", "");

        ArrayList<String> orderedWords = new ArrayList<String>(Arrays.asList(linesFromFile.split("\\s")));

        Collections.sort(orderedWords, new Comparator<String>() {

            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

            // Collections.sort(orderedWords, String.CASE_INSENSITIVE_ORDER);

        return orderedWords;

    }

    public ArrayList wordsContainingSubString(String subString) throws IOException {

        ArrayList<String> words = new ArrayList();

        String linesFromFile = filePartReader.readLines();
        linesFromFile = linesFromFile.replaceAll("[.|,]", "");

        String[] lines = linesFromFile.split("\\s");

        for (String element : lines) {
            if(element.toLowerCase().contains(subString.toLowerCase())) {
                words.add(element);
            }
        }

        return words;
    }
}
