package com.grademaster.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

import com.grademaster.data.xml.IXMLAdapter;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: A class for loading xml data into an application

public class XMLInterface extends DataInterface {
	public XMLInterface(IRawLoader path,IDataAdapter a,boolean cached) {
		super(path,a,cached);
	}
	public XMLInterface(IRawLoader path,IXMLAdapter a) {
		this(path,a,true);
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDataObject loadData() throws Exception {
		String raw = loader.loadString();
		Document d = loadXMLFromString(raw);
		IDataObject o = adapter.dataToObject(d);
		return o;
	}

	@Override
	public void writeData(IDataObject data) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public Document loadXMLFromString(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    return builder.parse(new ByteArrayInputStream(xml.getBytes()));
	}

}
