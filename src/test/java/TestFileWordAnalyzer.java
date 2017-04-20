import static junit.framework.TestCase.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by trixi on 2017.04.20..
 */
public class TestFileWordAnalyzer {

    String filePath = "/home/trixi/introduction-to-junit-bozsob/src/test/resources/testMyFile.txt";
    FilePartReader fpReaderMock = new FilePartReader(filePath, 1, 3);

    FileWordAnalyzer fwanalyzer = new FileWordAnalyzer(fpReaderMock);
    /*
    @Before
    public void makePartReaderObjectAsMock()
    {
        String filePath = "/home/trixi/introduction-to-junit-bozsob/src/test/resources/testMyFile.txt";
        FilePartReader fpReader = new FilePartReader(filePath, 1, 3);

        ArrayList<String> lines = new ArrayList();
        lines.add("krumpli");
        lines.add("padlizsán");
        lines.add("paradicsom");
    }
    */

    @Test
    public void testIfWordsByABCMethodSortProperly() throws IOException
    {
        ArrayList<String> lines = new ArrayList();
        lines.add("krumpli");
        lines.add("padlizsán");
        lines.add("paradicsom");

        assertEquals(lines, fwanalyzer.wordsByABC());
    }

    @Test
    public void testIfSubstringIsInWords() throws IOException
    {
        ArrayList<String> lines = new ArrayList();
        lines.add("paradicsom");
        lines.add("padlizsán");
        assertEquals(lines, fwanalyzer.wordsContainingSubString("pa"));
    }





}
