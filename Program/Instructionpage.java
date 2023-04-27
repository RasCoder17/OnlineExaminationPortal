import javax.swing.JOptionPane;
public class instructionStudent extends javax.swing.JFrame {
    public String rollNo;
       
        public instructionStudent() {
            initComponents();
        }
        
        public instructionStudent(String rollNo1) {
            initComponents();
            jTextArea1.setEditable(false);
            rollNo = rollNo1;
        }
    