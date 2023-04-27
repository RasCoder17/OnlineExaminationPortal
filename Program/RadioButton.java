public class RadioButton
{
private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
    if(jRadioButton1.isSelected())
    {
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton4.setSelected(false);
       
    }
}                                             

private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
    if(jRadioButton2.isSelected())
    {
       jRadioButton1.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton4.setSelected(false);
       
    }
}                                             

private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
  if(jRadioButton3.isSelected())
    {
       jRadioButton2.setSelected(false);
       jRadioButton1.setSelected(false);
       jRadioButton4.setSelected(false);
       
    }
   
}                                             

private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              

      if(jRadioButton4.isSelected())
    {
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton1.setSelected(false);
       
    }
}
}