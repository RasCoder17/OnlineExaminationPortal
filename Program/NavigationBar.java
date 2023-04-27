import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class NavigationBar
{
    //add new question
private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {                                    
        if(open==0)
        {
            new AddNewQuestion().setVisible(true);
            open = 1;

        }
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already Open");
        }
    }
    //update question
private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {                                    
        if(open==0)
       {
           new UpdateQuestion().setVisible(true);
           open = 1;

       }
       else
       {
           JFrame jf = new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already Open");
       }
   } 
   //logout     
private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {                                    
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    int a = JOptionPane.showConfirmDialog(jf,"Do you really want to Logout","Select",JOptionPane.YES_NO_OPTION);
    if (a == 0)
    {
        setVisible(false);
        new loginAdmin().setVisible(true);

    }
}                                                        
 //   All question menu button:
    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {                                    
            if(open==0)
            {
                new AllQuestion().setVisible(true);
                open = 1;
    
            }
            else
            {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"One form is already Open");
            }
        }   
    
   // Delete question menu button:
    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {                                    
            if(open==0)
            {
                new deleteQuestion().setVisible(true);
                open = 1;
    
            }
            else
            {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"One form is already Open");
            }
        }
   // All Student result button:
    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {                                    
                if(open==0)
            {
                new allStudentResult().setVisible(true);
                open = 1;
    
            }
            else
            {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"One form is already Open");
            }
        }
    
}