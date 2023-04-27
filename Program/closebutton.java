public class closebutton
{
int a = JOptionPane.showConfirmDialog(null,"Do you really want to exit Application ","select",JOptionPane.YES_NO_OPTION);
        if (a == 0)
        {
            System.exit(0);
        }
    }        
