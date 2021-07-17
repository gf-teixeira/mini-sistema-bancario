package operador;

import cliente.Cliente;
import conta.Conta;

import java.util.ArrayList;

public class Utils {

    public boolean clienteExiste(int cpf, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                return true;
            }
        }
        return false;
    }

    public boolean contaExiste(int num, ArrayList<Conta> contas){
        for(Conta conta : contas){
            if(conta.getNumero() == num){
                return true;
            }
        }
        return false;
    }

    public boolean verificaSaldo(int num, int valor, ArrayList<Conta> contas){
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
