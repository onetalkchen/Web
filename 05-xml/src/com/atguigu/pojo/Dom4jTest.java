package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-15 21:32
 */
public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/Book.xml");
        System.out.println(read);
    }
    @Test
    public void test2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/Book.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        List<Element> books = rootElement.elements("book");
        for (Element book:books){
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
        }
    }
}
