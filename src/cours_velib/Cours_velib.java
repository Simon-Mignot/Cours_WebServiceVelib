/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.bind.JAXBException;
import velibXSD.Marker;



/**
 *
 * @author Simon
 */
public class Cours_velib
{

    public static void main(String[] args) throws JAXBException, FileNotFoundException
    {
        VelibUI ui = new VelibUI();
        
        List<Marker> markers = HTTPRequester.getStationsList();
        for(Marker marker : markers)
        {
            String tmp = marker.getName();
            String id, name;
            id = tmp.split("-")[0].trim();
            name = tmp.split("-")[1].trim();
            System.out.println(id +  " <===> " + name);
        }
    }
    
}
