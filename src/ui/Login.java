package ui;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import ultimatetictactoe.UltimateTicTacToeClient;

public class Login extends javax.swing.JPanel
{
    private final UltimateTicTacToeClient game;
    
    public Login(UltimateTicTacToeClient game)
    {
        this.game = game;
        initComponents();
    }
    
    private void login()
    {
        char[] input = LoginPasswordField.getPassword();
        String name = LoginUsernameField.getText();
        String pass = String.valueOf(input);
        Arrays.fill(input, '0');
        if(name.equals("")||pass.equals(""))
        {
            game.alertUser("All fields must be filled in!");
        }
        else
        {
            try
            {
                int result = UltimateTicTacToeClient.getProxy().login(name,pass);
                if(result <= 0)
                {
                    game.alertUser("Incorrect Username or Password!");
                }
                else
                {
                    game.setUserName(name);
                    game.setUserID(result);
                    game.updateCurrentScreen(new Menu(game));
                }
            }
            catch(Exception e)
            {
                System.exit(1);
            }
        }
    }
    
    private void register()
    {
        char[] input = RegisterPasswordField.getPassword();
        String username = RegisterUsernameField.getText();
        String name = RegisterNameField.getText();
        String surname = RegisterSurnameField.getText();
        String pass = String.valueOf(input);
        Arrays.fill(input, '0');
        if(username.equals("")||pass.equals("")||name.equals("")||surname.equals(""))
        {
            game.alertUser("All fields must be filled in!");
        }
        else
        {
            try
            {
                String result = UltimateTicTacToeClient.getProxy().register(username,pass,name,surname);
                switch(result)
                {
                    case "ERROR-REPEAT":
                        game.alertUser("User already exists!");
                        break;
                    case "ERROR-INSERT":
                    case "ERROR-RETRIEVE":
                    case "ERROR-DB":
                        game.alertUser("Database Error!");
                        break;
                    default:
                        game.setUserName(username);
                        game.setUserID(Integer.parseInt(result));
                        game.updateCurrentScreen(new Menu(game));
                }
            }
            catch(Exception e)
            {
                System.exit(1);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LoginPanel = new javax.swing.JPanel();
        LoginNameLabel = new javax.swing.JLabel();
        LoginUsernameField = new javax.swing.JTextField();
        LoginPasswordField = new javax.swing.JPasswordField();
        LoginPasswordLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        RegisterPanel = new javax.swing.JPanel();
        RegisterNameLabel = new javax.swing.JLabel();
        RegisterSurnameField = new javax.swing.JTextField();
        RegisterSurnameLabel = new javax.swing.JLabel();
        RegisterUserNameLabel = new javax.swing.JLabel();
        RegisterUsernameField = new javax.swing.JTextField();
        RegisterPasswordField = new javax.swing.JPasswordField();
        RegisterPasswordLabel = new javax.swing.JLabel();
        RegisterNameField = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(this);
        jLabel1.setText("Ultimate Tic Tac Toe");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 10));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 10));
        jPanel1.add(jLabel1);

        LoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        LoginPanel.setLayout(new java.awt.GridBagLayout());

        LoginNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginNameLabel.setLabelFor(LoginUsernameField);
        LoginNameLabel.setText("Username");
        LoginNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        LoginPanel.add(LoginNameLabel, gridBagConstraints);

        LoginUsernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LoginUsernameField.setToolTipText("");
        LoginUsernameField.setMinimumSize(new java.awt.Dimension(128, 24));
        LoginUsernameField.setPreferredSize(new java.awt.Dimension(128, 24));
        LoginUsernameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LoginUsernameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        LoginPanel.add(LoginUsernameField, gridBagConstraints);
        LoginUsernameField.getAccessibleContext().setAccessibleName("UserNameField");

        LoginPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LoginPasswordField.setMinimumSize(new java.awt.Dimension(128, 24));
        LoginPasswordField.setPreferredSize(new java.awt.Dimension(128, 24));
        LoginPasswordField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LoginPasswordFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        LoginPanel.add(LoginPasswordField, gridBagConstraints);
        LoginPasswordField.getAccessibleContext().setAccessibleName("PasswordField");
        LoginPasswordField.getAccessibleContext().setAccessibleDescription("");

        LoginPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginPasswordLabel.setLabelFor(LoginPasswordField);
        LoginPasswordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 0);
        LoginPanel.add(LoginPasswordLabel, gridBagConstraints);

        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                LoginButtonKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        LoginPanel.add(LoginButton, gridBagConstraints);

        jPanel1.add(LoginPanel);

        RegisterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Register"));
        RegisterPanel.setLayout(new java.awt.GridBagLayout());

        RegisterNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterNameLabel.setLabelFor(RegisterNameField);
        RegisterNameLabel.setText("Name");
        RegisterNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        RegisterPanel.add(RegisterNameLabel, gridBagConstraints);

        RegisterSurnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegisterSurnameField.setToolTipText("");
        RegisterSurnameField.setMinimumSize(new java.awt.Dimension(128, 24));
        RegisterSurnameField.setPreferredSize(new java.awt.Dimension(128, 24));
        RegisterSurnameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegisterSurnameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        RegisterPanel.add(RegisterSurnameField, gridBagConstraints);

        RegisterSurnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterSurnameLabel.setLabelFor(RegisterSurnameField);
        RegisterSurnameLabel.setText("Surname");
        RegisterSurnameLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 0);
        RegisterPanel.add(RegisterSurnameLabel, gridBagConstraints);

        RegisterUserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterUserNameLabel.setLabelFor(LoginUsernameField);
        RegisterUserNameLabel.setText("Username");
        RegisterUserNameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        RegisterPanel.add(RegisterUserNameLabel, gridBagConstraints);

        RegisterUsernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegisterUsernameField.setToolTipText("");
        RegisterUsernameField.setMinimumSize(new java.awt.Dimension(128, 24));
        RegisterUsernameField.setPreferredSize(new java.awt.Dimension(128, 24));
        RegisterUsernameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegisterUsernameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        RegisterPanel.add(RegisterUsernameField, gridBagConstraints);

        RegisterPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegisterPasswordField.setMinimumSize(new java.awt.Dimension(128, 24));
        RegisterPasswordField.setPreferredSize(new java.awt.Dimension(128, 24));
        RegisterPasswordField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegisterPasswordFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        RegisterPanel.add(RegisterPasswordField, gridBagConstraints);

        RegisterPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterPasswordLabel.setLabelFor(LoginPasswordField);
        RegisterPasswordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 0);
        RegisterPanel.add(RegisterPasswordLabel, gridBagConstraints);

        RegisterNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegisterNameField.setToolTipText("");
        RegisterNameField.setMinimumSize(new java.awt.Dimension(128, 24));
        RegisterNameField.setPreferredSize(new java.awt.Dimension(128, 24));
        RegisterNameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegisterNameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        RegisterPanel.add(RegisterNameField, gridBagConstraints);

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegisterButtonActionPerformed(evt);
            }
        });
        RegisterButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                RegisterButtonKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        RegisterPanel.add(RegisterButton, gridBagConstraints);

        jPanel1.add(RegisterPanel);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_LoginUsernameFieldActionPerformed
    {//GEN-HEADEREND:event_LoginUsernameFieldActionPerformed
        
    }//GEN-LAST:event_LoginUsernameFieldActionPerformed

    private void LoginPasswordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_LoginPasswordFieldActionPerformed
    {//GEN-HEADEREND:event_LoginPasswordFieldActionPerformed
        
    }//GEN-LAST:event_LoginPasswordFieldActionPerformed

    private void RegisterSurnameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegisterSurnameFieldActionPerformed
    {//GEN-HEADEREND:event_RegisterSurnameFieldActionPerformed
        
    }//GEN-LAST:event_RegisterSurnameFieldActionPerformed

    private void RegisterUsernameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegisterUsernameFieldActionPerformed
    {//GEN-HEADEREND:event_RegisterUsernameFieldActionPerformed
        
    }//GEN-LAST:event_RegisterUsernameFieldActionPerformed

    private void RegisterPasswordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegisterPasswordFieldActionPerformed
    {//GEN-HEADEREND:event_RegisterPasswordFieldActionPerformed
        
    }//GEN-LAST:event_RegisterPasswordFieldActionPerformed

    private void RegisterNameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegisterNameFieldActionPerformed
    {//GEN-HEADEREND:event_RegisterNameFieldActionPerformed
        
    }//GEN-LAST:event_RegisterNameFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_LoginButtonActionPerformed
    {//GEN-HEADEREND:event_LoginButtonActionPerformed
        login();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegisterButtonActionPerformed
    {//GEN-HEADEREND:event_RegisterButtonActionPerformed
        register();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void RegisterButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_RegisterButtonKeyPressed
    {//GEN-HEADEREND:event_RegisterButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(RegisterButton.hasFocus())
                register();
        }
    }//GEN-LAST:event_RegisterButtonKeyPressed

    private void LoginButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_LoginButtonKeyPressed
    {//GEN-HEADEREND:event_LoginButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(LoginButton.hasFocus())
                login();
        }
    }//GEN-LAST:event_LoginButtonKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginNameLabel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPasswordField LoginPasswordField;
    private javax.swing.JLabel LoginPasswordLabel;
    private javax.swing.JTextField LoginUsernameField;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField RegisterNameField;
    private javax.swing.JLabel RegisterNameLabel;
    private javax.swing.JPanel RegisterPanel;
    private javax.swing.JPasswordField RegisterPasswordField;
    private javax.swing.JLabel RegisterPasswordLabel;
    private javax.swing.JTextField RegisterSurnameField;
    private javax.swing.JLabel RegisterSurnameLabel;
    private javax.swing.JLabel RegisterUserNameLabel;
    private javax.swing.JTextField RegisterUsernameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
