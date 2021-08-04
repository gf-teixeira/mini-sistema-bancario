package transferencia;

import conta.Conta;


/**Classe que representa objetos do tipo Transferência
* @author Gabriel Teixeira
*/
public class Transferencia {

    private int valor;
    private Conta contaOrigem;
    private Conta contaDestino;
/**
 * Construtor da Classe Transferência.
 * Além de inicializar os atributos "valor", "contaOrigem" e "contaDestinO" do objeto transferência, o construtor muda o saldo das contas participantes, 
 * utilizando do método setSaldo do objeto Conta.
 * @param valor Valor da Transferência
 * @param contaOrigem Objeto Conta da conta de Origem
 * @param contaDestino Objeto Conta da conta de destino
 */
    public Transferencia(int valor, Conta contaOrigem, Conta contaDestino){
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;

        this.contaOrigem.setSaldo(this.contaOrigem.getSaldo() - valor);
        this.contaDestino.setSaldo(this.contaDestino.getSaldo() + valor);
    }

    public int getValor(){
        return this.valor;
    }
    public Conta getContaOrigem(){
        return this.contaOrigem;
    }
    public Conta getContaDestino(){
        return this.contaDestino;
    }

}
