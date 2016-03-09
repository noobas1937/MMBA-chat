/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.User;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Ahmed
 */
public class ServerGUI extends javax.swing.JFrame {

    private boolean isServerRunning;
    private final ChatServer server;

    /**
     * Creates new form ServerGUI
     */
    public ServerGUI(ChatServer server) {
        this.server = server;
        this.isServerRunning = false;
        initComponents();
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
    }

    
    public void updateUsersList() throws RemoteException {
        List<User> contactUsers = User.getAllUsers();
        String[] emailsRetreived = new String[contactUsers.size()];
        for (int i = 0; i < contactUsers.size(); i++) {
            User contact = contactUsers.get(i);
            // 3ak3ak
            /* End 3ak3ak */
            String retrievedEmail = contact.getEmail();

            String retrievedStatus = contact.getStatus();
            emailsRetreived[i] = retrievedEmail + "( " + retrievedStatus + " ) ";
        }

        if (contactUsers.size() > 0) {
            // Enter All Contact To Chat List
            contactList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = emailsRetreived;

                @Override
                public int getSize() {
                    return strings.length;
                }

                @Override
                public String getElementAt(int i) {
                    return strings[i];
                }
            });

        }
    }
    
    
    
    public void updateOnlineLabel() {
        // onlineLabel.setText(text);
        try {
            // connectedLabel
            Connection db = DBConnect.getConn();
            Statement stm;
            String query;
            stm = db.createStatement();
            query = "select count(*) from User where status = 'online'";
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            onlineLabel.setText("Number of online client is " + rs.getInt("count(*)"));

        } catch (SQLException ex) {
            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    
    
//    public void updateAwayLabel() {
//        //offlineLabel
//        try {
//            // connectedLabel
//            Connection db = DBConnect.getConn();
//            Statement stm;
//            String query;
//            stm = db.createStatement();
//            query = "select count(*) from User where status = 'away'";
//            // awyLabel.setText(query);
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                awyLabel.setText("Number of Away client is " + rs.getInt("count(*)"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void updateOfflineLabel() {
        // awyLabel
        try {
            // connectedLabel
            Connection db = DBConnect.getConn();
            Statement stm;
            String query;
            stm = db.createStatement();
            query = "select count(*) from User where status = 'offline'";
            //  offlineLabel.setText(query);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                offlineLabel.setText("Number of  offline client is " + rs.getInt("count(*)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        EmailTextField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        adminPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatTextSend = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        ServerStatusBtn = new javax.swing.JToggleButton();
        onlineLabel = new javax.swing.JLabel();
        offlineLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Option = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();
        Helper = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        EmailLabel.setText("Email");

        passwordLabel.setText("Password");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginBtn)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(loginBtn)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jPanel1.add(loginPanel, "card2");
        loginPanel.getAccessibleContext().setAccessibleName("loginPanel");

        adminPanel.setLayout(new java.awt.GridLayout(1, 3));

        chatTextSend.setEditable(false);
        chatTextSend.setColumns(20);
        chatTextSend.setRows(5);
        jScrollPane2.setViewportView(chatTextSend);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTextArea3);

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        adminPanel.add(jPanel4);

        contactList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(contactList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        adminPanel.add(jPanel2);

        ServerStatusBtn.setText("Start Server");
        ServerStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerStatusBtnActionPerformed(evt);
            }
        });

        onlineLabel.setText("Online");

        offlineLabel.setText("Offline");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ServerStatusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onlineLabel)
                            .addComponent(offlineLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ServerStatusBtn)
                .addGap(101, 101, 101)
                .addComponent(onlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(offlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        adminPanel.add(jPanel3);

        jPanel1.add(adminPanel, "card3");
        adminPanel.getAccessibleContext().setAccessibleName("adminPanel");

        getContentPane().add(jPanel1, "jPanel1");

        Option.setText("Options");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, 0));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        Option.add(exit);

        jMenuBar1.add(Option);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        Helper.setText("Help");
        Help.add(Helper);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        if (EmailTextField.getText().equals("admin") && jPasswordField1.getText().equals("admin")) {
            // TODO add your handling code here:
            CardLayout c1 = (CardLayout) jPanel1.getLayout();
            c1.next(jPanel1);
            
            
            
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "Email or password isn't correct", "Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
        try {
            server.updateUsersList();
        } catch (RemoteException ex) {
            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        server.updateOnlineLabel();
        server.updateOfflineLabel();
//        server.updateAwayLabel();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendBtnActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_AboutActionPerformed

    private void ServerStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerStatusBtnActionPerformed
        try {

            if (this.isServerRunning) {
                ChatServer.RMI_REGISTRY.unbind("user");
                Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Unregistered: {0}", new Object[]{"Stop"});
                this.isServerRunning = false;
                this.ServerStatusBtn.setText("Start");

            } else {
                User user = new User();
                ChatServer.RMI_REGISTRY.rebind("user", user);
                this.isServerRunning = true;
                Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Registered: {0} -> {1}", new Object[]{"Start", user.getClass().getName()});
                this.ServerStatusBtn.setText("Stop");
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ServerStatusBtnActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ServerGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Helper;
    private javax.swing.JMenu Option;
    private javax.swing.JToggleButton ServerStatusBtn;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JTextArea chatTextSend;
    private javax.swing.JList<String> contactList;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel offlineLabel;
    private javax.swing.JLabel onlineLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton sendBtn;
    // End of variables declaration//GEN-END:variables
}
