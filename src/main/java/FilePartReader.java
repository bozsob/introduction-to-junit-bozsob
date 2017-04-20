import java.io.*;


/**
 * Created by trixi on 2017.04.18..
 */
public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {

        if(toLine < fromLine || toLine < 1) {
            throw new IllegalArgumentException("inappropriate arguments for fromLine or toLine");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    /*
    private String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    */

    private String read() throws IOException {

        String fileContent = "";
        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            fileContent += currentLine + "\n";
        }

        return fileContent;
    }

    public String readLines() throws IOException {

        String result = "";

            String fileContent = this.read();

            String[] lines = fileContent.split("\n");

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < lines.length; i++) {

                if (i >= (fromLine - 1) && i < toLine) {
                    stringBuilder.append(lines[i] + "\n");
                }
            }

            result = stringBuilder.toString();
        return result;
    }
}
