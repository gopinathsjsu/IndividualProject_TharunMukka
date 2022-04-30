package test.Writer;

import test.storage.OutputStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ErrorWriter implements Writer{
    public void outputWriter(String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(path));
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();

        StringBuilder builder = new StringBuilder();

        for(String out:outputStorage.getErrorOutput()){
            builder.append(out+"\n");
        }

        pw.write(builder.toString());
        pw.close();
        System.out.println("error output file writing done!");
    }
}
