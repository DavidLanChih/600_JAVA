/**
 * @jdk版本:1.6
 * @寫程式時間:2010-3-20
 */
package com.mingrisoft.SAX_demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author bwm
 * 
 */
public class ElementNameSAXParsing extends DefaultHandler {

	private List<String> list = new ArrayList<String>();

	/**
	 * 重新定義父類別方法，儲存XML元素
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		list.add(localName);
	}

	/**
	 * 獲得
	 * 
	 * @return
	 */
	public List<String> getList() {
		return this.list;
	}

	/**
	 * 透過檔案讀取XML
	 * 
	 * @param pathname
	 *            檔案路徑
	 */
	public void parseReadFile(String pathname) {
		SAXParser parser;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			parser = factory.newSAXParser();
			File file = new File(pathname);
			parser.parse(file, this);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] arg) {

		String pathname = "xmldemo/books.xml";
		ElementNameSAXParsing elementSAXParsing = new ElementNameSAXParsing();
		elementSAXParsing.parseReadFile(pathname);
		System.out.println("元素名稱");
		System.out.println(elementSAXParsing.getList());
	}
}
