import java.sql.*;
import project.ConnectionProvider;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.awt.Color;
public class signup {
  public StudentDetails() {
        initComponents();
        jTextArea1.setEditable(false);
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
    }
  }
