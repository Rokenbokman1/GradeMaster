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
import com.grademaster.data.objects.User;
import com.grademaster.data.objects.UserDataBase;

public class XMLUserDataBaseAdapter implements IXMLAdapter {

	@Override
	public IDataObject dataToObject(Object o) {
		Globals.getLogger().log("Converting XML data to UserDataBase object...");
		
		UserDataBase base = new UserDataBase();
		
		Document doc = (Document) o;
		
		NodeList users = doc.getElementsByTagName("user");
		
		for (int i=0;i<users.getLength();i++) {
			HashMap<String,String> map = new HashMap<String,String>();
			
			Node userNode = users.item(i);
			for (int u=0;u<userNode.getChildNodes().getLength();u++) {
				Node n = userNode.getChildNodes().item(u);
				//Used for debugging - Globals.getLogger().log("Processing - " + n.getNodeName()+": " + n.getTextContent());
				map.put(n.getNodeName(), n.getTextContent().replace("\n", ""));					
			}
			User user= User.getInstance(map.get("uname"), map.get("pword"), map.get("fname"), map.get("lname"), map.get("uid"), map.get("type"), Boolean.parseBoolean(map.get("showWelcome")));
			Globals.getLogger().log("Loaded user: "+user.getUid()+": "+user.getUsername());
			base.addObject(user);
		}
		
		return base;
	}

	@Override
	public String objectToData(Object o) throws ParserConfigurationException,
			Exception {
		Globals.getLogger().log("Converting UserDataBase object to String (should be XML)...");
		
		//Cast object to config
		UserDataBase users = (UserDataBase) o;
		
		//Initialize DOM
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("users");
		doc.appendChild(rootElement);
		
		//Create config element
		Element xml = rootElement;
		
		for (Object user1 : users.getObjects()) {
			User user = (User) user1;
			
			Element u = doc.createElement("user");
			xml.appendChild(u);
			
			//Start creating data nodes
			Element uname = doc.createElement("uname");
			uname.appendChild(doc.createTextNode(user.getUsername()));
			u.appendChild(uname);
			
			Element pword = doc.createElement("pword");
			pword.appendChild(doc.createTextNode(user.getPassword()));
			u.appendChild(pword);
			
			Element fname = doc.createElement("fname");
			fname.appendChild(doc.createTextNode(user.getFname()));
			u.appendChild(fname);
			
			Element lname = doc.createElement("lname");
			lname.appendChild(doc.createTextNode(user.getLname()));
			u.appendChild(lname);
			
			Element type = doc.createElement("type");
			type.appendChild(doc.createTextNode(user.getUserType()));
			u.appendChild(type);
			
			Element uid = doc.createElement("uid");
			uid.appendChild(doc.createTextNode(user.getUid()));
			u.appendChild(uid);
			
			Element showWelcome = doc.createElement("showWelcome");
			showWelcome.appendChild(doc.createTextNode(Boolean.toString(user.isShowWelcomeMessage())));
			u.appendChild(showWelcome);
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
