public class Cd {


    public static final String TITLE_TAG ="title";
    public static final String DESCRIPTION_TAG ="description";
    public static final String PUBDATE_TAG ="pubDate";
    public static final String LINK_TAG ="link";
    public static final String GUID_TAG ="guid";

    private String title;
    private String description;
    private String pubDate;
    private String link;
    private String guid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
