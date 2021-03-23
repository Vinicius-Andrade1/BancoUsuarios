package com.simicius;

import java.util.List;
import java.util.Scanner;

import com.simicius.dao.UserDAOInMemoryDB;
import com.simicius.db.InMemoryDB;
import com.simicius.user.User;

public class Simicius {
    public static void main (String [] args) {
       
        UserDAOInMemoryDB acessor = new UserDAOInMemoryDB();

        Scanner scan = new Scanner(System.in);

        int opcoes = 0;

        do{
        System.out.println("---------- MENU ----------");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Consultar Usuário");
        System.out.println("3 - Remover Usuário");
        System.out.println("4 - Atualizar Usuário");
        System.out.println("5 - Mostrar Usuários");
        System.out.println("6 - Sair");
        System.out.print("\nDigite sua opção: ");
        opcoes = scan.nextInt();
        String fix = scan.nextLine();

        switch(opcoes){

            case 1:
                String email;
                String senha;

                System.out.print("Digite seu E-mail: ");
                email = scan.nextLine();

                System.out.print("Digite sua Senha: ");
                senha = scan.nextLine();

                User usuario = new User(email, senha);

                if (acessor.verificarEmail(email)){
                    acessor.createUser(usuario);
                    System.out.println("\nUsuário criado com sucesso!\n");
                } else {
                    System.out.println("\nNão foi possível cadastrar o usuário, pois já existe um email '" + email + "' no nosso sistema!");
                }

            break;

            case 2:
                String id;
                User retorno;

                System.out.print("Digite o ID que você quer buscar: ");
                id = scan.nextLine();

                retorno = acessor.selectUserById(id);

                if(retorno == null){
                    System.out.println("ID não encontrado!\n");
                } else {
                System.out.println("Usuário Encontrado!\n");
                System.out.println(retorno);
                }

            break;

            case 3:

                System.out.print("Digite o ID que você quer buscar: ");
                id = scan.nextLine();

                System.out.println("Usuário removido com sucesso!");
                acessor.deleteUser(id);

            break;

            case 4:
                System.out.print("Digite o ID: ");
                id = scan.nextLine();

                User usuario1 = acessor.selectUserById(id);    

                if (usuario1 == null){
                    System.out.println("\nUsuário não encontrado!\n");
                } else {

                    System.out.print("Digite seu novo E-mail: ");
                    email = scan.nextLine();

                    System.out.print("Digite sua nova Senha: ");
                    senha = scan.nextLine();

                    acessor.updateUser(id, email, senha);

                    System.out.println("\nUsuário atualizado com sucesso!\n");
                }
            break;

            case 5:
                if (acessor.selectAllUsers().isEmpty()){
                    System.out.println("\nA lista está vazia!\n");
                } else {
                    List <User> usuarios = acessor.selectAllUsers();
                    // try{
                    // System.out.println(usuarios.get(100).toString());
                    // } catch (Exception e){
                    //     System.out.println("Oi");
                    // }
                    for (int i = 0; i < usuarios.size(); i++){
                        System.out.println(usuarios.get(i).toString());
                    }
                }

            break;

            case 6:
            System.out.println("\nVocê está saindo do programa.....\n");

            break;

            default:
            System.out.println("\nOpção inválida!\n");

            break;
        }

        } while(opcoes != 6);
    }   
}
