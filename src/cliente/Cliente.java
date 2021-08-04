package cliente;

/**Classe que representa objetos do tipo Cliente
* @author Gabriel Teixeira
*/
public class Cliente {
    private int cpf;
    private String nome;
    
/**
 * Construtor da Classe Cliente
 * Inicializa os atributos "nome" e "cpf"
 * @param nome Nome do Cliente
 * @param cpf CPF do Cliente
 */
    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
