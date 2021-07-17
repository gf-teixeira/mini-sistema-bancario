package excecoes;

public class ClienteNaoExiste extends Exception{

    public ClienteNaoExiste(int cpf){
        super(cpf + ": Cliente Não Existe!");
    }
}
