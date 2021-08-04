package banco;

import cliente.Cliente;
import conta.Conta;
import transferencia.Transferencia;

import java.util.ArrayList;
/**Classe que representa objetos do tipo Banco
* @author Gabriel Teixeira
*/
public class Banco {
/**
 * Atributo responsável por armazenar o saldo total do banco assim que o banco é criado.
 */
    private int soma;

    public ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Conta> contas = new ArrayList<>();
    public ArrayList<Transferencia> transferencias = new ArrayList<>();

/**
 * Construtor da Classe Banco.
 * Insere dois clientes e três contas, adicionando-os nos devidos ArrayLists.
 * Por fim, calcula o somatório dos saldos de todas as contas e armazena no atributo soma.
 */
    public Banco(){
        Cliente cliente1 = new Cliente("Gabriel", 421);
        Cliente cliente2 = new Cliente("Adair", 321);

        Conta conta1 = new Conta(1, cliente1);
        Conta conta2 = new Conta(2, cliente1);
        Conta conta3 = new  Conta(3, cliente2);

        clientes.add(cliente1);
        clientes.add(cliente2);

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);

        contas.forEach(conta -> {
            soma += conta.getSaldo();
        });

    }
/**
* Método responsável por listar todos os clientes do banco
*/
    public void listaClientes(){
        clientes.forEach(cliente -> {
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
        });
    }
/**
* Método responsável por listar todas as contas do banco
*/
    public void listaContas(){
        contas.forEach(conta -> {
            System.out.println("Num: " + conta.getNumero());
            System.out.println("Cliente: " + conta.getCliente().getNome());
            System.out.println("Saldo: " + conta.getSaldo()/100);
        });
    }
/**
* Método responsável por consultar o saldo do cliente
* @param cpf CPF do cliente
*/
    public void saldoCliente(int cpf){
        int saldoCliente=0;
        for(Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                for (Conta conta : contas) {
                    if (conta.getCliente().getCpf() == cpf){
                        saldoCliente += conta.getSaldo();
                    }
                }
            }
        }
        System.out.println("CPF: " + cpf);
        System.out.println("Saldo: " + saldoCliente/100);
    }
/**
* Método responsável por consultar o saldo da conta
* @param num Número da Conta
*/
    public void saldoConta(int num) {
        int saldoConta = 0;
        for (Conta conta : contas) {
            if (conta.getNumero() == num) {
                saldoConta += conta.getSaldo();
            }
        }
        System.out.println("Num: " + num);
        System.out.println("Saldo: " + saldoConta/100);
    }
/**
* Método responsável por retornar o extrato do cliente. 
* Confere todas as transferêncais em que o cliente possui participação.
* @param cpf CPF do cliente
*/
    public void extratoCliente(int cpf) {
        transferencias.forEach(transferencia -> {
            if(transferencia.getContaOrigem().getCliente().getCpf() == cpf){
                //debitou
                System.out.println("");
                System.out.println("Valor: - R$" + transferencia.getValor()/100);
                System.out.println("Enviado para: " + transferencia.getContaDestino().getCliente().getNome());
            }
            if(transferencia.getContaDestino().getCliente().getCpf() == cpf){
                //creditou
                System.out.println("");
                System.out.println("Valor: + R$" + transferencia.getValor()/100);
                System.out.println("Enviado por: " + transferencia.getContaOrigem().getCliente().getNome());
            }
        });
    }
/**
* Método responsável por retornar o extrato da conta
* @param num Número da Conta
*/
    public void extratoConta(int num){
        transferencias.forEach(transferencia -> {
           if(transferencia.getContaOrigem().getNumero() == num){
               //debitou
               System.out.println("");
               System.out.println("Valor: - R$" + transferencia.getValor()/100);
               System.out.println("Enviado para: " + transferencia.getContaDestino().getCliente().getNome());
           }
           if(transferencia.getContaDestino().getNumero() == num){
               System.out.println("");
               System.out.println("Valor: + R$" + transferencia.getValor()/100);
               System.out.println("Enviado por: " + transferencia.getContaDestino().getCliente().getNome());
           }
        });

    }
/**
* Método responsável por realizar a transferência entre duas contas
* @param valor Valor da transferência 
* @param numContaOrigem Número da conta de origem
* @param numContaDestino Número da conta de destino
*/
    public void realizaTransferencia(int valor, int numContaOrigem, int numContaDestino){

        Conta contaOrigem = new Conta();
        Conta contaDestino = new Conta();

        for(Conta conta : contas) {
            if (conta.getNumero() == numContaOrigem) {
                contaOrigem = conta;
            }
            if (conta.getNumero() == numContaDestino){
                contaDestino = conta;
            }
        }
        Transferencia transferencia = new Transferencia(valor, contaOrigem, contaDestino);
        transferencias.add(transferencia);
        System.out.println("Transferência realizada com sucesso!");
    }
/**
* Método responsável por mostrar os saldos de todas as contas, juntamente com o saldo total.
*/
    public void mostraValores(){
        int total = 0;

        for(Conta conta : contas){
            total += conta.getSaldo();
            System.out.println("Conta: " + conta.getNumero());
            System.out.println("R$" + conta.getSaldo()/100);
        }

        System.out.println("Total: R$" + total/100);
    }

/**
* Método responsável por retornar o saldo total de todas as contas
* @return Saldo Total 
*/
    public int getSaldo(){
        int saldo = 0;
        for(Conta conta : contas){
            saldo += conta.getSaldo();
        }
        return saldo;
    }
    /**
 * Método Auxiliar - responsável por verificar se o cliente existe
 * @param cpf CPF do cliente
 * @return True caso o cliente exista - False caso não.
 */
    public boolean clienteExiste(int cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                return true;
            }
        }
        return false;
    }
/**
 * Método Auxiliar - responsável por verificar se uma conta existe
 * @param num Número da Conta
 * @return True caso exista; False caso não
 */
    public boolean contaExiste(int num){
        for(Conta conta : contas){
            if(conta.getNumero() == num){
                return true;
            }
        }
        return false;
    }
/**
 * Método Auxiliar - responsável por verificar se há saldo suficiente (compara com o valor requerido) na conta.
 * @param num Número da Conta
 * @return true caso houver saldo suficiente, false caso não houver.
 */
    public boolean verificaSaldo(int num, int valor){
        for(Conta conta : contas){
            if(conta.getNumero() == num){
                if(conta.getSaldo() < valor){
                    return false;
                }
            }
        }
        return true;
    }
}


