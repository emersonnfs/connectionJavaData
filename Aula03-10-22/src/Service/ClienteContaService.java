package Service;

import model.Cliente;
import model.ContaBancaria;
import Dao.Dao;
import java.sql.ResultSet;
import Service.ContaBancariaService;

public class ClienteContaService {
	public static void InserirCliente(Cliente c) {
		String query = String.format("SELECT MAX(ID_CLIENTE) AS ID_CLIENTE FROM T_CLIENTE");
		ResultSet rs = Dao.SelectCommand(query);
		 try {
			 int id = -1;
	         while(rs.next()){
	             id = rs.getInt("ID_CLIENTE");
	         }
	                    
	         id++;

	         query=String.format("INSERT INTO T_CLIENTE(ID_CLIENTE,NOME,EMAIL,IDADE,ID_CONTA) VALUES (%s,'%s','%s',%s,%s)",id,c.getNome(),c.getEmail(),c.getIdade(),id);
	         Dao.InsertUpdateDeleteCommand(query);
		} catch (Exception e) { 
            System.out.println(e);
		}
	}
	
	public static void AtualizarCliente(Cliente c) {
        String query = String.format("UPDATE T_CLIENTE SET NOME='%s',EMAIL='%s',IDADE =%s WHERE ID_CLIENTE = %s", c.getNome(),c.getEmail(),c.getIdade(),c.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }
	
	public static void ExcluirCliente(int id) {
        String query = String.format("DELETE FROM T_CLIENTE WHERE ID_CLIENTE = %s", id);
        Dao.InsertUpdateDeleteCommand(query);  
    }
	
	public static void ExibirClientes() {
        String queryCliente= "SELECT * FROM T_CLIENTE";
       
        ResultSet rsC = Dao.SelectCommand(queryCliente);
        try {
            while(rsC.next()){
                System.out.println(rsC.getString("ID_CLIENTE"));
                System.out.println(rsC.getString("NOME"));
                System.out.println(rsC.getString("EMAIL"));
                System.out.println(rsC.getString("IDADE"));
                ContaBancariaService.ExibirConta(Integer.parseInt(rsC.getString("ID_CLIENTE")));    
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
    }

	public static void ExibirCliente(int id) {
        String queryCliente= String.format("SELECT * FROM T_CLIENTE WHERE ID_CLIENTE = %s",id);
       
        ResultSet rsC = Dao.SelectCommand(queryCliente);
        try {
            while(rsC.next()){
                System.out.println(rsC.getString("ID_CLIENTE"));
                System.out.println(rsC.getString("NOME"));
                System.out.println(rsC.getString("EMAIL"));
                System.out.println(rsC.getString("IDADE"));
                ContaBancariaService.ExibirConta(Integer.parseInt(rsC.getString("ID_CLIENTE")));
            }   
        }
        catch (Exception e){
                System.out.println(e);
        }  
    }
}
