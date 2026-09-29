package com.mycompany.sistema_archivos_alianza_rebelde;

/**
 * Sistema de Archivos de la Alianza Rebelde.
 * Ejecuta los tres procesos: DOM, SAX y Binding (JAXB).
 */
public class Sistema_Archivos_Alianza_rebelde {

    private static final String IMPERIO = "imperio.xml";
    private static final String REBELDE = "rebelde.xml";

    public static void main(String[] args) {
        try {
            System.out.println("========== PASO 2: PARSER DOM ==========");
            LectorDOM.leer(IMPERIO);
        } catch (Exception e) {
            System.err.println("Error al parsear con DOM: " + e.getMessage());
        }

        try {
            System.out.println("\n========== PASO 3: PARSER SAX ==========");
            LectorSAX.leer(IMPERIO);
        } catch (Exception e) {
            System.err.println("Error al parsear con SAX: " + e.getMessage());
        }

        try {
            System.out.println("\n========== PASO 4: BINDING (JAXB) ==========");
            GeneradorInformes.generar(REBELDE);
        } catch (Exception e) {
            System.err.println("Error en el Binding (JAXB): " + e.getMessage());
        }
    }
}
