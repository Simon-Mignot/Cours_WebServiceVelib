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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class HTTPRequester
{
    static private String readInputStream(URL url)
    {
        InputStream is;
        try
        {
            is = url.openStream();
        }
        catch (IOException ex)
        {
            Logger.getLogger(HTTPRequester.class.getName()).log(Level.SEVERE, null, ex);
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
    
    static public void getStationsList()
    {
        //TODO: return array of Station
    }
    
    static public void getStationInfos()
    {
        URL url = getURL("http://www.velib.paris/service/carto");
        
        String xml = readInputStream(url);
        
    }
    
}
