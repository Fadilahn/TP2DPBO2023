/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package foody;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Profil extends javax.swing.JFrame {

    // atribut
    private final dbConnection db;
    private final DatabaseCRUD account;
    private String username;
    private boolean isUpdate = false;
    private File selectedFile;
    
    /**
     * Creates new form Profil
     */
    
    private Profil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Profil(String username) {
        
        // init db
        db = new dbConnection("db_myresto");
        
        // init crud untuk mengubah table
        account = new DatabaseCRUD(db, "account");
        
        // masukan ke variabel
        this.username = username;
        
        initComponents();
        initLabel();
        
        // set model combo box
        String[] job = {"Admin", "Karyawan"};
        jobBox.setModel(setComboBox(job));

    }
    
    // set defalut model combo box
    public final DefaultComboBoxModel setComboBox(final String[] items){
        // set value
        DefaultComboBoxModel<String> box = new DefaultComboBoxModel(items);
        
        // set default selected item to "Pilih"
        box.setSelectedItem("Select");
        
        return box;
    }
    
    // untuk check value dari layar
    public boolean checkInput(){
        // Validate input data
        if (nameField.getText().isEmpty() || usernameField.getText().isEmpty() || jobBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(this, 
                    "Data belum lengkap!", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    // get data
    public String[] getData() {
        String[] data = new String[7]; // inisialisasi array dengan ukuran 4
        ResultSet res = account.read("username = '" + username + "'");

        try {
            if (res.next()) {
                data[0] = res.getString("name");
                data[1] = res.getString("gender");
                data[2] = res.getString("job");
                data[3] = res.getString("username");
                data[4] = res.getString("email");
                data[5] = res.getString("password");
                data[6] = res.getString("image");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return data; // mengembalikan array data
    }
    
    // check username dalam database
    public boolean checkUsername(String username){
        ResultSet res = account.read("username = '"+ username +"'");

        try{
            if(res.next()){
                // Jika username sudah digunakan, tampilkan pesan error
                JOptionPane.showMessageDialog(this, 
                        "Username sudah digunakan!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    // inisialisasi label
    public void initLabel(){
        String[] data = getData();
        nameLabel.setText(data[0]);
        genderLabel.setText(data[1]);
        jobLabel.setText(data[2]);
        usernameLabel.setText(data[3]);
        emailLabel.setText(data[4]);    
        passLabel.setText(data[5]); 
        loadImage(data[6]);

        // set label visible
        nameLabel.setVisible(true);
        genderLabel.setVisible(true);
        jobLabel.setVisible(true);
        usernameLabel.setVisible(true);
        emailLabel.setVisible(true);
        passLabel.setVisible(true);

        // set invisible
        nameField.setVisible(false);
        maleBtn.setVisible(false);
        femaleBtn.setVisible(false);
        jobBox.setVisible(false);
        usernameField.setVisible(false);
        emailField.setVisible(false);
        passField.setVisible(false);
        fileBtn.setVisible(false);
    }

    // inisialisasi Field untuk update
    public void initField(){
        String[] data = getData();
        nameField.setText(data[0]);
        // Set nilai menjadi male
        if("Male".equals(data[1])){
            maleBtn.setSelected(true);
        }
        else{
            femaleBtn.setSelected(true);
        }
        jobBox.setSelectedItem(data[2]);
        usernameField.setText(data[3]);  
        emailField.setText(data[4]);    
        passField.setText(data[5]);
        labelImage.setText(data[6]);
        selectedFile = new File(data[6]);

        // set field visible
        nameField.setVisible(true);
        maleBtn.setVisible(true);
        femaleBtn.setVisible(true);
        jobBox.setVisible(true);
        usernameField.setVisible(true);
        emailField.setVisible(true);
        passField.setVisible(true);
        fileBtn.setVisible(true);

        // set label invisible
        nameLabel.setVisible(false);
        genderLabel.setVisible(false);
        jobLabel.setVisible(false);
        usernameLabel.setVisible(false);
        emailLabel.setVisible(false);
        passLabel.setVisible(false);
    }
    
    private void loadImage(String image){
        // Load the image from a file to a Label
        ImageIcon icon = new ImageIcon(image);
        Image scaledImage = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        labelImage.setIcon(new ImageIcon(scaledImage));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        jobLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jobBox = new javax.swing.JComboBox<>();
        fileBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passField = new javax.swing.JTextField();
        maleBtn = new javax.swing.JRadioButton();
        femaleBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        nameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gender");

        jLabel3.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Job");

        jLabel4.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");

        genderLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));

        jobLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jobLabel.setForeground(new java.awt.Color(255, 255, 255));

        usernameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Profile");

        cancelBtn.setText("Home");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jobBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fileBtn.setText("Add File");
        fileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("E-mail");

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");

        emailLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));

        passLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(maleBtn);
        maleBtn.setText("Male");
        maleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleBtn);
        femaleBtn.setText("Female");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(updateBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(maleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderLabel)
                        .addGap(18, 18, 18)
                        .addComponent(femaleBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jobBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(maleBtn))
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(femaleBtn))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jobBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(updateBtn))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleBtnActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:

        if(isUpdate == false){
            initField();

            cancelBtn.setText("Cancel");
            isUpdate = true;

        }
        else{
            if(checkInput() == true){

                boolean isUsed = false;
                String username = usernameField.getText();
                // check username apakah sama dengan sekarang
                if(!this.username.equals(username)){
                    System.out.println(this.username+ " - " + username);
                    isUsed = checkUsername(username);
                }

                if(isUsed == false){
                    // Mendapatkan input dari field frame
                    String name = nameField.getText();
                    // Get nilai dari radio button yang dipilih
                    String gender;
                    if (maleBtn.isSelected()) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }
                    String job = jobBox.getSelectedItem().toString();
                    String email = emailField.getText();
                    String password = passField.getText();
                    
                    String image = null;
                    if(selectedFile != null){
                        String temp = selectedFile.getAbsolutePath();
                        File newPath = new File("src/assets/" + temp.substring(temp.lastIndexOf('\\') + 1));
                        try {
                            Files.copy(selectedFile.toPath(), newPath.toPath());
                        } catch (IOException ex) {
                            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        image = newPath.toString();
                        image = image.replace("\\","/");
                        System.out.println(image);
                    }

                    // set columns untuk crud db
                    String[] columns = {"name", "gender", "job", "username", "email", "password", "image"};
                    // set array of string untuk create ke table
                    String[] values = {name, gender, job, username, email, password, image};

                    // tambahkan ke database dengan crud method
                    account.update(columns, values, "username = '"+ username +"'");
                    this.username = username;

                    // Show Information
                    System.out.println("Update Success!");
                    JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

                    initLabel();
                    cancelBtn.setText("Home");
                    isUpdate = false;
                }
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:

        // back home
        if(cancelBtn.getText() == "Home"){
            Home home = new Home(Home.username);
            home.setVisible(true);
            dispose();
        }
        else{
            initLabel();
            cancelBtn.setText("Home");
            isUpdate = false;
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void fileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileBtnActionPerformed
        // TODO add your handling code here:
        
        // choice file
        JFileChooser fileChoice = new JFileChooser();
        fileChoice.showOpenDialog(null);
        selectedFile = fileChoice.getSelectedFile();
        
        System.out.println(selectedFile);
        
        // Load the image from a file to a Label
        loadImage(selectedFile.toString());
    }//GEN-LAST:event_fileBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton femaleBtn;
    private javax.swing.JButton fileBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jobBox;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel labelImage;
    private javax.swing.JRadioButton maleBtn;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
