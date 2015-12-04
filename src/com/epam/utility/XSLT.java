package com.epam.utility;

/**
 * Created by alef on 20.11.15.
 */
import javax.xml.transform.*;
import java.net.*;
import java.io.*;

public class XSLT {
    public static void convert() {
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer =
                    tFactory.newTransformer
                            (new javax.xml.transform.stream.StreamSource
                                    ("Pavilion.xsl"));

            transformer.transform
                    (new javax.xml.transform.stream.StreamSource
                                    ("Pavilion.xml"),
                            new javax.xml.transform.stream.StreamResult
                                    ( new FileOutputStream("Pavilion.html")));
        }
        catch (Exception e) {
            e.printStackTrace( );
        }
    }
}
