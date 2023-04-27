
public class saveexit
{
public static void main(String[] args)
{
String rollNo= jTextField1.getText();
        String name= jTextField2.getText();
        String fatherName = jTextField3.getText();
        String motherName = jTextField4.getText();
        String gender=(String)jComboBox1.getSelectedItem();
        String contactNo= jTextField5.getText();
        String email= jTextField6.getText();
        String tenthUniversityName= jTextField7.getText();
        String tenthPercentage= jTextField8.getText();
        String tenthPassoutYear= jTextField9.getText();
        String twelveUniversityName= jTextField10.getText();
        String twelvePercentage= jTextField11.getText();
        String twelvePassoutYear =  jTextField12.getText();
        String graduationUniversityName= jTextField13.getText();
        String graduationPercentage = jTextField14.getText();
        String graduationPassoutYear= jTextField15.getText();
        String address= jTextField16.getText();
        String marks = "0";
        try 
        {
            Connection con = ConnectionProvider.getcon();
            Statement stmt = con.createStatement();
            String query=" Insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ; ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, rollNo);
            pst.setString(2, name);
            pst.setString(3, fatherName);
            pst.setString(4, motherName);
            pst.setString(5, gender);
            pst.setString(6, contactNo);
            pst.setString(7, email);
            pst.setString(8, tenthUniversityName);
            pst.setString(9, tenthPercentage);
            pst.setString(10,tenthPassoutYear);
            pst.setString(11,twelveUniversityName);
            pst.setString(12,twelvePercentage);
            pst.setString(13,twelvePassoutYear);
            pst.setString(14,graduationUniversityName);
            pst.setString(15, graduationPercentage);
            pst.setString(16, graduationPassoutYear);
            pst.setString(17, address);
            pst.setString(18, marks);
            pst.executeUpdate();
            setVisible(false);
            new instructionStudent(rollNo).setVisible(true);
              
                    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
}