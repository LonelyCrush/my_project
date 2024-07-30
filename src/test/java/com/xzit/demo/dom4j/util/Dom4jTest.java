package com.xzit.demo.dom4j.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@Component
public class Dom4jTest {

    @Test
    public void testParseXml() throws DocumentException {
        // 1.创建解析器对象
        SAXReader saxReader = new SAXReader();

        // 2.使用解析器读取XML文档，生成Document对象
        Document document = saxReader.read(new File("src/test/java/com/xzit/demo/dom4j/resource/book.xml"));
        System.out.println("xml文件的位置：" + document.getName());

        // 3.根据Document对象解析
        Element rootElement = document.getRootElement();
        System.out.println("<" + rootElement.getName() + ">");

        // 4.获取bookshelf下的所有子元素
        List<Element> firstElementList = rootElement.elements();

        // 5.遍历循环bookshelf下的所有子元素
        for (Element firstElement : firstElementList) {
            System.out.print("    <" + firstElement.getName() + " ");
            Iterator<Attribute> iterator = firstElement.attributeIterator();
            while (iterator.hasNext()) {
                Attribute attribute = iterator.next();
                System.out.print(attribute.getName() + "=" + attribute.getValue() + " ");
            }
            System.out.println(">");

            // 6.获取element元素下的所有子元素
            List<Element> secondElementList = firstElement.elements();

            // 7.遍历循环book元素下的子元素
            for (Element secondElement : secondElementList) {
                System.out.println("        <" + secondElement.getName() + ">" + secondElement.getText() + "</" + secondElement.getName() + ">");
            }
            System.out.println("    </" + firstElement.getName() + ">");
        }
        System.out.println("</" + rootElement.getName() + ">");

        // 8.其他用法：获取bookshelf下的book子元素（获取第一个）
        Element book = rootElement.element("book");
        System.out.println();
        System.out.println("标签book：" + book.getName());
        System.out.println("book的id属性值：" + book.attributeValue("id"));

        // 9.获取book元素下的author元素文本值
        String author = book.elementText("author");
        System.out.println("author文本值：" + author);
    }
}
