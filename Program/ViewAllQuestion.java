import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.ConnectionProvider;

public class AllQuestion extends javax.swing.JFrame {

    /**
     * Creates new form AllQuestion
     */
    public AllQuestion() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try
        {
          Connection con = ConnectionProvider.getcon();
          Statement stmt = con.createStatement();
            String query="Select * from question;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String opt1 = rs.getString("opt1");
                String opt2 = rs.getString("opt2");
                String opt3 = rs.getString("opt3");
                String opt4 = rs.getString("opt4");
                String answer = rs.getString("answer");    
                model.addRow(new Object[]{id,name,opt1,opt2,opt3,opt4,answer});
            }
          
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);
        }    
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        adminHome.open=0;
        setVisible(false);
    }
}