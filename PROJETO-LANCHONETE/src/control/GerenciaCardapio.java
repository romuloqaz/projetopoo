package control;

import model.Produto;

import java.util.ArrayList;

import static view.App.isCadastrarProduto;

/**
 * A classe <b>GerenciaCardapio</b> contém os métodos da classe para serem usados no domínio da aplicação.
 * Usada para cadastrar produtos do domínio.
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class GerenciaCardapio {
    private ArrayList<Produto> produtos;
    private Produto ProdutoTeste;

    /**
     * A classe inicializa uma estrutura arraylist com vários produtos
     */

    public GerenciaCardapio() {
        produtos = new ArrayList<>();
    }

    /**
     * Metodo lista os produtos cadastrados
     * @return produtos
     */

    public ArrayList<Produto> listar(){
        return produtos;
    }

    /**
     *
     * @param codProduto indica o codigo do produto cadastrado
     * Metodo percorre a lista de produtos e informa a posição do pedido
     * @return posição do produto
     */
    int Buscar(int codProduto){
        if(produtos.isEmpty())
            return -1;
        for(int i = 0; i<produtos.size();i++) {
            if(produtos.get(i).getCodProduto() == codProduto) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param codigo indica o codigo que referencia o produto
     * @return um produto escolhido ou null
     */

    public Produto retornaProduto(int codigo) {
        for(Produto p: produtos) {
            if(p.getCodProduto() == codigo)
                return p;
        }
        return null;
    }

    /**
     *
     * @param produto indica o produto
     * Metodo Salva os produtos
     * @return produto adicionado
     */
    public boolean Salvar(Produto produto){
        if(Buscar(produto.getCodProduto()) >=0 ) {
            return false;
        }
        return produtos.add(produto);
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto e o remove
     * @return o produto removido
     */

    public boolean isRemover(int codProduto){
        if (Buscar(codProduto) < 0){
            System.out.println("Produto Inexistente");
        }
        return produtos.remove(retornaProduto(codProduto));
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto para ser editado remove o antigo e cadastra o novo
     * @return o produto editado
     */
    public boolean isEdit(int codProduto){
        if (Buscar(codProduto) < 0){
            return false;
        }
        isRemover(Buscar(codProduto));
        return Salvar(isCadastrarProduto());
    }
}
