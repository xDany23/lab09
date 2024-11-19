package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private final String USER = System.getProperty("user.home");
    private final String SEPARATOR = System.getProperty("user.separator");
    private File currentFile = new File(USER + SEPARATOR + "output.txt");

    public void setDefault(File file) {
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    public void WriteOnFile(String string) throws IOException {
       try (PrintStream ps = new PrintStream(this.currentFile, StandardCharsets.UTF_8)) {
            ps.print(string);
        } catch (IOException e1) {
            System.out.println("ERROR");
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }



}
