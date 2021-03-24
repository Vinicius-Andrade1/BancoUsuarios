package com.simicius.dao;

import java.util.List;

import com.simicius.db.InMemoryDB;
import com.simicius.user.User;

public class UserDAOInMemoryDB implements IUserDAO{

    @Override
    public User selectUserById(String id) {

        User usuarioRetornado = null;

        if (InMemoryDB.users.size() != 0){
            for(int i = 0; i < InMemoryDB.users.size(); i++){
                if (id.equals(InMemoryDB.users.get(i).getId())){
                    usuarioRetornado = InMemoryDB.users.get(i);
                }
            }
        }
    
        return usuarioRetornado;

    }

    @Override
    public List<User> selectAllUsers() {

        /*List <User> listaUsuarios = new ArrayList<>();

        for ( int  i = 0; i < InMemoryDB.users.size(); i++){
            if (InMemoryDB.users.size() == 0){
                System.out.println("A Lista está vazia!");
            } else {
                listaUsuarios.add(InMemoryDB.users.get(i));
            }
        }*/

        return InMemoryDB.users;
        
    }

    @Override
    public void updateUser(String id, String em, String se) {

        if (InMemoryDB.users.size() != 0){
            for (int i = 0; i < InMemoryDB.users.size(); i++){
                if (id.equals(InMemoryDB.users.get(i).getId())){
                    InMemoryDB.users.get(i).setEmail(em);
                    InMemoryDB.users.get(i).setSenha(se);
                }  else {
                    System.out.println("Não foi possível achar o usuário com o id: " + id);
                }
            }
        } else {
            System.out.println("A lista está vazia! Não tem como atualizar o usuário!");
        }
        
    }
    
    @Override
    public void deleteUser(String id) {
        
        for (int i = 0; i < InMemoryDB.users.size(); i++){
            if (id.equals(InMemoryDB.users.get(i).getId())){
                InMemoryDB.users.remove(i);
            } else {
                System.out.println("Não há usuários com o id: " + id);
            }
        }
    }

    @Override
    public void createUser(User user) {

        boolean retorno;

        retorno = verificarEmail(user.getEmail());

        if (retorno == false){
            InMemoryDB.users.add(user);
            System.out.println("\nUsuário criado com sucesso!\n");
        } else {
            System.out.println("\nNão foi possível cadastrar o usuário, pois já existe um email '" + user.getEmail() + "' no nosso sistema!\n");
        }

    }

    protected boolean verificarEmail(String email){

        boolean flag = false;

        for(int i = 0; i < InMemoryDB.users.size(); i++){
            if(email.equals(InMemoryDB.users.get(i).getEmail())){
                flag = true;
            } else {
                continue;
            }
        }

        return flag;

    }

}
