package Parsers;
import Exception.FindXmlRarsererError;
import Interface.ResultItem;
import java.io.*;
import java.util.*;

import Resault.XmlResultItem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
public class XmlParser extends AbstractParser {
    //constructor by default
    public XmlParser() {
        super(List.of("xml"));
    }

    @Override
    public List<ResultItem> parseFromParserer(File file, String text) {
        List<ResultItem> list = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactoryForParserer = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryForParserer.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder documentBuilderForParserer = documentBuilderFactoryForParserer.newDocumentBuilder();
            Document document = documentBuilderForParserer.parse(file);
            document.getDocumentElement().normalize();
            Node firstNode = document.getFirstChild();

            if (firstNode.hasChildNodes()) {
                NodeList nodeList = firstNode.getChildNodes();
                stepsXmlNode(nodeList, text, list);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }
    //USE RECRUTION DONOT FORGET ABOUT IT
    private static List<ResultItem> stepsXmlNode(NodeList nodeList, String str, List<ResultItem> resultItems) {
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE)continue;
                Node fatherNode = nodeList.item(i);
                //if node has children
                if (fatherNode.hasChildNodes())
                {
                    stepsXmlNode(fatherNode.getChildNodes(), str, resultItems);
                    if (fatherNode.getTextContent().contains(str))
                    {
                        XmlResultItem xmlResaultItem = new XmlResultItem(fatherNode.getNodeName());
                        resultItems.add(xmlResaultItem);
                    }
                }
            }
        }catch(IndexOutOfBoundsException e){
            throw new FindXmlRarsererError("Error in length");
        }catch(RuntimeException e){
            throw new FindXmlRarsererError("Error in recrusion");
        }
        return resultItems;
    }
}