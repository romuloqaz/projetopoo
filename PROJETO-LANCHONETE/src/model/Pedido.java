package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A classe <b>Pedido</b> modela a entidade <b>Pedido</b> do domínio da aplicação.
 * @author RaulRomulo
 * @since 1.0
 * @version 1.o
 */

public class Pedido {
    private Produto produto;
    private static int id;
    private int idPedido;
    private int quantidade;
    private float subtotal;
    private int mesa;
    private boolean status;
    private LocalTime horaPedido;
    private LocalDate dataPedido;

    /**
     * Atributos da classe <b>Pedido</b>
     * @param produto indica o atributo produto para o pedido
     * @param quantidade indica a quantidade de produtos
     * @param subtotal indica o subtotal do valor do pedido
     * @param horaPedido indica a hora em que o pedido foi recebido
     * @param dataPedido indica a data em que o pedido foi recebido
     * O status indica o status do pedido, sendo aberto ou fechado
     * O idpedido indica o numero do pedido
     * A mesa indica a mesa onde sera atendido o pedido
     */

    public Pedido(Produto produto, int quantidade, float subtotal, LocalTime horaPedido, LocalDate dataPedido) {
        this.produto = produto;
        idPedido = ++id;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        status = true;
        this.horaPedido = horaPedido;
        this.dataPedido = dataPedido;
    }

    /**
     * Metodos get e set da classe <b>Pedido</b>
     * @return aponta e retorna os atributos da classse
     */

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Pedido.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean setStatus(boolean status) {
        this.status = status;
        return status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal = getQuantidade() * getProduto().getPrecoUnitario();
    }

    public void setSubtotal(float subtotal) {
       this.subtotal = subtotal;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     * metodo toString que é uma representação textual da classe
     *
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "produto=" + produto +
                ", idPedido=" + idPedido +
                ", quantidade=" + quantidade +
                ", subtotal=" + subtotal +
                ", mesa=" + mesa +
                ", status=" + status +
                ", horaPedido=" + horaPedido +
                ", dataPedido=" + dataPedido +
                '}';
    }
}

