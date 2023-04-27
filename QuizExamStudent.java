public class quizExamStudent extends javax.swing.JFrame {

    public String questionId = "1";
    public String answer;
    public int min=0;
    public int sec=0;
    public int marks=0;
    public void answerCheck()
    {
        String studentAnswer="";
        if (jRadioButton1.isSelected())
        {
          studentAnswer = jRadioButton1.getText();
        }
        else if(jRadioButton2.isSelected())
        {
        studentAnswer = jRadioButton2.getText();
        }
        else if(jRadioButton3.isSelected())
        {
        studentAnswer = jRadioButton3.getText();
        }
        else 
        {
        studentAnswer = jRadioButton4.getText();
        }
        if (studentAnswer.equals(answer))
        {
          marks = marks +1;
          String marks1 = String.valueOf(marks);
          jLabel19.setText(marks1);
        }    
        //question number change
        int questionId1= Integer.parseInt(questionId);
        questionId1 = questionId1 + 1; 
        questionId = String.valueOf(questionId1);
        //clear RadioButton
        
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
         
        
        //last question hide next button
        
        if(questionId.equals("10"))
        {
        jButton1.setVisible(false);
        }
    }
    
    public void submit()
    {
    
         String rollNo = jLabel11.getText();
        try
        {
           Connection con  = ConnectionProvider.getcon();
           Statement st = con.createStatement();
           String marks1 = String.valueOf(marks);
           String query1 = " update student set marks = '"+jLabel19.getText()+"' where rollNo = '"+rollNo+"' ; ";
           st.executeUpdate(query1);
           setVisible(false);
           new successfullySubmitted().setVisible(true);
           JOptionPane.showMessageDialog(null,"You scored "+jLabel19.getText()+"  "+rollNo);
        }
        
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null, e);
       }
        
    }        
    
    public void question()
    {
         try
        {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement(); 
            String query1 = " select * from question where id = '"+questionId+"'";
            ResultSet rs1 = st.executeQuery(query1);
            
            while(rs1.next())
            {
               jLabel17.setText(rs1.getString(1));
               jLabel20.setText(rs1.getString(2));
               jRadioButton1.setText(rs1.getString(3));
               jRadioButton2.setText(rs1.getString(4));
               jRadioButton3.setText(rs1.getString(5));
               jRadioButton4.setText(rs1.getString(6));
               answer=rs1.getString(7);
            } 
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e);
        }  
    }
        
    
    /**
     * Creates new form quizExamStudent
     */
    public quizExamStudent() {
        initComponents();
    }
    
    Timer time;
      public quizExamStudent(String rollNo) {
        initComponents();
        jLabel11.setText(rollNo);
        //date
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
        
        //first question and student details
        try
        {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            String query = " select * from student where rollNo = '"+rollNo+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
               jLabel13.setText(rs.getString(2));
               
            } 
            String query1 = " select * from question where id = '"+questionId+"'";
            ResultSet rs1 = st.executeQuery(query1);
            
            while(rs1.next())
            {
               jLabel17.setText(rs1.getString(1));
               jLabel20.setText(rs1.getString(2));
               jRadioButton1.setText(rs1.getString(3));
               jRadioButton2.setText(rs1.getString(4));
               jRadioButton3.setText(rs1.getString(5));
               jRadioButton4.setText(rs1.getString(6));
               answer=rs1.getString(7);
            } 
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e);
        }    
        //Timeer program
        
        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                jLabel9.setText(String.valueOf(sec));
                jLabel8.setText(String.valueOf(min));
                
       if(sec == 60)
        {
         sec=0;
         min++;
         if(min==10)
        {
          time.stop();
          answerCheck();
          submit();
        } 
        }  
       sec++;
       
            }
        });
        time.start();
    }
}

