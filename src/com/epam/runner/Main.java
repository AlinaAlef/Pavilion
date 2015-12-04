package com.epam.runner;

import com.epam.utility.XSLT;
import org.xml.sax.SAXException;
import com.epam.entity.Pavilion;
import com.epam.parsers.MyDOMParser;
import com.epam.parsers.MySAXParser;
import com.epam.parsers.MyStAXParser;
import com.epam.utility.FileReader;
import com.epam.utility.XMLValidationViaXSD;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
/**
 * 
 * @author Alina
 *
 */
public class Main {
    private static final String XML_FILE_PATH = "Pavilion.xml";
    private static final String XSD_FILE_PATH = "Schema.xsd";
    private static final String StAX_XML_FILE_PATH = "XMLViaStAX.xml";
    static Logger log = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File pavilionXmlFile = new File(XML_FILE_PATH);
        String xmlAsString = FileReader.readFile(XML_FILE_PATH);

        boolean isValid = XMLValidationViaXSD.validate(XML_FILE_PATH, XSD_FILE_PATH);
        log.info("XML is validly? " + isValid);


        Pavilion pavilionViaDOM = MyDOMParser.parse(pavilionXmlFile);
        log.info("pavilionViaDOM: " + pavilionViaDOM);

        Pavilion pavilionViaSAXParser = MySAXParser.parse(pavilionXmlFile);
        log.info("pavilionViaSAXParser: " + pavilionViaSAXParser);

        Pavilion pavilionViaStAX = MyStAXParser.parse(xmlAsString);
        log.info("pavilionViaStAX: " + pavilionViaStAX);

        MyStAXParser.createXML(StAX_XML_FILE_PATH, pavilionViaStAX);
        log.info("Generated XML file via StAX. Is it correct? " + XMLValidationViaXSD.validate(
                StAX_XML_FILE_PATH, XSD_FILE_PATH));

        XSLT.convert();
    }
}
