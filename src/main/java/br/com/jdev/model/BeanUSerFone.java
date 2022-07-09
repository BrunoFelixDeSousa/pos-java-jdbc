package br.com.jdev.model;

public class BeanUSerFone {
    public String nome;
    public String email;
    public String numero;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "BeanUserFone [nome=" + nome + ", email=" + email + ", numero=" + numero + "]";
    }
}
