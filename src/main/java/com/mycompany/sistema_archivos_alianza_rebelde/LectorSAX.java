package com.mycompany.sistema_archivos_alianza_rebelde;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Paso 3: auditoría ligera con SAX.
 * Lectura secuencial por eventos: no se construye ningún árbol en memoria,
 * por lo que sirve para ficheros masivos.
 */
public class LectorSAX {

    /** Manejador personalizado que intercepta los eventos del XML. */
    static class ManejadorNaves extends DefaultHandler {

        private String claseActual;
        private boolean dentroDeNombre = false;
        // SAX puede trocear el texto en varias llamadas a characters(): se acumula
        private final StringBuilder texto = new StringBuilder();

        @Override
        public void startDocument() {
            System.out.println("[SAX] Inicio de la lectura secuencial");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            if (qName.equals("nave")) {
                claseActual = atts.getValue("clase");  
            } else if (qName.equals("nombre")) {
                dentroDeNombre = true;
                texto.setLength(0);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (dentroDeNombre) {
                texto.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("nombre")) {
                dentroDeNombre = false;
                System.out.printf("Clase: %-10s | Nombre: %s%n", claseActual, texto.toString().trim());
            }
        }

        @Override
        public void endDocument() {
            System.out.println("[SAX] Fin de la lectura secuencial");
        }
    }

    public static void leer(String ruta) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(ruta), new ManejadorNaves());
    }
}
