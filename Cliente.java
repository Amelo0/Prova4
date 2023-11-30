public class Cliente {
    private String nome;
    private String endereco;
    private String profissao;

    public Cliente(String nome, String endereco, String profissao) {
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String exibirAtributos(){
        return "Endereço: " + getEndereco() + " Nome: " + getNome() + " Profissão: " + getProfissao();
    }
}

