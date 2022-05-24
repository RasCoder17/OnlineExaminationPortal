import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.ConnectionProvider;

public class AdminRecord{
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
try
    {
    Connection con = ConnectionProvider.getcon();
    Statement st = con.createStatement();
    String AdminID = jTextField1.getText();
    String query = " select * from  Admin where AdminID = "+ AdminID + ";" ;
    ResultSet rs = st.executeQuery(query);
    if(rs.next())
       //| AdminID | FirstName | SurName | PostCode | Gender | DOB        | Email           | mobile
    {
 
    String FirstName = rs.getString("FirstName");
    String SurName = rs.getString("SurName");
    String PostCode = rs.getString("PostCode");
    String Gender = rs.getString("Gender");
    String DOB  = rs.getString("DOB");
    String Email = rs.getString("Email");
    String mobile = rs.getString("mobile");
    jTextField2.setText(FirstName);
    jTextField3.setText(SurName);
    jTextField4.setText(PostCode);
    jTextField11.setText(Gender);
    jTextField10.setText(DOB);
    jTextField7.setText(Email);
    jTextField8.setText(mobile);
    } 
    else
    {
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf," AdminID does not Exist");
    }     
    }
    catch(Exception e)
    {
     JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,e);
    }           
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
               try {
              Connection con = ConnectionProvider.getcon();
              //| AdminID | FirstName | SurName | PostCode | Gender | DOB        | Email           | mobile
            String query="update admin set FirstName = ? ,SurName = ?, PostCode  = ?, Gender = ?, DOB = ?, Email = ?,  mobile = ? where AdminID = ?  ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField11.getText());
            pst.setString(5, jTextField10.getText());
            pst.setString(6, jTextField7.getText());
            pst.setString(7, jTextField8.getText());
            pst.setString(8, jTextField1.getText());
            pst.executeUpdate();
            JFrame jf  = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"Sucessfully  Updated");
            setVisible(false);
             new Admin_record().setVisible(true);
        }

        catch (Exception e) {
           JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,e);
        }  
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            String AdminID  = jTextField1.getText();
        try {
           
         Connection con = ConnectionProvider.getcon();
         String query="delete from Admin where AdminID = ?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1, AdminID);
         pst.executeUpdate();
         JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,"Sucessfully  Deleted");
         setVisible(false);
         new Admin_record().setVisible(true);

        }

        catch (Exception e) {
           JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,e);
        } 
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    setVisible(false);
    new Record_home().setVisible(true);
     
    }
}