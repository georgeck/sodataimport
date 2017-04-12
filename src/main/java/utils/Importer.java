package utils;

import com.datastax.driver.core.Session;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Importer {

    public void usesImporter(String inputFileName, Session session){

        Path path = Paths.get(inputFileName);

        // open the file

        // SAX read each line


    }

}
