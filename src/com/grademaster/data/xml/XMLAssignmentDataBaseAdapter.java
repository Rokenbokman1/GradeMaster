package com.grademaster.data.xml;

import java.io.StringWriter;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.grademaster.Globals;
import com.grademaster.data.IDataObject;
import com.grademaster.data.objects.Assignment;
import com.grademaster.data.objects.AssignmentDataBase;
import com.grademaster.logging.ErrorLevel;

public class XMLAssignmentDataBaseAdapter implements IXMLAdapter {

	@Override
	public IDataObject dataToObject(Object o) {
		Globals.getLogger().log("Converting XML data to AssignmentDataBase object...");
		
		AssignmentDataBase base = new AssignmentDataBase();
		
		Document doc = (Document) o;
		
		NodeList users = doc.getElementsByTagName("assignment");
		
		for (int i=0;i<users.getLength();i++) {
			HashMap<String,String> map = new HashMap<String,String>();
			
			Node aNode = users.item(i);
			for (int u=0;u<aNode.getChildNodes().getLength();u++) {
				Node n = aNode.getChildNodes().item(u);
				//Used for debugging - Globals.getLogger().log("Processing - " + n.getNodeName()+": " + n.getTextContent());
				map.put(n.getNodeName(), n.getTextContent());
				Globals.getLogger().log(n.getNodeName()+": "+n.getTextContent());
			}
			Assignment a= new Assignment(map.get("aid"),map.get("sid"),map.get("name"),map.get("multi"),map.get("pts"),map.get("assigned"),map.get("due"),map.get("desc"));
			base.addObject(a);
		}
		
		return base;
	}

	@Override
	public String objectToData(Object obj) throws ParserConfigurationException,
			Exception {
		Globals.getLogger().log("XMLAssignmentDataBase to XML not complete yet!", ErrorLevel.WARNING);
		Globals.getLogger().log("Converting UserDataBase object to String (should be XML)...");
		
		//Cast object to config
		AssignmentDataBase os = (AssignmentDataBase) obj;
		
		//Initialize DOM
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("assignments");
		doc.appendChild(rootElement);
		
		//Create config element
		Element xml = rootElement;
		
		for (Object o1 : os.getObjects()) {
			Assignment o = (Assignment) o1;
			
			Element u = doc.createElement("assignment");
			xml.appendChild(u);
			
			//Start creating data nodes
			Element p1 = doc.createElement("aid");
			p1.appendChild(doc.createTextNode(o.getAid()));
			u.appendChild(p1);
			
			Element p2 = doc.createElement("sid");
			p2.appendChild(doc.createTextNode(o.getSid()));
			u.appendChild(p2);

			Element p3 = doc.createElement("name");
			p3.appendChild(doc.createTextNode(o.getName()));
			u.appendChild(p3);
			

			Element p4 = doc.createElement("multi");
			p4.appendChild(doc.createTextNode(o.getMulti()));
			u.appendChild(p4);			

			Element p5 = doc.createElement("pts");
			p5.appendChild(doc.createTextNode(o.getPts()));
			u.appendChild(p5);

			Element p6 = doc.createElement("assigned");
			p6.appendChild(doc.createTextNode(o.getAssigned()));
			u.appendChild(p6);

			Element p7 = doc.createElement("due");
			p7.appendChild(doc.createTextNode(o.getDue()));
			u.appendChild(p7);
			
			Element p8 = doc.createElement("desc");
			p8.appendChild(doc.createTextNode(o.getDesc()));
			u.appendChild(p8);
		}
		
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		StringWriter buffer = new StringWriter();
		transformer.transform(new DOMSource(doc),
		      new StreamResult(buffer));
		String str = buffer.toString().replace(">", ">\n").replace("</", "\n</");
		
		return str;
	}

}
