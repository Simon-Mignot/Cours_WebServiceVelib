/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import velibXSD.Carto;
import velibXSD.Marker;

/**
 *
 * @author Simon
 */
public class HTTPRequester
{
    static public List<Marker> getStationsList()
    {
        try
        {
            JAXBContext jc = JAXBContext.newInstance("velibXSD");
            Unmarshaller u = jc.createUnmarshaller();
            
            URL url = getURL("http://www.velib.paris/service/carto");
            return ((Carto)u.unmarshal(url.openStream())).getMarkers().getMarker();
        }
        catch (IOException ex)
        {
            Logger.getLogger(HTTPRequester.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (JAXBException ex)
        {
            Logger.getLogger(HTTPRequester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    static public void getStationInfos(int id)
    {
        URL url = getURL("http://www.velib.paris/service/stationdetails/" + Integer.toString(id));
        String xml = readInputStream(url);
    }
    
    static private String readInputStream(URL url)
    {
        InputStream is = null;
        try
        {
            is = url.openStream();
        }
        catch (IOException ex)
        {
            Logger.getLogger(HTTPRequester.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
        String result = "";
        int current = 0;
        while(current != -1)
        {
            try
            {
                current = is.read();
                if(current != -1)
                    result += (char)current;
            } catch (IOException ex)
            {
                Logger.getLogger(Cours_velib.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    static private URL getURL(String url)
    {
        try
        {
            return new URL(url);
        }
        catch (MalformedURLException ex)
        {
            Logger.getLogger(HTTPRequester.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
