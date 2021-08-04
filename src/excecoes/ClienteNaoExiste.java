package excecoes;
/**Classe que extende a classe Exception, é invocada sempre que uma exceção do tipo Cliente Não Existe é realizada.
* @author Gabriel Teixeira
*/
public class ClienteNaoExiste extends Exception{

    public ClienteNaoExiste(){
        super("Cliente Não Existe!");
    }
}
