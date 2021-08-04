package excecoes;
/**Classe que extende a classe Exception, é invocada sempre que uma exceção do tipo Balanço Inválido é realizada.
* @author Gabriel Teixeira
*/
public class BalancoInvalido extends Exception{
    public BalancoInvalido(){
        super("Balanço do Banco Inválido!");
    }
}
