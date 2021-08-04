package excecoes;
/**Classe que extende a classe Exception, é invocada sempre que uma exceção do tipo Saldo Insuficiente é realizada.
* @author Gabriel Teixeira
*/
public class SaldoInsuficiente extends Exception{
    public SaldoInsuficiente(){
        super("Saldo Insuficiente!");
    }
}
