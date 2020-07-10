package javarefresh.fileHandle;


/**
 * XML to HTML using XSLT but by providing the string value.
 * Output will print on console
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTMLUsingString {

	public static void main(String[] args) throws Exception {

		String xmlValue = "<?xml version=\"1.0\"?>\n" + 
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
		String xsltValue =  
				"<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" + 
				"   <xsl:template match=\"/\">\n" + 
				"      <html>\n" + 
				"         <body>\n" + 
				"            <h1>Company Details</h1>\n" + 
				"            <table border=\"1\">\n" + 
				"               <tr>\n" + 
				"                  <th>EmpId</th>\n" + 
				"                  <th>EmpName</th>\n" + 
				"               </tr>\n" + 
				"               <xsl:for-each select=\"Company/Info\">\n" + 
				"                  <tr>\n" + 
				"                     <td>\n" + 
				"                        <xsl:value-of select=\"EmpId\" />\n" + 
				"                     </td>\n" + 
				"                     <td>\n" + 
				"                        <xsl:value-of select=\"EmpName\" />\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"               </xsl:for-each>\n" + 
				"            </table>\n" + 
				"         </body>\n" + 
				"      </html>\n" + 
				"   </xsl:template>\n" + 
				"</xsl:stylesheet>";
		
		InputStream xsltIS = new ByteArrayInputStream(xsltValue.getBytes(StandardCharsets.UTF_8));
		InputStream xmlIS = new ByteArrayInputStream(xmlValue.getBytes(StandardCharsets.UTF_8));
		
		Source xslt = new StreamSource(xsltIS);
		Source xml = new StreamSource(xmlIS);
		
		StringWriter sw = new StringWriter();
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer trasform = tFactory.newTransformer(xslt);
		trasform.transform(xml, new StreamResult(sw));
		System.out.println("HTML output =>"+sw);
	}

}
