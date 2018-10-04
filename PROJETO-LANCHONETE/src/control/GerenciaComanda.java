package control;

import model.Comanda;
import model.Cozinha;
import model.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <b>GerenciaComanda</b>  contém métodos para a gerencia das comandas do domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class GerenciaComanda {

    /**
     * A classe inicializa uma estrutura ArrayList de Comanda para a gerencia das comandas
     */

    private List<Comanda> comandas;

    public GerenciaComanda() {
        comandas = new ArrayList<>();
    }

    /**
     *
     * @param mesa indica a mesa a ser atendida
     * Metodo adiciona uma nova comanda a uma mesa
     * @return comanda adicionada a uma mesa
     */
    public boolean NovaComanda(int mesa){
        if (BuscarMesas(mesa) != -1){
            return false;
        }
        return comandas.add(new Comanda(mesa));
    }


    /**
     * Lista as comandas adicionadas
     * @return comandas
     */
    public List<Comanda> VerComandas(){
        return comandas;
    }

    /**
     *
     * @param mesa indica uma mesa a ser atendida
     * Metodo percorre as mesas que estao sendo atendidas
     * @return numero da mesa
     */
    public int BuscarMesas(int mesa){
        if (!comandas.isEmpty()){
            for (int i = 0 ;i<comandas.size();i++){
                if (comandas.get(i).getMesa() == mesa){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param mesa indica uma mesa
     * @param pedido pedido a ser atendido
     * Metodo adiciona um novo pedido a comanda
     * @return comanda com pedidos
     */

    public boolean NovoPedido(int mesa, Pedido pedido, Cozinha cozinha){
        if (BuscarMesas(mesa) != -1){
            cozinha.addnaCozinha(pedido);
            return comandas.get(BuscarMesas(mesa)).AdcionarPedido(pedido);
        }
        return false;
    }

    /**
     *
     * @param mesa indica uma mesa
     * Metodo mostra os pedidos na comanda
     * @return comanda com pedidos
     */
    public String VerPedidos(int mesa){
        return comandas.toString();
    }

    /**
     *
     * @param mesa indica uma mesa
     * Método remove uma comanda atendida
     * @return comanda fechada
     */
    public boolean FecharComanda(int mesa){
        if (BuscarMesas(mesa) == -1){
            return false;
        }
        if (comandas.get(BuscarMesas(mesa)).getData().isBefore(comandas.get(BuscarMesas(mesa)).getData().plusDays(2))){
            return false;
        }
        for (Pedido pedido: comandas.get(BuscarMesas(mesa)).getPedidos()) {
            if(pedido.getStatus() == true){
                return false;
            }
        }
        return Gerencia.adicionarGerencia(comandas.remove(BuscarMesas(mesa)));
    }

    /**
     *
     * @param mesa indica uma mesa do estabelecimento
     * @param pedido indica o pedido feito
     * Método exclui um pedido de uma comanda
     * @return pedido excluido
     */
    public boolean ExcluirPedido(int mesa, Pedido pedido){
        for (int i = 0; i < comandas.size(); i++) {
            if (pedido.getStatus() == false){
                if (BuscarMesas(mesa) > 0){
                    if (pedido.getIdPedido() == i){
                        return comandas.get(BuscarMesas(mesa)).getPedidos().remove(pedido);
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param gC indica classe gerencia comanda/////
     * @param idPedido indica o numero do pedido
     * @param mesa indica mesa do estabelecimento
     * Método fecha um pedido
     * @return pedido fechado
     */
    public boolean FecharPedido(GerenciaComanda gC,int idPedido, int mesa){
      if (gC.BuscarMesas(mesa) >= 0){
          return comandas.get(BuscarMesas(mesa)).getPedidos().get(buscarPedido(mesa,idPedido)).setStatus(false);
      }
      return false;
    }

    public int buscarPedido(int mesa, int idPedido){
        if (!comandas.isEmpty()){
            for (int i = 0 ;i<comandas.size();i++){
                if (comandas.get(i).getMesa() == mesa){
                    Comanda comandaUnica = comandas.get(i);
                    for(int j = 0; j<comandaUnica.getPedidos().size();j++){
                        if (comandaUnica.getPedidos().get(j).getIdPedido() == idPedido){
                            return j;
                        }
                    }

                }
            }
        }
        return -1;
    }


}
