package algo.test;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class SAXReader {
	



	    public static void main(String[] args) {
	        try {
	            // Create a SAXParserFactory
	            SAXParserFactory factory = SAXParserFactory.newInstance();

	            // Create a SAXParser
	            SAXParser saxParser = factory.newSAXParser();

	            // Create a handler to process only <name> and <age> elements
	            DefaultHandler handler = new DefaultHandler() {
	                boolean isName = false;
	                boolean isAge = false;

	                String currentName = null;
	                int currentAge = 0;

	                @Override
	                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	                    // Check for <name> and <age> elements
	                    if (qName.equalsIgnoreCase("name")) {
	                        isName = true;
	                    } else if (qName.equalsIgnoreCase("age")) {
	                        isAge = true;
	                    }
	                }

	                @Override
	                public void characters(char[] ch, int start, int length) throws SAXException {
	                    if (isName) {
	                        // Capture name data
	                        currentName = new String(ch, start, length);
	                    } else if (isAge) {
	                        // Capture age data
	                        currentAge = Integer.parseInt(new String(ch, start, length));
	                    }
	                }

	                @Override
	                public void endElement(String uri, String localName, String qName) throws SAXException {
	                    if (qName.equalsIgnoreCase("name")) {
	                        isName = false;
	                    } else if (qName.equalsIgnoreCase("age")) {
	                        isAge = false;
	                    } else if (qName.equalsIgnoreCase("person")) {
	                        // Once we reach </person>, output the collected name and age
	                        System.out.println("Person Name: " + currentName);
	                        System.out.println("Person Age: " + currentAge);
	                    }
	                }
	            };

	            // Parse the XML string (for simplicity, we'll parse a string here, you can use a file instead)
	            String xmlString = "<response>"
	                    + "<header><status>success</status></header>"
	                    + "<body><person><name>John</name><age>30</age></person>"
	                    + "<person><name>Johnny</name><age>32</age></person></body>"
	                    + "</response>";
	            
	            saxParser.parse(new java.io.ByteArrayInputStream(xmlString.getBytes()), handler);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

}
