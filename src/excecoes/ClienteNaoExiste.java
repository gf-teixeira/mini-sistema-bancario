package excecoes;

public class ClienteNaoExiste extends Exception{

    public ClienteNaoExiste(){
        super("Cliente Não Existe!");
    }
}
