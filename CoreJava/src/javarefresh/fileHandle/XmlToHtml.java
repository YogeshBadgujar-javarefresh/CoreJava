package javarefresh.xml;

/**
 * Create the html by using xml and xslt base
 * Solution 1 - Write the code on console
 * Solution 2 - Write the code into file using Result
 * Solution 3 - Write the code into file using FileWriter
 * 
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlToHtml {

	public static void main(String args[]) {
		Source xml = new StreamSource("/home/user/git/CoreJava/CoreJava/src/xslt/product.xml");
		Source xslt = new StreamSource("/home/user/git/CoreJava/CoreJava/src/xslt/testXslt.xsl");

		convertXMLToHTML(xml, xslt);
	}

	public static void convertXMLToHTML(Source xml, Source xslt) {
		StringWriter sw = new StringWriter();

		try {
			// Solution 1 - Write the code on console
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trasform = tFactory.newTransformer(xslt);
			trasform.transform(xml, new StreamResult(sw));
			System.out.println("finally Output at console ==>" + sw);

			// Solution 2 - Write the code into file using Result
			// Example 1 - Write the ouput into file
			TransformerFactory tFactoryF = TransformerFactory.newInstance();
			Transformer trasformF = tFactoryF.newTransformer(xslt);
			// Start
			String outputValue = "/home/user/git/CoreJava/CoreJava/src/xslt/outPut.html";
			Result outputResult = new StreamResult(new File(outputValue).getAbsoluteFile());
			trasformF.transform(xml, outputResult);
			trasformF.transform(xml, new StreamResult(sw));
			System.out.println("finally write the code into File");

			// Solution 3 - Write the code into file using FileWriter
			// Example 2 - Write the ouput into file this way as well
			FileWriter fw = new FileWriter(new File("/home/user/git/CoreJava/CoreJava/src/xslt/outPut.html"));
			fw.write(sw.toString());
			fw.close();

			// Note - After execute create duplicate output as given same file both solution

		} catch (IOException | TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}