package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Locacao generated by hbm2java
 */
@Entity
@Table(name = "locacao", schema = "public")
public class Locacao implements java.io.Serializable {

    @Id
    @Column(name = "idlocacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_pessoa_idpessoa", nullable = false)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_pessoa_idpessoa", nullable = false)
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_idreserva")
    private Reserva reserva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_idveiculo", nullable = false)
    private Veiculo veiculo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_locacao", nullable = false, length = 13)
    private Date dtLocacao;
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_retirada", nullable = false, length = 15)
    private Date horaRetirada;
    @Column(name = "dias", nullable = false)
    private int dias;
    @Column(name = "valor_total", nullable = false, precision = 11)
    private BigDecimal valorTotal;
    @Column(name = "parcelas", nullable = false)
    private int parcelas;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locacao")
    private Set<Parcelaspagamento> parcelaspagamento = new HashSet(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locacao")
    private Set<Devolucao> devolucaos = new HashSet(0);

    public Locacao() {
    }

    public Locacao(int idlocacao, Cliente cliente, Funcionario funcionario, Parcelaspagamento parcelaspagamento, Veiculo veiculo, Date dtLocacao, Date horaRetirada, int dias, BigDecimal valorTotal, int parcelas) {
        this.idlocacao = idlocacao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.dtLocacao = dtLocacao;
        this.horaRetirada = horaRetirada;
        this.dias = dias;
        this.valorTotal = valorTotal;
        this.parcelas = parcelas;
    }

    public Locacao(int idlocacao, entidade.Cliente cliente, entidade.Funcionario funcionario, Reserva reserva, Veiculo veiculo, Date dtLocacao, Date horaRetirada, int dias, BigDecimal valorTotal, int parcelas, Set parcelaspagamento, Set devolucaos) {
        this.idlocacao = idlocacao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.reserva = reserva;
        this.veiculo = veiculo;
        this.dtLocacao = dtLocacao;
        this.horaRetirada = horaRetirada;
        this.dias = dias;
        this.valorTotal = valorTotal;
        this.parcelas = parcelas;
        this.parcelaspagamento = parcelaspagamento;
        this.devolucaos = devolucaos;
    }

    public int getIdlocacao() {
        return this.idlocacao;
    }

    public void setIdlocacao(int idlocacao) {
        this.idlocacao = idlocacao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDtLocacao() {
        return this.dtLocacao;
    }

    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public Date getHoraRetirada() {
        return this.horaRetirada;
    }

    public void setHoraRetirada(Date horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getParcelas() {
        return this.parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Set getParcelaspagamento() {
        return this.parcelaspagamento;
    }

    public void setParcelaspagamento(Set parcelaspagamento) {
        this.parcelaspagamento = parcelaspagamento;
    }

    public Set getDevolucaos() {
        return this.devolucaos;
    }

    public void setDevolucaos(Set devolucaos) {
        this.devolucaos = devolucaos;
    }
}
