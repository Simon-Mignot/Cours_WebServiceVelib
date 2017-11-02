/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import velibXSD.Marker;

/**
 *
 * @author Simon
 */
public class MarkersTableModel extends AbstractTableModel
{
    //TODO: find better solution
    static final private int COLUMN_ID = 0;
    static final private int COLUMN_NAME = 1;
    static final private int COLUMN_FULLNAME = -1;
    static final private int COLUMN_STATIONID = -2;
    static final private int COLUMN_ADDRESS = 2;
    static final private int COLUMN_FULLADDRESS = -3;
    static final private int COLUMN_LAT = -4;
    static final private int COLUMN_LNG = -5;
    static final private int COLUMN_OPEN = 3;
    static final private int COLUMN_BONUS = -6;
    
    
    private List<Marker> markers;

    public MarkersTableModel(List<Marker> markers)
    {
        this.markers = markers;
    }
    
    @Override
    public int getRowCount()
    {
        return markers.size();
    }
    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Marker current = markers.get(rowIndex);
        switch(columnIndex)
        {
            case COLUMN_ID: return current.getName().split("-")[0].trim();
            case COLUMN_NAME: return current.getName().split("-")[1].trim();
            case COLUMN_FULLNAME: return current.getName();
            case COLUMN_ADDRESS: return current.getAddress();
            case COLUMN_FULLADDRESS: return current.getFullAddress();
            case COLUMN_STATIONID: return current.getNumber();
            case COLUMN_LAT: return current.getLat();
            case COLUMN_LNG: return current.getLng();
            case COLUMN_OPEN: return (current.getOpen() != 0 ? "Open" : "Closed");
            case COLUMN_BONUS: return (current.getBonus() != 0);
        }
        return "Not Implemented.";
    }
    
    @Override
    public String getColumnName(int col)
    {
        String[] tmp = {"#", "Name", "Address", "Status"};
        if(col < tmp.length)
            return tmp[col];
        return "Not Implemented.";
    }
    
}
