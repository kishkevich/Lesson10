import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadFromXML {
    Hospital hospital;
    File file = new File("C:\\Users\\hp\\Desktop\\ListPatient");

    public ReadFromXML(Hospital hospital) {
        this.hospital = hospital;
    }

    public void read() {
        String surname = null, name = null,  health = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Node listPatient = doc.getDocumentElement();
            NodeList nodeList = listPatient.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node patient = nodeList.item(i);
                if (patient.getNodeType() != Node.TEXT_NODE) {
                    NodeList patientProps = patient.getChildNodes();
                    for (int j = 0; j < patientProps.getLength(); j++) {
                        Node item = patientProps.item(j);
                        if (item.getNodeType() != Node.TEXT_NODE) {
                            if (item.getNodeName().equals("surname"))
                                surname = item.getChildNodes().item(0).getTextContent();
                            else if (item.getNodeName().equals("name"))
                                name = item.getChildNodes().item(0).getTextContent();
                            else if (item.getNodeName().equals("health"))
                                health = item.getChildNodes().item(0).getTextContent();
                        }
                    }
                    hospital.add(new Patient(surname, name, health));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}



