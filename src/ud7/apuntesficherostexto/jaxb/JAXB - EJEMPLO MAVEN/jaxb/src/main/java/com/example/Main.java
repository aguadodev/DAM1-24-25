package com.example;

import java.io.File;
import java.io.StringWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {
    
    public static void main(String[] args) {
        // Crear un objeto Empleado
        Empleado empleado = new Empleado(101, "Juan Pérez", "Desarrollador", 45000.0);
        
        // Marshalling: Convertir objeto Java a XML
        marshallEjemplo(empleado);
        
        // Unmarshalling: Convertir XML a objeto Java
        Empleado empleadoLeido = unmarshallEjemplo("empleado.xml");
        System.out.println("\nEmpleado leído desde XML:");
        System.out.println(empleadoLeido);
    }
    
    public static void marshallEjemplo(Empleado empleado) {
        try {
            // Crear contexto JAXB
            JAXBContext context = JAXBContext.newInstance(Empleado.class);
            
            // Crear marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Marshal a archivo
            marshaller.marshal(empleado, new File("empleado.xml"));
            System.out.println("Objeto convertido a XML y guardado en empleado.xml");
            
            // Marshal a String para mostrar por consola
            StringWriter sw = new StringWriter();
            marshaller.marshal(empleado, sw);
            System.out.println("\nContenido XML generado:");
            System.out.println(sw.toString());
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public static Empleado unmarshallEjemplo(String archivo) {
        try {
            // Crear contexto JAXB
            JAXBContext context = JAXBContext.newInstance(Empleado.class);
            
            // Crear unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            // Unmarshal desde archivo
            return (Empleado) unmarshaller.unmarshal(new File(archivo));
            
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}