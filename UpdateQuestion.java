import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.ConnectionProvider;
public class UpdateQuestion{
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
    jTextField1.setEditable(true);
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
          try {
           
            Connection con = ConnectionProvider.getcon();
            String query="update question set name = ?, opt1 = ? ,opt2 = ?, opt3 = ?, opt4 = ?, answer = ? where id = ?  ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField5.getText());
            pst.setString(5, jTextField6.getText());
            pst.setString(6, jTextField7.getText());
            pst.setString(7, jTextField1.getText());
            pst.executeUpdate();
            JFrame jf  = new JFrame();
         jf.setAlwaysOnTop(true);
         JOptionPane.showMessageDialog(jf,"Sucessfully  Updated");
         setVisible(false);
         new UpdateQuestion().setVisible(true);
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