//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package visao;
//
//import java.awt.Image;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import javax.swing.DefaultListModel;
//import javax.swing.ImageIcon;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
///**
// *
// * @author Daiane
// */
public class DgConfigurarImagem extends javax.swing.JDialog {
//
//    File file = null;
//    byte[] imagem;
//    LogoDAO lDAO;
//    DefaultListModel modeloLista;
//
//    /**
//     * Creates new form DgCofigurarRelatorio
//     */
   public DgConfigurarImagem(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
//        initComponents();
//        this.setTitle("SoftTech");
//        lDAO = new LogoDAO();
//
//        ImageIcon ico = new ImageIcon(lDAO.consultarLogo(1));
//        Image img = ico.getImage();
//        Image nimg = img.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
//        ImageIcon nIcon = new ImageIcon(nimg);
//        lbImg.setIcon(nIcon);
   }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btSelecionarImg = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setRollover(true);

        btSelecionarImg.setText("Selecionar imagem...");
        btSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarImgActionPerformed(evt);
            }
        });
        jToolBar1.add(btSelecionarImg);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_32x32.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel1.setText("Defina o logo/imagem dos relatórios no botão acima");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(57, 57, 57))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btSelecionarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarImgActionPerformed
//        JFileChooser fc = new JFileChooser();
//
//        fc.setAcceptAllFileFilterUsed(false);
//        fc.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de imagem", "jpg", "jpeg", "gif", "png"));
//        fc.setMultiSelectionEnabled(false);
//
//        file = null;
//        int res = fc.showOpenDialog(null);
//        if (res == JFileChooser.APPROVE_OPTION) {
//            file = fc.getSelectedFile();
//        }
//        imagem = new byte[(int) file.length()];
//        System.out.println("Lendo " + file.length() + " bytes...");
//
//        //lbImg.setText(file.getPath());
//
//        try {
//            DataInputStream is = new DataInputStream(new FileInputStream(file));
//            is.readFully(imagem);
//            is.close();
//        } catch (Exception e) {
//            System.out.println("Erro: " + e);
//        }
//
//        Logo logo = new Logo();
//
//        logo.setImagem(imagem);
//
//        String erro = lDAO.cadastrarLogo(logo);
//        if (erro == null) {
//            JOptionPane.showMessageDialog(null, "Logo salvo com sucesso!");
//
//            ImageIcon ico = new ImageIcon(lDAO.consultarLogo(1));
//            Image img = ico.getImage();
//            Image nimg = img.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
//            ImageIcon nIcon = new ImageIcon(nimg);
//            lbImg.setIcon(nIcon);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Problemas ao salvar logo!\n" + erro);
//        }


    }//GEN-LAST:event_btSelecionarImgActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSelecionarImg;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbImg;
    // End of variables declaration//GEN-END:variables
}
