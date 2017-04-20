import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by trixi on 2017.04.20..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFilePartReader.class,
        TestFileWordAnalyzer.class
})

public class TestSuite {
}
