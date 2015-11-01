/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.HibernateUtil;
import entidade.Populartabelareserva;
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
public class DgConsultaReserva extends javax.swing.JDialog {
    
    private org.apache.log4j.Logger logger = Logger.getLogger(DgLogin.class.getName());
    IfLocacao telaLocacao;
    int codigoVeiculo;
    int codigoCliente;
    
    public DgConsultaReserva(IfLocacao janela) {
        
        initComponents();
        telaLocacao = janela;
        codigoVeiculo = 0;
        codigoCliente = 0;
        this.popularTabelaReserva(tfPesquisa.getText(), tbReserva);
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
        tbReserva = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Data Reserva", "Data Locação", "Dias Pretendidos", "Nome Cliente", "Veículo", "Tipo Veículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbReserva);

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
        this.popularTabelaReserva(tfPesquisa.getText(), tbReserva);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        this.popularTabelaReserva(tfPesquisa.getText(), tbReserva);
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void tbReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservaMouseClicked
        if (evt.getClickCount() > 1) {
            String cod = String.valueOf(tbReserva.getValueAt(tbReserva.getSelectedRow(), 0));
            int codigo = Integer.parseInt(cod);
            telaLocacao.defineCodigoReserva(codigo);
            telaLocacao.defineCodigoCliente(codigoCliente);
            telaLocacao.defineCodigoVeiculo(codigoVeiculo);
            this.dispose();
        }
    }//GEN-LAST:event_tbReservaMouseClicked
    
    public void popularTabelaReserva(String criterio, JTable tb) {
        
        DefaultTableModel tabelaModelo = (DefaultTableModel) tb.getModel();
        tabelaModelo.setNumRows(0);
        
        Session sessao = null;
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        criterio = criterio.toLowerCase();
        Query query = (Query) sessao.createQuery(" FROM Populartabelareserva p WHERE (lower(p.descricaoveiculo) LIKE '%" + criterio + "%'"
                + " OR lower(p.nomecliente) LIKE '%" + criterio + "%'"
                + " OR lower(p.descricaotipo) LIKE '%" + criterio + "%')");
        List<Populartabelareserva> dadosLocacao = (List<Populartabelareserva>) query.list();
        
        for (Populartabelareserva lin : dadosLocacao) {
            tabelaModelo.addRow(new Object[]{
                lin.getIdreserva(),
                lin.getDtReserva(),
                lin.getDtLocacao(),
                lin.getDiasPretendidos(),
                lin.getNomecliente(),
                lin.getDescricaoVeiculo(),
                lin.getDescricaoTipo(),
            codigoCliente = lin.getIdcliente(),
            codigoVeiculo = lin.getIdVeiculo(),
            });
            
        }
        sessao.getTransaction().commit();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbReserva;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
