public class SubmitButton{
private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    int a = JOptionPane.showConfirmDialog(null,"Do you really want to Submit","Select",JOptionPane.YES_NO_OPTION);
    if (a==0)
    {
    answerCheck();
    submit(); 
    }
 }                                        
}