/**
 * File copy.
 */

package percy.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Copy
 */
public class Copy {

  public static void main(String[] args) {
    fileCopy();
  }

  private static void fileCopy() {
    //! remember, current directory is the project directory.
    File inputFile = new File("src/main/java/percy/java/io/input.txt");
    try (InputStream inputStream = new FileInputStream(inputFile)) {

      //! Will it create a file named 'output.txt'? 
      //! Yes, it will.
      //! if 'output.txt' has already exist, it will trigger 'FileAlreadyExistsException'.
      // Files.copy(inputStream, Paths.get("src/main/java/percy/java/io/output.txt"));

      //! This will work always.
      Files.copy(inputStream, Paths.get("src/main/java/percy/java/io/output.txt"),
                  StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}