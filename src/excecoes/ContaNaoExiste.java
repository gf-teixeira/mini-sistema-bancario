package excecoes;
/**Classe que extende a classe Exception, é invocada sempre que uma exceção do tipo Conta Não Existe é realizada.
* @author Gabriel Teixeira
*/
public class ContaNaoExiste extends Exception{

    public ContaNaoExiste(){
        super("Conta Não Existe!");
    }
}
