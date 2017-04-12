package utils;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Timestamp;

public class UserHandler extends DefaultHandler {

    private static final String prepareStatement = "INSERT INTO user (id, aboutme, accountid, age, creationdate, displayname, lastaccessdate, location, profileimageurl, reputation, websiteurl) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,? );";
    private Session session;
    private BoundStatement boundStatement;
    private User user = new User();
    private UserCounters userCounters = new UserCounters();
    private String tempValue;
    private int counter = 0;

    void setSession(Session session) {
        this.session = session;
        PreparedStatement statement = session.prepare(prepareStatement);
        boundStatement = new BoundStatement(statement);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        try {

            if (qName.equalsIgnoreCase("row")) {

                user.setId(Integer.valueOf(attributes.getValue("Id")));

                user.setReputation(Integer.valueOf(attributes.getValue("Reputation")));

                user.setAboutme(attributes.getValue("AboutMe"));

                user.setAccountid(Integer.valueOf(attributes.getValue("AccountId")));

                tempValue = attributes.getValue("Age");
                if(tempValue.length() > 0) {
                    user.setAge(Integer.valueOf(tempValue));
                }
                user.setCreationdate(Timestamp.valueOf(attributes.getValue("CreationDate").replace('T', ' ')));

                user.setDisplayname(attributes.getValue("DisplayName"));

                user.setCreationdate(Timestamp.valueOf(attributes.getValue("LastAccessDate").replace('T', ' ')));

                user.setLocation(attributes.getValue("Location"));

                user.setProfileimageurl(attributes.getValue("ProfileImageUrl"));

                user.setProfileimageurl(attributes.getValue("WebsiteUrl"));

                userCounters.setViews(attributes.getValue("Views"));
                userCounters.setUpVotes(attributes.getValue("UpVotes"));
                userCounters.setDownVotes(attributes.getValue("DownVotes"));

                session.execute(boundStatement.bind(user.getId(), user.getAboutme(), user.getAccountid(), user.getAge(), user.getCreationdate(),
                        user.getDisplayname(), user.getLastaccessdate(), user.getLocation(), user.getProfileimageurl(), user.getReputation(), user.getWebsiteurl()));
                counter++;

            }
        } catch (Throwable ignored) {
            ignored.printStackTrace();
            System.out.println("counter = " + counter);
        }
    }
}
