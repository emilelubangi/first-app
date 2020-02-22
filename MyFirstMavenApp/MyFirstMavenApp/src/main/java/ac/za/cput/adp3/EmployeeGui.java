package ac.za.cput.adp3;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class  EmployeeGui extends JFrame {

    JTextArea EmpTextArea = new JTextArea();
    JLabel empId = new JLabel("Id");
    JTextField empIdText = new JTextField(10);
    JLabel empFirstname = new JLabel("First Name");
    JTextField empFirstnameText = new JTextField(10);
    JLabel empSurname = new JLabel("Surname");
    JTextField empSurnameText = new JTextField(10);

    JButton addButton = new JButton("Add");
    JButton deleteButton = new JButton("Delete");
    JButton displayAllButton = new JButton("Display");
    JButton exitButton = new JButton("Exit");

    private LinkedList<Employee> empList = new LinkedList<>();


    public EmployeeGui() {
        JPanel flow1Panel = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        JPanel flow2Panel = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        JPanel gripPanel = new JPanel (new GridLayout(2,1));
        EmpTextArea.setEditable(false);

        flow1Panel.add(empId);
        flow1Panel.add(empIdText);
        flow1Panel.add(empFirstname);
        flow1Panel.add(empFirstnameText);
        flow1Panel.add(empSurname);
        flow1Panel.add(empSurnameText);

        flow2Panel.add(addButton);
        flow2Panel.add(deleteButton);
        flow2Panel.add(displayAllButton);
        flow2Panel.add(exitButton);
        gripPanel.add(flow1Panel);
        gripPanel.add(flow2Panel);
        add(EmpTextArea, BorderLayout.CENTER);
        add(gripPanel, BorderLayout.SOUTH);
        addButton.addActionListener(event ->addEmployee ());
        displayAllButton.addActionListener(event -> displayAllEmployee());
        exitButton.addActionListener(event -> exit());
        deleteButton.addActionListener(event -> deleteEmployee());


    }

    private void exit() {
        System.exit(0);
    }

    private void deleteEmployee() {
        if ( isEmpIdInLinkedList(empIdText.getText())==false)
        {
            JOptionPane.showMessageDialog(null, "Employee does not exist");
        }
        else{
            for(int e = 0; e< empList.size(); e++ )
            {
                String currId = empList.get(e).getEmployee_id();
                if ( currId.compareToIgnoreCase(empIdText.getText())==0)
                {
                    empList.remove(e);
                }
            }

            displayAllEmployee();
            empIdText.setText("");
            empFirstnameText.setText("");
            empSurnameText.setText("");
        }

    }

    private void displayAllEmployee() {
        EmpTextArea.setText("");
        for(Employee emp: empList )
        {
            EmpTextArea.append(emp +"\n");
        }
    }
    private boolean isEmpIdInLinkedList(String idStr){
        boolean inList =false;
        for(Employee emp: empList )
        {
            if ( emp.getEmployee_id().compareToIgnoreCase(idStr)==0){
                inList= true;
            }
        }
        return inList;
    }
    private void addEmployee() {

        if ( isEmpIdInLinkedList(empIdText.getText())==true)
        {
            JOptionPane.showMessageDialog(null, "Employee already exist");
        }
        else{
            empList.add(new Employee(empIdText.getText(), empFirstnameText.getText(), empSurnameText.getText()  ));

            displayAllEmployee();
            empIdText.setText("");
            empFirstnameText.setText("");
            empSurnameText.setText("");

        }


    }



}

