package mx.edu.uacm.feeds;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Feeds {
	
	public void desplegarFeeds() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
		
		DocumentBuilderFactory domFactory =
				DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		URL url = new URL("http://www.sopitas.com/feed/");
		URLConnection uc = url.openConnection();
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();
		InputStream inputStream = uc.getInputStream();
		Reader reader = new InputStreamReader(inputStream);
		InputSource inputSource = new InputSource(reader);
		//Documento en forma de xml
		Document doc = builder.parse(inputSource);
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//rss/channel/item/title/text()");
		NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
		
		for(int i=0; i < nodes.getLength(); i++){
			
			String title = nodes.item(i).getNodeValue();
			System.out.println(title);
			
		}
		
	}

}
