import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.ConnectionProvider;

public class StudentRecord
{
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   try
   {
   Connection con = ConnectionProvider.getcon();
   String query="update student set name = ? ,fatherName = ?, motherName = ?, gender = ?, contactNo = ?, email = ?, tenthUniversityName = ?, tenthPercentage = ?, tenthPassoutYear = ?, twelveUniversityName = ?, twelvePercentage = ?, twelvePassoutYear = ?, graduationUniversityName = ?, graduationPercentage = ?, graduationPassoutYear = ?, address = ? where rollNo = ?  ";
   PreparedStatement pst = con.prepareStatement(query);    
    pst.setString(1, jTextField2.getText());
    pst.setString(2, jTextField5.getText());
    pst.setString(3, jTextField6.getText());
    pst.setString(4, jTextField19.getText());
    pst.setString(5, jTextField7.getText());
    pst.setString(6, jTextField8.getText());   
    pst.setString(7, jTextField9.getText());
    pst.setString(8, jTextField10.getText());
    pst.setString(9, jTextField11.getText());
    pst.setString(10, jTextField12.getText());
    pst.setString(11, jTextField13.getText());
    pst.setString(12, jTextField14.getText());
    pst.setString(13, jTextField15.getText());
    pst.setString(14, jTextField16.getText());
    pst.setString(15, jTextField17.getText());
    pst.setString(16, jTextField18.getText());    
    pst.setString(17, jTextField1.getText());
    pst.executeUpdate();
    JFrame jf  = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,"Sucessfully  Updated");
    setVisible(false);
    new Student_record().setVisible(true);
   }
   catch(Exception e)
   {
      JFrame jf  = new JFrame();
      jf.setAlwaysOnTop(true);
      JOptionPane.showMessageDialog(jf,e);
   }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     String rollNo  = jTextField1.getText();
        try {
           
         Connection con = ConnectionProvider.getcon();
         String query="delete from student where rollNo = ?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1, rollNo);
         pst.executeUpdate();
         JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,"Sucessfully  Deleted");
         setVisible(false);
         new Student_record().setVisible(true);

        }

        catch (Exception e) {
           JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,e);
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         try
    {
    Connection con = ConnectionProvider.getcon();
    Statement st = con.createStatement();
    String RollNo = jTextField1.getText();
    String query = " select * from  student where rollNo = "+ RollNo + ";" ;
    ResultSet rs = st.executeQuery(query);
    if(rs.next())
       
    {
    String name = rs.getString("name");
    String fatherName = rs.getString("fatherName");
    String motherName = rs.getString("motherName");
    String gender = rs.getString("gender");
    String contactNo = rs.getString("contactNo");
    String email  = rs.getString("email");
    String tenthUniversityName = rs.getString("tenthUniversityName");
    String tenthPercentage = rs.getString("tenthPercentage");
    String tenthPassoutYear = rs.getString("tenthPassoutYear");
    String twelveUniversityName = rs.getString("twelveUniversityName");
    String twelvePercentage = rs.getString("twelvePercentage");
    String twelvePassoutYear = rs.getString("twelvePassoutYear");
    String graduationUniversityName = rs.getString("graduationUniversityName");
    String graduationPercentage = rs.getString("graduationPercentage");
    String graduationPassoutYear = rs.getString("graduationPassoutYear");
    String address = rs.getString("address");

    jTextField2.setText(name);
    jTextField5.setText(fatherName);
    jTextField6.setText(motherName);
    jTextField19.setText(gender);
    jTextField7.setText(contactNo);
    jTextField8.setText(email);
    jTextField9.setText(tenthUniversityName);
    jTextField10.setText(tenthPercentage);
    jTextField11.setText(tenthPassoutYear);
    jTextField12.setText(twelveUniversityName);
    jTextField13.setText(twelvePercentage);
    jTextField14.setText(twelvePassoutYear );
    jTextField15.setText(graduationUniversityName);
    jTextField16.setText(graduationPercentage);
    jTextField17.setText(graduationPassoutYear);
    jTextField18.setText(address);
  
    } 
    else
    {
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf," RollNo does not Exist");
    }     
    }
    catch(Exception e)
    {
     JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,e);
    }    
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        setVisible(false);
        new Record_home().setVisible(true);

    }
}