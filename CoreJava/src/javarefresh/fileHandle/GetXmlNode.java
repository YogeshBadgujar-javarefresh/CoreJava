package javarefresh.fileHandle;

/**
 * Get the xml note. 
 * 1) Get the child element not attribute, upto 2 levels
 * 2) Get all node/childnode name.
 * 
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetXmlNode {
	public static void main(String[] args)
			throws SAXException, IOException, ParserConfigurationException, TransformerException {

		String xlsValue = "<?xml version=\"1.0\"?>\n" + 
				"<Company>\n" + 
				"    <Info>\n" + 
				"            <EmpId>12</EmpId>\n" + 
				"            <EmpName>Yogesh</EmpName>\n" + 
				"   </Info>\n" + 
				"    <Info>\n" + 
				"            <EmpId>22</EmpId>\n" + 
				"            <EmpName>Sachin</EmpName>\n" + 
				"    </Info>\n" + 
				"</Company>";		
		InputStream xmlIS = new ByteArrayInputStream(xlsValue.getBytes(StandardCharsets.UTF_8));
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.parse(xmlIS);

		NodeList cNodeList = document.getChildNodes();
		
		for (int i = 0; i < cNodeList.getLength(); i++) {
			Node cTempNode = cNodeList.item(i);
			System.out.println("First child = "+cTempNode.getNodeName());//here company get
			if(cTempNode.hasChildNodes()) {
				NodeList ccNodeList = cTempNode.getChildNodes();				
				for (int cc = 0; cc < ccNodeList.getLength(); cc++) {
					Node ccTempNode = ccNodeList.item(cc);
					if (ccTempNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("Second child = "+ccTempNode.getNodeName());//here info get
					}
					
					if(ccTempNode.hasChildNodes()) {						
						NodeList cccNodeList = ccTempNode.getChildNodes();
						for (int ccc = 0; cc < cccNodeList.getLength(); ccc++) {
							Node cccTempNode = cccNodeList.item(ccc);
							if (cccTempNode != null && cccTempNode.getNodeType() == Node.ENTITY_NODE) {
								System.out.println("Third child = "+cccTempNode.getNodeName());//here info get
							}
							if(cccTempNode != null && cccTempNode.hasChildNodes()) {
								System.out.println("Further logic need to write");
							}else {
								System.out.println("No further");
								break;
							}
						}
					} 				
				}
			}
		}
				
		NodeList nodeList = document.getElementsByTagName("*");
		System.out.println("Get all node name=>");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// do something with the current element
				System.out.println("Node Name="+node.getNodeName());
			}
		}
	}
}
