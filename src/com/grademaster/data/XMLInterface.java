package com.grademaster.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: A class for loading xml data into an application

public class XMLInterface extends DataInterface {
	public XMLInterface(IRawLoader path,boolean cached) {
		super(path,cached);
	}
	public XMLInterface(IRawLoader path) {
		this(path,true);
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Object, Object> loadData() throws Exception {
		String file=loader.loadString();
		Document doc = loadXMLFromString(file);
		doc.getDocumentElement().normalize();
		
		HashMap<Object,Object> map = analyzeLayer(doc.getChildNodes());
		
		
		return map;
	}

	@Override
	public void writeData(HashMap<Object, Object> data) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	private HashMap<Object, Object> analyzeLayer(NodeList nodeList) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		for (int i=0; i<=nodeList.getLength(); i++) {
			Set<Object> keys = map.keySet();
			String key = nodeList.item(i).getNodeName();
			String realKey = key;
			int x = 0;
			while (keys.contains(realKey)) {
				realKey = key + x;
				x++;
			}
			map.put(realKey, nodeList.item(i).getTextContent());
		}
		return map;
	}
	
	public Document loadXMLFromString(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    return builder.parse(new ByteArrayInputStream(xml.getBytes()));
	}

}
