package com.simicius.user;

import java.util.UUID;

public class User {

    private String id;
    private String email;
    private String senha;

    public User(String em, String se){

        this.email = em;
        this.senha = se;

        gerarId();
    }

    private void gerarId(){

        String idGerado = UUID.randomUUID().toString();

        this.id = idGerado;
    }

    public String getId(){
        return this.id;
    }

    public void setEmail(String em){
        this.email = em;
    }

    public String getEmail(){
        return this.email;
    }

    public void setSenha(String se){
        this.senha = se;
    }

    public String getSenha(){
        return this.senha;
    }
    

@Override
public String toString(){
    return "\nDados: {ID: " + this.getId() + ", E-mail: " + this.getEmail() + ", Senha: " + this.getSenha() + "}\n";
}
    
}
