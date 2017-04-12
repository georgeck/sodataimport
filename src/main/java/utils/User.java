package utils;

import java.sql.Timestamp;

/**
 * Created by gchiramattel on 4/11/17.
 */
public class User {

    private int id;
    private int reputation;
    private String aboutme;
    private int accountid;
    private int age;
    private Timestamp creationdate;
    private String displayname;
    private Timestamp lastaccessdate;
    private String location;
    private String profileimageurl;
    private String websiteurl;

    public void setId(int id) {
        this.id = id;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }


    public void setLastaccessdate(Timestamp lastaccessdate) {
        this.lastaccessdate = lastaccessdate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }

    public String getAboutme() {
        return aboutme;
    }

    public int getAccountid() {
        return accountid;
    }

    public int getAge() {
        return age;
    }

    public Timestamp getCreationdate() {
        return creationdate;
    }

    public String getDisplayname() {
        return displayname;
    }


    public Timestamp getLastaccessdate() {
        return lastaccessdate;
    }

    public String getLocation() {
        return location;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public String getWebsiteurl() {
        return websiteurl;
    }
}
