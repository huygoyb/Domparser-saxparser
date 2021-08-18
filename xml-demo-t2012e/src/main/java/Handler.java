import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Handler extends DefaultHandler {
    private ArrayList<Cd> cdArrayList = new ArrayList<>();
    private Cd currentCd;
    private boolean isTitle;
    private boolean isDescription;
    private boolean isPubDate;
    private boolean isLink;
    private boolean isGuid;

    public ArrayList<Cd> getCdArrayList() {
        return cdArrayList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {;
        switch (qName) {
            case "Cd":
                currentCd = new Cd();
                break;
            case Cd.TITLE_TAG:
                isTitle = true;
                break;
            case Cd.DESCRIPTION_TAG:
                isDescription = true;
                break;
            case Cd.PUBDATE_TAG:
                isPubDate = true;
                break;
            case Cd.LINK_TAG:
                isLink = true;
                break;
            case Cd.GUID_TAG:
                isGuid = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Cd")){
            cdArrayList.add(currentCd);
        }else if (equals("title")){
            isTitle = false;
        }else if (equals("description")){
            isDescription = false;
        }else if (equals("pubDate")){
            isPubDate = false;
        }else if (equals("link")){
            isLink = false;
        }else if (equals("guid")){
            isGuid = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (isTitle){
            currentCd.setTitle(value);
        }else if (isDescription){
            currentCd.setDescription(value);
        }else if (isPubDate) {
            currentCd.setPubDate(value);
        }else if (isLink) {
            currentCd.setLink(value);
        }else if (isGuid) {
            currentCd.setGuid(value);
        }
    }
}
