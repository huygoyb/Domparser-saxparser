

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParser {
    private static final String XML_URL ="https://vnexpress.net/rss/tam-su.rss";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(XML_URL, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
