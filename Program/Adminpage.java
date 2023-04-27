public class adminpage{
private void SignInActionPerformed(java.awt.event.ActionEvent evt) {                                         
     setVisible(false);
     new loginAdmin().setVisible(true);
    }         

private void SignUpActionPerformed(java.awt.event.ActionEvent evt) {                                         
     setVisible(false);
     new Admin_Data().setVisible(true);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        setVisible(false);
        new index().setVisible(true);
    }    

}