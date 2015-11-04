/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.ComboItens;
import conf.CombosDAO;
import conf.HibernateUtil;
import conf.Utility;
import entidade.Permissao;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class IfPermissao extends javax.swing.JInternalFrame {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IfTipoContato.class.getName());

    /**
     * Creates new form IfPermissao
     */
    public IfPermissao() {
        initComponents();
        this.populaCombos();
        Utility.permit(btNovo, btSalvar, null, null, this);
        habilitaCampos(false);
        btSalvar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbTela = new javax.swing.JComboBox();
        cbUsuario = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbLer = new javax.swing.JCheckBox();
        cbExcluir = new javax.swing.JCheckBox();
        cbInserir = new javax.swing.JCheckBox();
        cbEditar = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cbFuncao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Cadastro de Permissões");

        jToolBar1.setRollover(true);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo_32x32.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar_32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);
        jToolBar1.add(jSeparator1);

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_32x32.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(btFechar);

        jLabel6.setText("Tela*:");

        cbTela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Adicionar permissão para usuário*:");

        cbLer.setSelected(true);
        cbLer.setText("Ler");

        cbExcluir.setSelected(true);
        cbExcluir.setText("Excluir");

        cbInserir.setSelected(true);
        cbInserir.setText("Inserir");

        cbEditar.setSelected(true);
        cbEditar.setText("Editar");

        jLabel7.setText("Grupo de usuários*:");

        cbFuncao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbTela, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLer)
                            .addComponent(cbEditar)
                            .addComponent(cbInserir)
                            .addComponent(cbExcluir))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbLer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbExcluir)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setText("Campos obrigatórios*:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        habilitaCampos(true);

        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cbTela.getSelectedIndex() >= 0 && cbFuncao.getSelectedIndex() > 0 && cbUsuario.getSelectedIndex() > 0) {
            Session sessao = null;
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                if (cbTela.getSelectedItem() == "Todas") {
                    int somacombotela = cbTela.getItemCount() - 1;
                    for (int i = 1; i <= somacombotela; i++) {

                        Transaction t = sessao.beginTransaction();
                        Permissao p = salvaPerm();
                        p.setIdtela(i);
                        sessao.save(p);
                        t.commit();
                        habilitaCampos(false);
                        btNovo.setEnabled(true);
                        btSalvar.setEnabled(false);
                        cbUsuario.requestFocus();
                    }
                } else {
                    ComboItens cbit = (ComboItens) cbTela.getSelectedItem();
                    Transaction t = sessao.beginTransaction();
                    Permissao p = salvaPerm();

                    p.setIdtela(cbit.getCodigo());
                    sessao.save(p);
                    t.commit();
                }
                habilitaCampos(false);
                btNovo.setEnabled(true);
                btSalvar.setEnabled(false);
            } catch (HibernateException he) {
                he.printStackTrace();
                System.out.println("Erro ao  = " + he.toString());
                System.out.println("Erro ao  = " + he.getStackTrace().toString());
                logger.error("Erro");
            } finally {
                sessao.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    public void habilitaCampos(Boolean tf) {
        if (tf == false) {
            limpaCampos();
        }
        cbFuncao.setEnabled(tf);
        cbUsuario.setEnabled(tf);
        cbTela.setEnabled(tf);

        cbEditar.setEnabled(tf);
        cbExcluir.setEnabled(tf);
        cbLer.setEnabled(tf);
        cbInserir.setEnabled(tf);
    }

    public void limpaCampos() {

        cbFuncao.setSelectedIndex(0);
        cbUsuario.setSelectedIndex(0);
        cbTela.setSelectedIndex(0);

        cbEditar.setSelected(true);
        cbExcluir.setSelected(true);
        cbLer.setSelected(true);
        cbInserir.setSelected(true);
        populaCombos();
    }

    public Permissao salvaPerm() {
        Permissao p = new Permissao();

        ComboItens cbiu = (ComboItens) cbUsuario.getSelectedItem();
        p.setIdpessoa(cbiu.getCodigo());
        ComboItens cbif = (ComboItens) cbFuncao.getSelectedItem();
        p.setIdFuncao(cbif.getCodigo());

        p.setLer(cbLer.isSelected());
        p.setInserir(cbInserir.isSelected());
        p.setEditar(cbEditar.isSelected());
        p.setInativar(cbExcluir.isSelected());
        return p;
    }

    public void populaCombos() {
        cbTela.removeAllItems();
        cbTela.addItem("Todas");
        new CombosDAO().popularCombo("Tela", "idtela", "descricao", cbTela, "");
        cbTela.removeItemAt(1);
        cbUsuario.removeAllItems();
        new CombosDAO().popularCombo("Funcionario", "pessoaIdpessoa", "login", cbUsuario, "");
        cbFuncao.removeAllItems();
        new CombosDAO().popularCombo("Funcao", "idfuncao", "descricao", cbFuncao, "");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cbEditar;
    private javax.swing.JCheckBox cbExcluir;
    private javax.swing.JComboBox cbFuncao;
    private javax.swing.JCheckBox cbInserir;
    private javax.swing.JCheckBox cbLer;
    private javax.swing.JComboBox cbTela;
    private javax.swing.JComboBox cbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
