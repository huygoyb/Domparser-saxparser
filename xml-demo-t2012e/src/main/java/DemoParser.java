import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DemoParser {

    public static void main(String[] args){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("https://vnexpress.net/rss/tam-su.rss");
            Element element = document.getDocumentElement();
            System.out.println(element.getTagName());
            NodeList listItem = element.getElementsByTagName("item");
            for (int i = 0; i < listItem.getLength(); i++) {
                Article article = new Article();
                Node itemNode = listItem.item(i);
                System.out.println(itemNode.getChildNodes());
                NodeList itemChildNodeList = itemNode.getChildNodes();
                for (int j = 0; j < itemChildNodeList.getLength(); j++) {
                    Node ChildNode = itemChildNodeList.item(j);
                    if (ChildNode.getNodeType() == Node.ELEMENT_NODE) continue;
                    System.out.println(ChildNode.getNodeName()+"-"+ChildNode.getNodeType());
                    System.out.println(ChildNode.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
