/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package foody;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */

public class Home extends javax.swing.JFrame {

    // properti
    private final dbConnection db;
    private final DatabaseCRUD account;
    private final DatabaseCRUD type;
    public static String username;
    private String selectedType;
    private JPanel selectedPanel = null;
    private int selectedId;
    
    /**
     * Creates new form Home
     */
    
    private Home() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Home(String username) {
        this(username, "foods");
    }
    
    public Home(String username, String selectType){
        this.username = username;
        this.selectedType = selectType;
        
        // init db
        db = new dbConnection("db_myresto");
        
        // init crud untuk mengubah table
        account = new DatabaseCRUD(db, "account");
        type = new DatabaseCRUD(db);
        
        // show
        initComponents();
        scrollPanel.getVerticalScrollBar().setUnitIncrement(15);
//        jPanel4.setPreferredSize(new Dimension(590, 363));
        setProfile(this.username);
        
        // set tipe sekarang
        setPanel();
        judulLabel.setText("List of "+foodsBtn.getText());

        // sembunyikan update dan delete buton
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }
    
    // set Profile
    public void setProfile(String username){
        ResultSet res = account.read("username = '"+username+"'");
        
        try{
            if(res.next()){
                String name = res.getString("name");
                String gender = res.getString("gender");
                String job = res.getString("job");
                String email = res.getString("email");
                String image = res.getString("image");
//                image = image.replaceAll("//","/");
                
                // Load the image from a file to a Label
                ImageIcon icon = new ImageIcon(image);
                Image scaledImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                profileImage.setIcon(new ImageIcon(scaledImage));
                
                nameLabel.setText(name);
                genderLabel.setText(gender);
                jobLabel.setText(job);
                emailLabel.setText(email);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // set panel
    public void setPanel() {
        setButton();
        
        scrollPanel.getVerticalScrollBar().setValue(0);

        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1, 1, 5));
        
        ResultSet res = type.read(selectedType, null);
        try {
            // Melakukan iterasi pada setiap baris hasil query
            while (res.next()) {
                mainPanel.add(new Card(selectedType, res));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void setButton(){
        Color colorSelect = new Color(51, 255, 255);
        if("foods".equals(selectedType)){
            foodsBtn.setBackground(colorSelect);
            drinksBtn.setBackground(Color.WHITE);
        }
        else{
            foodsBtn.setBackground(Color.WHITE);
            drinksBtn.setBackground(colorSelect);
        }
    }
    
    // untuk menyembunyikan semua
//    public void setVisible(boolean a){
//        updateBtn.setVisible(a);
//        deleteBtn.setVisible(a);
//    }
    
    // untuk memilih panel dalam list saat di klik
    public void setSelectedPanel(JPanel panel, int id) {
        selectedId = id;
        if (selectedPanel != null && selectedPanel == panel) {
            // Menghapus referensi ke panel yang sedang dipilih
            selectedPanel = null;
            // Mengubah warna panel kembali ke warna semula
            panel.setBackground(Color.WHITE);
            
            // sembunyikan buton update dan delete
            updateBtn.setVisible(false);
            deleteBtn.setVisible(false);
        } else {
            // Mengembalikan warna panel yang sebelumnya dipilih (jika ada)
            if (selectedPanel != null) {
                selectedPanel.setBackground(Color.WHITE);
            }
            // Mengubah warna panel yang baru
            panel.setBackground(Color.LIGHT_GRAY);
            
            // menampilkan buton update dan delete
            updateBtn.setVisible(true);
            deleteBtn.setVisible(true);
            
            // Menyimpan referensi ke panel yang sedang dipilih
            selectedPanel = panel;
        }
    }

    public JPanel getSelectedPanel() {
        return selectedPanel;
    }
    
    public String getIdColumn(){
        if("foods".equals(selectedType)){
            return "id_food";
        }
        else{
            return "id_drink";
        }
    }
    
//    public void setUpdate(){
//        type.update(columns, values, selectedType);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        profileImage = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        jobLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        foodsBtn = new javax.swing.JButton();
        drinksBtn = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        logOutBtn.setText("Log Out");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("name");

        genderLabel.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setText("gender");

        jobLabel.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jobLabel.setForeground(new java.awt.Color(0, 0, 0));
        jobLabel.setText("job");

        emailLabel.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("email");

        profileBtn.setText("Profile");
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderLabel)
                            .addComponent(jobLabel)
                            .addComponent(emailLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(logOutBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileBtn)))
                        .addGap(0, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(profileBtn)
                                    .addComponent(logOutBtn)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(127, 63, 0));

        foodsBtn.setBackground(new java.awt.Color(255, 255, 255));
        foodsBtn.setForeground(new java.awt.Color(0, 0, 0));
        foodsBtn.setText("Foods");
        foodsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodsBtnActionPerformed(evt);
            }
        });

        drinksBtn.setBackground(new java.awt.Color(255, 255, 255));
        drinksBtn.setForeground(new java.awt.Color(0, 0, 0));
        drinksBtn.setText("Drinks");
        drinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksBtnActionPerformed(evt);
            }
        });

        scrollPanel.setBorder(null);

        mainPanel.setBackground(new java.awt.Color(127, 63, 0));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(mainPanel);

        judulLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        judulLabel.setForeground(new java.awt.Color(255, 255, 255));
        judulLabel.setText("jLabel2");

        updateBtn.setBackground(new java.awt.Color(255, 255, 153));
        updateBtn.setForeground(new java.awt.Color(0, 0, 0));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 153, 153));
        deleteBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        newBtn.setBackground(new java.awt.Color(153, 255, 153));
        newBtn.setForeground(new java.awt.Color(0, 0, 0));
        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(foodsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drinksBtn)
                        .addGap(72, 72, 72)
                        .addComponent(judulLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newBtn))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(judulLabel))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(foodsBtn)
                        .addComponent(drinksBtn)
                        .addComponent(newBtn)
                        .addComponent(updateBtn)
                        .addComponent(deleteBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RESTORAN MAKAN BAROKAH");

        jLabel2.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Klick untuk edit..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);

        dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void foodsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodsBtnActionPerformed
        // TODO add your handling code here:
        selectedType = "foods";
        setPanel();
        judulLabel.setText("List of "+foodsBtn.getText());
        
        // sembunyikan buton update dan delete
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }//GEN-LAST:event_foodsBtnActionPerformed

    private void drinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksBtnActionPerformed
        // TODO add your handling code here:
        selectedType = "drinks";
        setPanel();
        judulLabel.setText("List of "+drinksBtn.getText());
        
        // sembunyikan buton update dan delete
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }//GEN-LAST:event_drinksBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        // display confirmation message
        int result = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to delete?", 
                    "Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            
        if (result == JOptionPane.YES_OPTION) {
            // if user confirms deletion
            type.delete(selectedType, ""+ getIdColumn() +" = '"+ selectedId +"'");
            setPanel();

            // sembunyikan buton update dan delete
            updateBtn.setVisible(false);
            deleteBtn.setVisible(false);

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        String[] options = {"Food", "Drink", "Cancel"};
        int result = JOptionPane.showOptionDialog(
                this, // parent component
                "Choose an option", // message
                "New Item", // title
                JOptionPane.DEFAULT_OPTION, // option type
                JOptionPane.PLAIN_MESSAGE, // message type
                null, // icon
                options, // options
                "Food" // default option
        );
        
        if (result == 0) {
            // Munculkan dialog untuk menambahkan item food
            Item item = new Item("foods");
            item.setVisible(true);
            dispose();
            
        } else if (result == 1) {
            // Munculkan dialog untuk menambahkan item drink
            Item item = new Item("drinks");
            item.setVisible(true);
            dispose();
            
        } else {
            // kode untuk cancel
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        
        // alihkan ke item panel
        Item item = new Item(selectedType, selectedId);
        item.setVisible(true);
        dispose();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        
        // alihkan ke profil frame
        Profil profil = new Profil(username);
        profil.setVisible(true);
        dispose();
    }//GEN-LAST:event_profileBtnActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        
        // alihkan ke profil frame
        Profil profil = new Profil(username);
        profil.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        
        // set color saat mouse entered
        jPanel2.setBackground(new Color(225, 225, 225));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        
        // set color saat mouse entered
        jPanel2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPanel2MouseExited

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton drinksBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton foodsBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JToggleButton logOutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JLabel profileImage;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
