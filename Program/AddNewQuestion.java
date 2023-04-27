import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.ConnectionProvider;
public class AddNewQuestion{
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","root");
            Statement stmt = con.createStatement();
            String query=" Insert into question (id,name,opt1,opt2,opt3,opt4,answer)values(?,?,?,?,?,?,?) ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, jTextField9.getText());
            pst.setString(2, jTextField1.getText());
            pst.setString(3, jTextField2.getText());
            pst.setString(4, jTextField3.getText());
            pst.setString(5, jTextField4.getText());
            pst.setString(6, jTextField5.getText());
            pst.setString(7, jTextField6.getText());
            pst.executeUpdate();
            JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,"Sucessfully  Inserted");
         setVisible(false);
         new AddNewQuestion().setVisible(true);
         

        }

        catch (Exception e) {
           JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,e);
        }    
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        adminHome.open=0;
        setVisible(false);
        
    }
}