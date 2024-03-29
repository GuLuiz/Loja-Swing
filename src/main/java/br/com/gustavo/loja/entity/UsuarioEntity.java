package br.com.gustavo.loja.entity;

public class UsuarioEntity {

    private Integer usuarioId;
    private String nome;
    private String email;
    private String senha;


    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public UsuarioEntity(Integer id, String nome, String email, String senha){
        this.usuarioId= id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Integer getUsuarioId(){
        return usuarioId;
    }
}