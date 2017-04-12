package utils;

import com.datastax.driver.core.Session;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Importer {

    public void usesImporter(String inputFileName, Session session){

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            userhandler.setSession(session);

            saxParser.parse(inputFileName, userhandler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
