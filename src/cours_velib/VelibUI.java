/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours_velib;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Simon
 */
public class VelibUI extends JFrame
{
    VelibUI()
    {
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
        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true},
                {"Nicolas", "Van de Kampf", Color.black, true},
                {"Damien", "Cuthbert", Color.cyan, true},
                {"Corinne", "Valance", Color.blue, false},
                {"Emilie", "Schrödinger", Color.magenta, false},
                {"Delphine", "Duke", Color.yellow, false},
                {"Eric", "Trump", Color.pink, true}
        };
        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme"};
        
        
        JPanel leftPart = new JPanel();
            JTable table = new JTable(donnees, entetes);
            JScrollPane jsp = new JScrollPane(table);
        
        leftPart.setLayout(new BorderLayout());
            
        leftPart.add(table.getTableHeader(), BorderLayout.NORTH);
        leftPart.add(jsp, BorderLayout.CENTER);
            
        getContentPane().add(leftPart, BorderLayout.CENTER);
    }
    
    private void initRightPart()
    {
        JPanel rightPart = new JPanel();
            JPanel infosPanel = new JPanel();
            JPanel mapPanel = new JPanel();

        rightPart.setLayout(new BorderLayout());

        rightPart.add(infosPanel, BorderLayout.CENTER);
        rightPart.add(mapPanel, BorderLayout.SOUTH);

        getContentPane().add(rightPart, BorderLayout.EAST);
    }
}
