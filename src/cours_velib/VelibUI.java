/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import velibXSD.Marker;

/**
 *
 * @author Simon
 */
public class VelibUI extends JFrame
{
    BikesStatus bikesStatus;
    JLabel ticketStatus;
    JLabel openStatus;
    JLabel connectedStatus;
    JLabel lastUpdated;
    
    private List<Marker> markers;
    VelibUI()
    {
        markers = HTTPRequester.getStationsList();
        initUI();
    }
    
    private void initUI()
    {
        initWindow();
        initWidgets();
    }
    
    private void initWindow()
    {
        setTitle("Velib Station");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initWidgets()
    {  
        initLeftPart();
        initRightPart();
        pack();
    }
    
    private void initLeftPart()
    {
        JPanel leftPart = new JPanel();
            JTable table = new JTable(new MarkersTableModel(markers));
            JScrollPane jsp = new JScrollPane(table);
        
        leftPart.setLayout(new BorderLayout());
        
        table.getSelectionModel().addListSelectionListener(selectionListener());
            
        leftPart.add(table.getTableHeader(), BorderLayout.NORTH);
        leftPart.add(jsp, BorderLayout.CENTER);
            
        getContentPane().add(leftPart, BorderLayout.CENTER);
    }
    
    private void initRightPart()
    {
        JPanel rightPart = new JPanel();
            JPanel infosPanel = new JPanel();
                bikesStatus = new BikesStatus();
                ticketStatus = new JLabel();
                openStatus = new JLabel();
                connectedStatus = new JLabel();
                lastUpdated = new JLabel();
            JPanel mapPanel = new JPanel();

        rightPart.setLayout(new BorderLayout());
        
        infosPanel.setLayout(new BoxLayout(infosPanel, BoxLayout.Y_AXIS));
        infosPanel.add(bikesStatus);
        infosPanel.add(ticketStatus);
        

        rightPart.add(infosPanel, BorderLayout.CENTER);
        rightPart.add(mapPanel, BorderLayout.SOUTH);

        getContentPane().add(rightPart, BorderLayout.EAST);
    }
    
    private ListSelectionListener selectionListener()
    {
        return new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int rowID = e.getFirstIndex();
                System.out.println((JTable)e.getSource());
            }
        };
    }
}
