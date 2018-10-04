package control;

import model.Comanda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <b>Gerencia</b> contém os métodos da classe para serem usados no domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class Gerencia {

    /**
     * A classe inicializa uma estrutura lista com várias comandas para serem gerenciadas
     */
    private static List<Comanda> gerencia = new ArrayList<>();

    /**
     *
     * @param com indica a comanda a ser gerenciada
     * Método adiciona comandas para serem gerenciadas
     * @return comanda a ser gerenciada
     */
    public static boolean adicionarGerencia(Comanda com) {
        return gerencia.add(com);
    }

    /**
     *
     * @param inicio indica o inicio do atendimento
     * @param fim indica o fim do atendimento
     * Método lista comandas gerenciadas
     * @return comandas a serem gerenciadas
     */
    public static String listarComandas(LocalDate inicio, LocalDate fim) {
        String com = "";
        for (Comanda comanda : gerencia) {
            if (comanda.getData().isAfter(inicio.plusDays(-1)) && comanda.getData().isBefore(fim.plusDays(1))) {
                com += comanda.toString();
            }
        }
        return com;
    }

    /**
     *
     * @param inicio indica o início do atendimento
     * @param fim indica o fim do atendimento
     * Método retorna o lucro total das comandas
     * @return lucro das comandas
     */
    public static float lucroTotal(LocalDate inicio, LocalDate fim){
        float lucro = 0f;
        for (Comanda comanda: gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)){
                lucro+= comanda.valorTotal();
            }
        }
        return lucro;
    }
}
