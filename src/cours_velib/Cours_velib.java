/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import velibXSD.Carto;

/**
 *
 * @author Simon
 */
public class Cours_velib
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws javax.xml.bind.JAXBException
     */
    public static void main(String[] args) throws FileNotFoundException, JAXBException
    {
              JAXBContext jc=JAXBContext.newInstance("velibXSD");
Unmarshaller u = jc.createUnmarshaller();
Marshaller a= jc.createMarshaller();


Carto Station = (Carto)u.unmarshal(new FileInputStream("C:\\Users\\Sephi\\Documents\\cours_epsi\\Cours I4\\Web_Service\\VelibApp\\cours_webservicevelib\\src\\cours_velib\\velibDataXML.xml"));
System.out.println("Adresse de la station :" +Station.getMarkers().getMarker().get(0).getName());
System.out.println("Adresse de la station :" +Station.getMarkers());

    }
    
}
