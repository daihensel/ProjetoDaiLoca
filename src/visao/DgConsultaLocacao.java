/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.HibernateUtil;
import entidade.Populartabelalocacao;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diego
 */
public class DgConsultaLocacao extends javax.swing.JDialog {

     private org.apache.log4j.Logger logger = Logger.getLogger(DgLogin.class.getName());
    IfDevolucao telaDevolucao;

    public DgConsultaLocacao(IfDevolucao janela) {

        initComponents();
        telaDevolucao = janela;
        this.popularTabelaLocacao(tfPesquisa.getText(),tbLocacoes);
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
        tbLocacoes = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbLocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Data Locação", "Nome Cliente", "Veículo", "Tipo Veículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLocacoes);

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("*Pesquisa por veículo, nome cliente ou tipo veículo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 313, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.popularTabelaLocacao(tfPesquisa.getText(),tbLocacoes);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        this.popularTabelaLocacao(tfPesquisa.getText(),tbLocacoes);
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void tbLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocacoesMouseClicked
        if (evt.getClickCount() > 1) {
            String cod = String.valueOf(tbLocacoes.getValueAt(tbLocacoes.getSelectedRow(), 0));
            int codigo = Integer.parseInt(cod);
            telaDevolucao.defineLocacao(codigo);
            this.dispose();
        }
    }//GEN-LAST:event_tbLocacoesMouseClicked

    public void popularTabelaLocacao(String criterio, JTable tb) {

        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);

        Session sessao = null;

        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelalocacao p WHERE (lower(p.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nomecliente) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaotipoveiculo) LIKE '%" + criterio + "%')");
        List<Populartabelalocacao> dadosLocacao = (List<Populartabelalocacao>) query.list();

        for (Populartabelalocacao lin : dadosLocacao) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdlocacao(),
                lin.getDtLocacao(),
                lin.getNomecliente(),
                lin.getDescricaoVeiculo(),
                lin.getDescricaoTipoVeiculo()});

        }
        sessao.getTransaction().commit();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLocacoes;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
