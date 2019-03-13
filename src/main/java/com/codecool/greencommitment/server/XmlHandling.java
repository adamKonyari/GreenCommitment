package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlHandling {

    public void writeToXml(List<Measurement> measurementList) {

        try {


            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            String filename = "Measurements.xml";
            StreamResult result = new StreamResult(new File(filename));

            Element rootElement = document.createElement("measurements");
            document.appendChild(rootElement);

            for (Measurement measurement : measurementList) {
                Element tagElement = document.createElement("measurement");
                rootElement.appendChild(tagElement);

                Element time = document.createElement("time");
                time.appendChild(document.createTextNode(String.valueOf(measurement.getTime())));
                tagElement.appendChild(time);

                Element value = document.createElement("value");
                time.appendChild(document.createTextNode(String.valueOf(measurement.getValue())));
                tagElement.appendChild(value);

                Element type = document.createElement("type");
                time.appendChild(document.createTextNode(String.valueOf(measurement.getType())));
                tagElement.appendChild(type);
            }
            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
