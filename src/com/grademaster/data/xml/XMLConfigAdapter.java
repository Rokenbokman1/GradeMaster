package com.grademaster.data.xml;

import java.io.StringWriter;

import org.w3c.dom.Document;

import com.grademaster.Globals;
import com.grademaster.data.IDataObject;
import com.grademaster.data.objects.Config;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class XMLConfigAdapter implements IXMLAdapter {

	@Override
	public IDataObject dataToObject(Object o) {
		Globals.getLogger().log("Converting XML data to Config object...");
		
		Document doc = (Document) o;
		String name= doc.getElementsByTagName("name").item(0).getTextContent();
		String author= doc.getElementsByTagName("author").item(0).getTextContent();
		String date= doc.getElementsByTagName("date").item(0).getTextContent();
		String version= doc.getElementsByTagName("version").item(0).getTextContent();
		String logoPath= doc.getElementsByTagName("logo").item(0).getTextContent();
		
		Config con = new Config(name,author,date,version,logoPath);
		
		return con;
	}

	@Override
	public String objectToData(Object o) throws Exception {
		Globals.getLogger().log("Converting Config object to String (should be XML)...");
		
		//Cast object to config
		Config con = (Config) o;
		
		//Initialize DOM
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("config");
		doc.appendChild(rootElement);
		
		//Create config element
		Element config = rootElement;
		
		//Define config attributes
		Attr xmlns = doc.createAttribute("xmlns");
		xmlns.setValue("http://www.grademaster.com");
		config.setAttributeNode(xmlns);
		
		Attr xmlnsxsi = doc.createAttribute("xmlns:xsi");
		xmlnsxsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
		config.setAttributeNode(xmlnsxsi);
		
		Attr xsischemaLocation = doc.createAttribute("xsi:schemaLocation");
		xsischemaLocation.setValue("Config.xsd");
		config.setAttributeNode(xsischemaLocation);
		
		//Start creating data nodes
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(con.name));
		config.appendChild(name);
		
		//Create metadata element
		Element metadata = doc.createElement("metadata");
		config.appendChild(metadata);
		
		Element author = doc.createElement("author");
		author.appendChild(doc.createTextNode(con.metadata.author));
		metadata.appendChild(author);
		
		Element date = doc.createElement("date");
		date.appendChild(doc.createTextNode(con.metadata.date));
		metadata.appendChild(date);
		
		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode(con.metadata.version));
		metadata.appendChild(version);
		
		//More data nodes
		Element logoPath = doc.createElement("logo");
		logoPath.appendChild(doc.createTextNode(con.logoPath));
		config.appendChild(logoPath);
		
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		StringWriter buffer = new StringWriter();
		transformer.transform(new DOMSource(doc),
		      new StreamResult(buffer));
		String str = buffer.toString().replace(">", ">\n").replace("</", "\n</");
		
		return str;		
	}

}
