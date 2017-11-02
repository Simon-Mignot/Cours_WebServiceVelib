/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import javax.swing.JProgressBar;

/**
 *
 * @author Simon
 */
public class BikesStatus extends JProgressBar
{
    @Override
    public String getString()
    {
        int bikes = getValue();
        int places = getMaximum() - bikes;
        return bikes + " bikes - " + places + " places";
    }
}
