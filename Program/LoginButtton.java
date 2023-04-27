import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import project.ConnectionProvider;

public class Loginbutton{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try 
        {  
            Connection con = ConnectionProvider.getcon();
            String query=" select * from Admin_login where AdminID = ? and password = ? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, jPasswordField1.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
            JOptionPane.showMessageDialog(null,"Login Success");
            setVisible(false);
            new adminHome().setVisible(true);
            }
            else
            {
            ImageIcon icon = new ImageIcon("Incorrect password.JPEG");
            JOptionPane.showMessageDialog(null ,"<html><b style=\"color: red; font-size: 10px\">Incorrect <br> Username or Password </b></html>","Show",JOptionPane.INFORMATION_MESSAGE,icon);
            }    
        }
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null,e);
        }   
    }
}