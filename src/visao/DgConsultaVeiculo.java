/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.Popula;
import org.apache.log4j.Logger;

/**
 *
 * @author Diego
 */
public class DgConsultaVeiculo extends javax.swing.JDialog {

     private org.apache.log4j.Logger logger = Logger.getLogger(DgLogin.class.getName());
    public static IfReservaVeiculos telaReserva;
    public static IfLocacao telaLocacao;
    public static IfManutencaoVeiculos telaManutencao;
    public static IfDocumento telaDoc;

    /**
     * Creates new form DgConsultaVeic
     */
    public DgConsultaVeiculo(IfReservaVeiculos telaReserva, IfLocacao telaLocacao, IfManutencaoVeiculos telaManutencao, IfDocumento telaDoc) {

        initComponents();
        this.telaReserva = telaReserva;
        this.telaLocacao = telaLocacao;
        this.telaManutencao = telaManutencao;
        this.telaDoc = telaDoc;
        pesquisa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Veículo", "Marca", "Ano Modelo", "Valor Diária", "Tipo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculosMouseClicked(evt);
            }
        });
        tbVeiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbVeiculosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbVeiculos);

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("*Pesquisa por Id, veículo, marca, tipo veículo ou status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 332, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
       pesquisa();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        pesquisa();
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void tbVeiculosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbVeiculosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVeiculosKeyReleased

    private void tbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculosMouseClicked
        if (evt.getClickCount() > 1) {
            String cod = String.valueOf(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 0));
            int codigo = Integer.parseInt(cod);
            if (telaReserva != null) {
                telaReserva.defineCodigoVeiculo(codigo);
            }
            if (telaLocacao != null) {
                telaLocacao.defineCodigoVeiculo(codigo);
            }
            if (telaManutencao != null) {
                telaManutencao.defineCodigoVeiculo(codigo);
            }
            if (telaDoc != null) {
                telaDoc.defineCodigoVeiculo(codigo);
            }
            this.dispose();
        }
    }//GEN-LAST:event_tbVeiculosMouseClicked

    public void pesquisa() {
        int cod = 0;
        if (tfPesquisa.getText().length() > 0 && tfPesquisa.getText().matches("[0-9]")) {
            cod = Integer.parseInt(tfPesquisa.getText());
        }
        Popula.popularTabelaVeiculo(cod, tfPesquisa.getText(), tbVeiculos);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
