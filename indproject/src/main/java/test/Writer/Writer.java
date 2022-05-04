package test.Writer;

import java.io.FileNotFoundException;

public interface Writer {
    // factory method
    String outputWriter(String path) throws FileNotFoundException;
}
