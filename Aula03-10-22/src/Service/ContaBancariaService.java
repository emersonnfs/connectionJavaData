package Service;

import java.sql.ResultSet;

import Dao.Dao;
import model.ContaBancaria;

public class ContaBancariaService {
	public static void InserirConta(ContaBancaria cb) {
		String query = String.format("SELECT MAX(ID_CONTA) AS ID_CONTA FROM T_CONTA_BANCARIA");
		ResultSet rs = Dao.SelectCommand(query);
		 try {
			 int id = -1;
	         while(rs.next()){
	             id = rs.getInt("ID_CONTA");
	         }
	                    
	         id++;
	         
	         query=String.format("INSERT INTO T_CONTA_BANCARIA(ID_CONTA, AGENCIA, CONTA, SALDO) VALUES (%s,'%s','%s',%s)",id,cb.getAgencia(),cb.getConta(),0);
	         Dao.InsertUpdateDeleteCommand(query);
	         
		} catch (Exception e) { 
            System.out.println(e);
		}
	}
	
	public static void ExcluirConta(int id) {
        String query = String.format("DELETE FROM T_CONTA_BANCARIA WHERE ID_CONTA = %s", id);
        Dao.InsertUpdateDeleteCommand(query); 
    }
	
	public static void ExibirConta(int id) {
        String queryConta=String.format("SELECT * FROM T_CONTA_BANCARIA WHERE ID_CONTA = %s",id);
        ResultSet rsCB=Dao.SelectCommand(queryConta);
        try {
            while(rsCB.next()){
                System.out.println(rsCB.getString("ID_CONTA"));
                System.out.println(rsCB.getString("AGENCIA"));
                System.out.println(rsCB.getString("CONTA"));
                System.out.println(rsCB.getString("SALDO"));
            }
        }
        catch (Exception e){
        	System.out.println(e);
        }
	}  
}
