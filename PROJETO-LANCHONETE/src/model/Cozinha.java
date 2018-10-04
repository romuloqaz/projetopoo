package model;

import control.GerenciaComanda;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe <b>Cozinha</b> modela a entidade <b>Cozinha</b> onde terão os métodos da classe
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */
public class Cozinha {
    private List<Pedido> pedidos;

    /**
     * A classe <b>cozinha</b> contém a estrutura de dados lista onde os pedidos seriam armazenados
     */
    public Cozinha() {
        pedidos = new ArrayList<>();
    }


    /**
     *
     * @param pedido
     * @return adiciona pedidos ao array de pedidos
     */
    public boolean addnaCozinha(Pedido pedido){
        return pedidos.add(pedido);
    }

    /**
     *
     * @param idPedido indica o id do pedido
     * @param gC referência da classe GerenciaCOmanda
     * Usa como referência o idPedido e GerenciaComanda e o metodo adiciona o pedido a uma mesa.
     * @return o Pedido
     */
    public boolean AtenderPedido(int idPedido, GerenciaComanda gC) {
        if (buscar(idPedido) == -1){
            return false;
        }
        int mesa = pedidos.get(buscar(idPedido)).getMesa();
        gC.FecharPedido(gC,idPedido,mesa);
        return pedidos.remove(pedidos.get(buscar(idPedido)));
    }

    /**
     *
     * @param idPedido indica o numero do pedido
     * Usa como referencia o idPedido e busca se tem pedidos armazenados
     * @return se tem ou nao pedidos armazenados
     */
    int buscar(int idPedido) {
        if(!pedidos.isEmpty()) {
            for(int i = 0; i<pedidos.size(); i++) {
                if(pedidos.get(i).getIdPedido() == idPedido) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Percorre a estrutura de Pedido e retorna o Pedido
     * @return o pedido
     */
    public String verPedido(){
        String pedido = "";
        for (Pedido p: pedidos) {
            pedido+= "Mesa: "+p.getMesa()+" Pedido: "+p.getIdPedido()+p.toString();
        }
        return pedido;
    }

}