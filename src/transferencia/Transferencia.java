package transferencia;

import conta.Conta;

public class Transferencia {

    private int valor;
    private Conta contaOrigem;
    private Conta contaDestino;

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
