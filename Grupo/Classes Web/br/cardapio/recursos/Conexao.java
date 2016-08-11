package br.cardapio.recursos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
	public static Connection getConexao() {  
        try {  
            // Carregando o JDBC Driver padr�o  
            String driverName = "com.mysql.jdbc.Driver";                          
            Class.forName(driverName);  
            // Configurando a nossa conex�o com um banco de dados//  
            String serverName = "localhost";    //caminho do servidor do BD  
            String mydatabase ="bd_cardapio";        //nome do seu banco de dados  
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;  
            String username = "root";        //nome de um usu�rio de seu BD        
            String password = "root";      //sua senha de acesso  
            Connection connection = DriverManager.getConnection(url, username, password);  
         
            return connection;  
        }  catch (ClassNotFoundException e) {  //Driver n�o encontrado  
            System.out.println("O driver expecificado nao foi encontrado.");  
            return null;  
        } catch (SQLException e) {  
            //N�o conseguindo se conectar ao banco  
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");  
            return null;  
        }  
	}	
	
}
