import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by trixi on 2017.04.19..
 */
public class TestFilePartReader {

    String filePath = "/home/trixi/introduction-to-junit-bozsob/src/test/resources/testMyFile.txt";

    @Test
    public void testIfContentEqualsFromLineToLine() throws IOException
    {
        FilePartReader fpReader = new FilePartReader(filePath, 1, 3);
        String lines = "paradicsom,\n" +
                "krumpli,\n" +
                "padlizsán,\n";
        assertEquals(lines, fpReader.readLines());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionInFilePartReaderConstructor()
    {
        FilePartReader fpReader = new FilePartReader(filePath, 4, 1);
    }

    @Test(expected = FileNotFoundException.class)
    public void testIfFileNotFound () throws IOException
    {
        String fPath = "/home/trixi/introduction-to-junit-bozsob/src/test/resources/BadPath.txt";
        FilePartReader fpReader = new FilePartReader(fPath, 1, 4);
        fpReader.readLines();
    }


}
