package mx.edu.uacm.test.feeds;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;

import mx.edu.uacm.feeds.Feeds;

public class FeedsTest {
	
	@Test
	public void obtenerTituloFeedsTest() {
		
		Feeds feeds = new Feeds();
		
		try {
			
			feeds.desplegarFeeds();
			
		} catch (XPathExpressionException | ParserConfigurationException | IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
