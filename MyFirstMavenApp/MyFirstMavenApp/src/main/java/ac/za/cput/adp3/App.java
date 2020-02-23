package ac.za.cput.adp3;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    { EmployeeGui app = new EmployeeGui();
        app.setVisible (true);
        app.setSize(650, 600);
        app.setLocation(300, 100);
        app.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

    }




}
