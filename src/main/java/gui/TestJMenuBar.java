/**
 * Created by guillaume on 08/05/16.
 */
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class TestJMenuBar extends JFrame {

   public TestJMenuBar() {
      creerWidget();
      setTitle("TestJMenuBar");
      setSize(300,200);
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }



   private void creerWidget() {
      MenuSuperieurJMenuBar menuBar = new MenuSuperieurJMenuBar();
      setJMenuBar(menuBar);
   }


}
