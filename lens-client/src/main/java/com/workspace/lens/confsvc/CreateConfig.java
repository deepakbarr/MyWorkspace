package com.workspace.lens.confsvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by deepak.barr on 03/09/15.
 */
public class CreateConfig {
  public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
    File folder = new File("/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/lmsprop");
    File[] files = folder.listFiles();

    List<String> configList = new ArrayList();
    for (File file : files) {

      System.out.println("Reading "+file.getName());
      if (file.getName().endsWith("xml"))
        configList.addAll(parseXml(file));
      else if (file.getName().endsWith("properties"))
        configList.addAll(parseProperties(file));
      else {
        System.out.println("Something went wrong with " + file);
//        System.exit(1);
      }
    }
    String jsonConfig = createJsonConfig(configList);
    System.out.println(jsonConfig);
  }

  private static String createJsonConfig(List<String> configList) {
    StringBuilder sb = new StringBuilder();
    for (String val : configList) {
      sb.append(val + ",");
    }
   String configCsv=sb.toString().substring(0,sb.toString().length()-1);
    return "{"+configCsv+"}";
  }

  @SuppressWarnings("unchecked")
  private static List<String> parseXml(File file) throws IOException, ParserConfigurationException, SAXException {
    DocumentBuilderFactory dbFactory
      = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(file);
    doc.getDocumentElement().normalize();
    System.out.println("Root element :"
      + doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("property");
    System.out.println(file.getName()+" = " + nList.getLength());
    List<String> list = new ArrayList(nList.getLength());
    for (int temp = 0; temp < nList.getLength(); temp++) {
      Node nNode = nList.item(temp);
      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;
        String key=eElement.getElementsByTagName("name").item(0).getTextContent();
        String value=eElement.getElementsByTagName("value").item(0).getTextContent();
        list.add("\"" + file.getName() + "__" + key + "\":\"" + value + "\"");
      }
    }
    return list;
  }
  @SuppressWarnings("unchecked")
  private static List<String> parseProperties(File file) throws IOException {

    Properties props = new Properties();
    props.load(new FileInputStream(file));
    List<String> list = new ArrayList(props.size());
    for (Object key : props.keySet()) {
      String value = (String) props.get(key);
      String prop = "\"" + file.getName() + "__" + key + "\":\"" + value + "\"";
      list.add(prop);
    }
    return list;
  }
}
