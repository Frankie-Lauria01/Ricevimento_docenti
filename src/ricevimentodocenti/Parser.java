package ricevimentodocenti;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List profs;

    public Parser() {
        profs = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Prof prof;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 2; i < nodelist.getLength()-2; i++) {
                element = (Element) nodelist.item(i);
                prof = getLibro(element);
                profs.add(prof);
            }
        }
        return profs;
    }

    private Prof getLibro(Element element) {
        Prof docentino;
        String s="";
        for(int i=0;i<5;i++){
            s+= element.getElementsByTagName("td");
            s+=";";
        }
        String[] splittata=s.split(";");
        String Id=splittata[0];
        String nome=splittata[1];
        String giorno=splittata[2];
        Integer ora=Integer.parseInt(splittata[3]);
        String note="";
        note=splittata[4];
        
        docentino = new Prof(Id,nome, giorno, ora, note);
        return docentino;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > 0) {
            value = nodelist.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
    
    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }
    
    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }
    
}