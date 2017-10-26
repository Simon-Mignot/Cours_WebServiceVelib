/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sun.misc.IOUtils;

/**
 *
 * @author Simon
 */
public class Cours_velib
{

    static private String readInputStream(InputStream is)
    {
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        VelibUI ui = new VelibUI();
    }
    
    
    static public void test()
    {
        try
        {
            URL url = new URL("http://www.velib.paris.fr/service/carto");
            InputStream is = url.openStream();
            
            System.out.println(readInputStream(is));
        } catch (MalformedURLException ex)
        {
            Logger.getLogger(Cours_velib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Cours_velib.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
