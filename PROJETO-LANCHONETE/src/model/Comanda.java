package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <b>Comanda</b> modela a entidade <b>Comanda</b> do domínio da aplicação, onde terão métodos e dominios da mesma
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class Comanda {

    private List<Pedido> pedidos;
    private boolean aberto;
    private int mesa;
    private final LocalDate data;

    /**
     * Atributos da entidade <b>Comanda</b>
     * Classe contem uma estrutura lista de pedido com vários pedidos, indicando que seria uma comanda
     * Atributo boleano para um pedido aberto ou fechado
     * @param mesa indica uma mesa para a comanda
     * Data indica a data do pedido
     *
     */
    public Comanda(int mesa) {
        data = LocalDate.now();
        pedidos = new ArrayList<>();
        this.mesa = mesa;
        aberto = true;
    }

    /**
     * get e set da classe pedidos
     * @return aponta e retorna os atributos da classse
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesas) {
        this.mesa = mesas;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean getStatus() {
        return aberto;
    }

    public boolean setStatus(boolean aberto) {
        this.aberto = aberto;
        return aberto;
    }

    /**
     * metodo toString que é uma representação textual da classe
     *
     */
    @Override
    public String toString() {
        return "Comanda{" +
                "pedidos=" + pedidos +
                ", aberto=" + aberto +
                ", mesa=" + mesa +
                "}\n";
    }

    /**
     *
     * @param pedido  Usa como parametro pedido e serve para adicionar pedidos a uma comanda
     * @return pedido
     */
    public boolean AdcionarPedido(Pedido pedido){
        pedido.setMesa(mesa);
      return pedidos.add(pedido);
    }
    /**
     *
     * @param numeroPedido Usa como parametro numeroPedido e serve para remover pedidos de uma comanda
     * @return pedido
     */
    public boolean removePedido(int numeroPedido) {
        if(pedidos.remove(buscarPedido(numeroPedido))!= null) {
            return true;
        }
        return false;
    }
    /**
     *
     * @param numeroPedido Usa como parametro numeroPedido e serve para buscar e informar se o pedido e o numero do pedido
     * @return i ou -1
     */
    public int buscarPedido(int numeroPedido) {
        if(!pedidos.isEmpty()) {
            for(int i=0;i<pedidos.size();i++) {
                if(pedidos.get(i).getIdPedido() == numeroPedido) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * Serve para informar o valor da comanda
     * @return total
     */
    public float valorTotal() {
        float total = 0;
        for(Pedido pedido : pedidos) {
            total += pedido.getSubtotal();
        }
        return total;
    }
}
