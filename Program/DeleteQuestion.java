import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.ConnectionProvider;
public class DeleteQuestion
{
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            adminHome.open=0;
            setVisible(false);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    try
    {
    Connection con = ConnectionProvider.getcon();
    Statement st = con.createStatement();
    String Id = jTextField1.getText();
    String query = " select * from  question where id = "+ Id + ";" ;
    ResultSet rs = st.executeQuery(query);
    if(rs.next())
    {
    String name = rs.getString("name");
    String opt1 = rs.getString("opt1");
    String opt2 = rs.getString("opt2");
    String opt3 = rs.getString("opt3");
    String opt4 = rs.getString("opt4");
    String answer = rs.getString("answer");
    jTextField2.setText(name);
    jTextField3.setText(opt1);
    jTextField4.setText(opt2);
    jTextField5.setText(opt3);
    jTextField6.setText(opt4);
    jTextField7.setText(answer);
    jTextField1.setEditable(false);
    
    } 
    else
    {
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,"Question ID does not Exist");
    }    
    }
    catch(Exception e)
    {
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,e);
    } 
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String id  = jTextField1.getText();
        try {
           
         Connection con = ConnectionProvider.getcon();
         String query="delete from question where id = ?";
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1, id);
         pst.executeUpdate();
         JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,"Sucessfully  Deleted");
         setVisible(false);
         new deleteQuestion().setVisible(true);
         

        }

        catch (Exception e) {
           JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,e);
        }  
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      jTextField1.setText("");
      jTextField2.setText("");
      jTextField3.setText("");
      jTextField4.setText("");
      jTextField5.setText("");
      jTextField6.setText("");
      jTextField7.setText("");
      jTextField1.setEditable(true);
    }
}