package test.Writer;

import java.io.FileNotFoundException;

public interface Writer {
    // factory method
    void outputWriter(String path) throws FileNotFoundException;
}
