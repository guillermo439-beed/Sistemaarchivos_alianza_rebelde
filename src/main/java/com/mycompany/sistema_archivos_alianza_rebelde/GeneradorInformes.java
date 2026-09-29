package com.mycompany.sistema_archivos_alianza_rebelde;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;

/**
 * Paso 4: Marshalling con JAXB (objeto Java -> XML).
 */
public class GeneradorInformes {

    public static void generar(String ruta) throws Exception {
        Personaje luke = new Personaje("Luke Skywalker", "Comandante / Caballero Jedi");

        JAXBContext contexto = JAXBContext.newInstance(Personaje.class);
        Marshaller marshaller = contexto.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // XML indentado
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        // Exporta al fichero rebelde.xml
        marshaller.marshal(luke, new File(ruta));
        System.out.println("Personaje exportado: " + luke);
        System.out.println("Archivo generado: " + new File(ruta).getAbsolutePath());

        System.out.println("--- Contenido de " + ruta + " ---");
        marshaller.marshal(luke, System.out);
    }
}
