package md;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

public class jtidy {
 public static void check(String nonWellFormed) {

  InputStream is=null;
  System.out.println(nonWellFormed);
  
  try {
   is = new ByteArrayInputStream(nonWellFormed.getBytes("UTF-8"));
         
   Tidy tidy = new Tidy(); 
   tidy.setXHTML(true); 
   tidy.setDocType("\"-//W3C//DTD XHTML 1.0 Transitional//EN\""); 
   tidy.setInputEncoding("UTF-8");
   tidy.setQuiet(true); 
   tidy.setShowWarnings(false); 
   tidy.setIndentContent(true); 
   tidy.setSmartIndent(true); 
   tidy.setIndentAttributes(true); 
   tidy.setWraplen(0);
         OutputStream out = null; 
         Document doc = tidy.parseDOM(is, out); 
         NodeList nodeList = doc.getElementsByTagName("html");
         
   if (nodeList.getLength() == 1) {
    Node node = nodeList.item(0);
    traverseRecur(node, 0, "/"); 
   } else {
    System.out.println("html node not found!");
   } 
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
 
 private static void traverseRecur(Node node, int depth, String xpath) {
  printNodeTree(node, depth, xpath);
  
  NodeList childNodes = node.getChildNodes();
  HashMap<String, Integer> siblingCounts = new HashMap<String, Integer>();
  
  for(int i = 0; i < childNodes.getLength(); i++){
   Node child = childNodes.item(i);
   String childname = child.getNodeName();
   if(node.getNodeType() != Node.ELEMENT_NODE) {
    continue; 
   }
   
   Integer count = siblingCounts.get(childname);
   
   if (count != null) {
    count += 1;
   } else {
    // insert sibling count
    count = 1;
   }
   
   siblingCounts.put(childname, count);
   String childpath = xpath + String.format("/%s[%d]", childname, count);
   
   traverseRecur(childNodes.item(i), depth + 1, childpath);
  }
 }
 private static void printNodeTree(Node node, int depth, String xpath) {
  String nodeName = node.getNodeName();
  String nodeValue = node.getNodeValue();
  String attr = "";
  
  // elem attr
  if(nodeName.equals("a") || nodeName.equals("img") || nodeName.equals("iframe")){
   try {
    Element e = (Element) node;
    String src = e.getAttribute("src");
    String href = e.getAttribute("href");
    if (src != "") {
     attr = src;
    } else if(href != "") {
     attr = href;
    }
   } catch(Exception ex) {
    System.out.println(ex.getMessage());
   }
  }
  
  // print
  String indent = "";
  for (int i=0 ; i<depth ; i++) {
   indent += "    ";
  }
  
 // System.out.println(indent + "name: " + nodeName + ", value: " + nodeValue + ", (" + xpath + "), attr: " + attr);
	}
} 