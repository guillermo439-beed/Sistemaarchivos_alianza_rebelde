package com.mycompany.sistema_archivos_alianza_rebelde;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Paso 2: análisis estructural con el parser DOM.
 * Carga TODO el árbol XML en memoria y lo recorre.
 */
public class LectorDOM {

    public static void leer(String ruta) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Se carga el árbol completo en memoria
        Document doc = builder.parse(new File(ruta));
        doc.getDocumentElement().normalize();

        System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

        NodeList naves = doc.getElementsByTagName("nave");
        System.out.println("Naves encontradas: " + naves.getLength());
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < naves.getLength(); i++) {
            Node nodo = naves.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element nave = (Element) nodo;
                String id = nave.getAttribute("id");
                String nombre = nave.getElementsByTagName("nombre").item(0).getTextContent().trim();
                String piloto = nave.getElementsByTagName("piloto").item(0).getTextContent().trim();

                System.out.printf("ID: %-6s | Nombre: %-34s | Piloto: %s%n", id, nombre, piloto);
            }
        }
    }
}
