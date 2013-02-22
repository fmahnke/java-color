package com.fritzmahnke.color;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

    public static String toXML(IElement cxfElement) {
	DocumentBuilderFactory documentBuilderFactory =
	    DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder;
	Document document = null;
	try {
	    documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    document = documentBuilder.newDocument();
	    Element element = cxfElement.toXML(document);
	    document.appendChild(element);
	    
	} catch (ParserConfigurationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	TransformerFactory transformerFactory =
	    TransformerFactory.newInstance();
	String output = null;
	try {
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StringWriter writer = new StringWriter();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    transformer.transform(source, new StreamResult(writer));
	    output = writer.getBuffer().toString();
	} catch (TransformerConfigurationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (TransformerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return output;
    }
}
