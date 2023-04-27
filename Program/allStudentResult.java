import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.ConnectionProvider;
public class allStudentResult
{
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        adminHome.open=0;
        setVisible(false);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try
        {
        Connection con = ConnectionProvider.getcon();
        Statement st = con.createStatement();
        String query = "select * from student ; " ;
        ResultSet rs = st.executeQuery(query);
         while(rs.next())
            {
                String rollNo = rs.getString("rollNo");
                String name = rs.getString("name");
                String marks = rs.getString("marks");
                model.addRow(new Object[]{rollNo,name,marks});
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }                                        

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {                                        
        int marks;
        if(jTextField1.getText().equals(""))
        {
        marks = 0;
        }
        else
        {
        marks = Integer.parseInt(jTextField1.getText());
                 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try
        {
        Connection con = ConnectionProvider.getcon();
        Statement st = con.createStatement();
        String query = "select * from student where marks >= "+marks+"; " ;
        ResultSet rs = st.executeQuery(query);
         while(rs.next())
            {
                String rollNo = rs.getString("rollNo");
                String name = rs.getString("name");
                String mark = rs.getString("marks");
                model.addRow(new Object[]{rollNo,name,mark});
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(jf, e);
        }
        }  
    }
}