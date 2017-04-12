package utils;


public class UserCounters {
    int upVotes;
    int views;
    int downVotes;


    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(String upVotes) {
        this.upVotes = Integer.valueOf(upVotes);
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = Integer.valueOf(views);
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(String downVotes) {
        this.downVotes = Integer.valueOf(downVotes);
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}
