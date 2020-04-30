/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author RyanHannam
 */

public class solarWindow extends JFrame implements ActionListener
{
    private JButton btnEnter, btnClear, btnExit;
    private JTextField txtJobDisplay, txtTechSelect, txtName, txtNum, txtInstallAdd, txtBatt, txtStart, txtEnd, txtWattH;
    private JTextArea txtDisplay;
    private JLabel lblJobDisplay, lblTechSelect, lblName, lblNum, lblInstallAdd, lblInstallType, lblBatt, lblSolTrack, lblStart, lblEnd, lblStudent, lblWattH;
    private String installInfo[];
    private int a = 0;
    private int wattH, batt;
    private String strBatt = "";
    private JComboBox cmbInstallType, cmbTrack;
    private JPanel pnlMain, pnlEntry, pnlDisplay, pnlButton;
    
    public solarWindow()
    {
        super("CQ Solar Job Listings");
        
        btnEnter = new JButton("Enter");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        
        txtDisplay = new JTextArea();
        txtJobDisplay = new JTextField(20);
        txtTechSelect = new JTextField(20);
        txtName = new JTextField(20);
        txtNum = new JTextField(20);
        txtBatt = new JTextField(20);
        txtStart = new JTextField(20);
        txtEnd = new JTextField(20);
        txtWattH = new JTextField(20);
        txtInstallAdd = new JTextField(20);
        
        lblJobDisplay = new JLabel("Job Listings:");
        lblTechSelect= new JLabel("Select Technician");
        lblName = new JLabel("Technician Name:");
        lblNum = new JLabel("Technician Phone:");
        lblInstallAdd = new JLabel("Installation Address:");
        lblBatt = new JLabel("Battery Type:");
        lblSolTrack = new JLabel("Solar Tracking Type:");
        lblStart = new JLabel("Start Date:");
        lblEnd = new JLabel("End Date");
        lblStudent = new JLabel("Ryan Hannam (12076390)");
        lblWattH = new JLabel("Watts per Hour:");
        lblInstallType = new JLabel("Installation Type:");
        
        cmbInstallType = new JComboBox();
        cmbTrack = new JComboBox();
        cmbInstallType.addItem("Off Grid");
        cmbInstallType.addItem("On Grid");
        cmbTrack.addItem("Single Track");
        cmbTrack.addItem("Dual Track");
        cmbTrack.addItem("Stationary");
        
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        pnlEntry = new JPanel();
        pnlEntry.setLayout(new GridLayout(9,2));
        pnlDisplay = new JPanel();
        pnlDisplay.setLayout(new FlowLayout());
        pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout());
        
        this.setLayout(new BorderLayout());
        
        pnlButton.add(btnEnter);
        pnlButton.add(btnClear);
        pnlButton.add(btnExit);
        pnlButton.add(lblStudent);
        this.add(pnlButton, BorderLayout.SOUTH);
        
        pnlEntry.add(lblName);
        pnlEntry.add(txtName);
        pnlEntry.add(lblNum);
        pnlEntry.add(txtNum);
        pnlEntry.add(lblInstallAdd);
        pnlEntry.add(txtInstallAdd);
        pnlEntry.add(lblInstallType);
        pnlEntry.add(cmbInstallType);
        pnlEntry.add(lblSolTrack);
        pnlEntry.add(cmbTrack);
        pnlEntry.add(lblBatt);
        pnlEntry.add(txtBatt);
        pnlEntry.add(lblWattH);
        pnlEntry.add(txtWattH);
        pnlEntry.add(lblStart);
        pnlEntry.add(txtStart);
        pnlEntry.add(lblEnd);
        pnlEntry.add(txtEnd);
       
        
        pnlDisplay.add(txtDisplay);
        
        this.add(pnlEntry, BorderLayout.WEST);
        this.add(pnlDisplay, BorderLayout.CENTER);
       
//        txtDisplay.setText("Testing");
        
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        btnEnter.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource()==btnClear)
        {
          txtName.setText("");
          txtNum.setText("");
          txtBatt. setText("");
          txtStart.setText("");
          txtEnd.setText("");
          txtDisplay.setText("");
          txtWattH.setText("");
          cmbTrack.setSelectedItem(0);
          cmbInstallType.setSelectedItem(0);
          txtInstallAdd.setText("");
        }
      if (e.getSource()==btnEnter)
        {
            addEmployee();
        }
      if (e.getSource()==btnExit)
        {
            System.exit(0);
        }  
    }
    
    private void addEmployee()
    {
        try
        {
            String AH=txtBatt.getText();
            batt = Integer.parseInt(AH);
        }
        catch(NumberFormatException x)
        {
            JOptionPane.showMessageDialog(null, "Please input a numeric value for amp hours", "Error", JOptionPane.ERROR_MESSAGE);
            txtWattH.setText("");
        }
        finally
        {
            if(cmbInstallType.getSelectedIndex() == 1)
            {
                strBatt = "None/On Grid";
            }
            else
            {
                if(batt<50||batt>200)
                {
                  JOptionPane.showMessageDialog(null, "Please input a value between 50Ah and 200Ah", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                strBatt = txtBatt.getText();
            } 
        }
        try
        {
            String WH=txtWattH.getText();
            wattH = Integer.parseInt(WH);
        }
        catch(NumberFormatException x)
        {
            JOptionPane.showMessageDialog(null, "Please input a numeric value for watts per hour", "Error", JOptionPane.ERROR_MESSAGE);
            txtWattH.setText("");
        }
        finally
        {
            if(wattH<3500||wattH>10000)
            {
              JOptionPane.showMessageDialog(null, "Please input a value between 3500Mh and 10000Mh", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                String strFormat = "";
                String name = txtName.getText();
                String num = txtNum.getText();
                String add = txtInstallAdd.getText();
                String track = (String)cmbTrack.getSelectedItem();
                String type = (String)cmbInstallType.getSelectedItem();
                String strWh = txtWattH.getText();
                String dateS = txtStart.getText();
                String dateE = txtEnd.getText();
                strFormat = "Technician Name: "+name+"\nTechnician Phone: "+num+"\nInstallation Address: "+add+"\nInstallation Type: "+type+"\nTracking Type: "+track+"\nBattery Type: "+strBatt+"\nWatts per Hour: "+strWh+"\nStart Date: "+dateS+"\nEnd Date:"+dateE;
                txtDisplay.setText(strFormat);
                installInfo[a]=strFormat;
                a++;
            }
        } 
    }
    
    
}
