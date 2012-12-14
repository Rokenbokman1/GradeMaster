package com.grademaster.data.xml;
import org.w3c.dom.Document;

import com.grademaster.data.IDataObject;
import com.grademaster.data.objects.Config;

public class XMLConfigAdapter implements IXMLAdapter {

	@Override
	public IDataObject dataToObject(Object o) {
		Document doc = (Document) o;
		String name= doc.getElementsByTagName("name").item(0).getTextContent();
		String author= doc.getElementsByTagName("author").item(0).getTextContent();
		String date= doc.getElementsByTagName("date").item(0).getTextContent();
		String version= doc.getElementsByTagName("version").item(0).getTextContent();
		String logoPath= doc.getElementsByTagName("logo").item(0).getTextContent();
		
		Config con = new Config(name,author,date,version,logoPath);
		
		return con;
	}

}
