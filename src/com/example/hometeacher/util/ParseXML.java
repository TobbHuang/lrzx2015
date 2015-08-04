package com.example.hometeacher.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class ParseXML {
	public static void parseXml(String xmlDoc) throws JDOMException,
			IOException {
		// 创建一个新的字符串
		StringReader read = new StringReader(xmlDoc);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder sax = new SAXBuilder();

		Document doc = sax.build(source);
		Element root = doc.getRootElement();
		parseElement(root);
	}

	private static void parseElement(Element element) {
		// TODO Auto-generated method stub
		List<Element> elementList = element.getChildren();
		for (Element e : elementList) {
			if (e.getChildren().size() > 0) {
				parseElement(e);
			} else {
				String elementName = e.getName();
				if ("result".equals(elementName)) {
					System.out.println("result" + e.getValue());
				}
			}
		}
	}
}
