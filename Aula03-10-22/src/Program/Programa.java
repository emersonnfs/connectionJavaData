package Program;

import model.Cliente;
import model.ContaBancaria;
import Service.ClienteContaService;
import Service.ContaBancariaService;
import java.util.Random;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int option,id, idade;
		String nome, email,agencia,conta;
		double saldo;
		do {
			System.out.println("=======================================================");
			System.out.println("====================== CADASTRO =======================");
			System.out.println("=======================================================");
			System.out.println("ESCOLHA UMA OPÇÃO:");
			System.out.println("1-CADASTRAR CLIENTE");
			System.out.println("2-ATUALIZAR CLIENTE");
			System.out.println("3-EXCLUIR CLIENTE");
			System.out.println("4-LISTAR CLIENTES");
			System.out.println("5-LISTAR UM CLIENTE");
			System.out.println("\n\nDIGITE A OPÇÃO DESEJADA: ");
			option = scan.nextInt();
			
			Cliente cli = new Cliente();
			ContaBancaria cb= new ContaBancaria();
			
			if (option==1) {
				System.out.printf("DIGITE O NOME DO CLIENTE: ");
				nome = scan.next();
				cli.setNome(nome);
				
				System.out.printf("\nDIGITE O EMAIL DO CLIENTE: ");
				email = scan.next();
				cli.setEmail(email);
				
				System.out.printf("\nDIGITE A IDADE DO CLIENTE: ");
				idade = scan.nextInt();
				cli.setIdade(idade);
				
				agencia=("1234");
				cb.setAgencia(agencia);
				
				int n = rand.nextInt(9999);
				cb.setConta(Integer.toString(n));
				
				ContaBancariaService.InserirConta(cb);
				ClienteContaService.InserirCliente(cli);
				System.out.printf("=========== CLIENTE ADICIONADO COM SUCESSO ============\n");
				System.out.printf("NOME DO CLIENTE: %s\n",nome);
				System.out.printf("EMAIL DO CLIENTE: %s\n",email);
				System.out.printf("IDADE DO CLIENTE: %d\n",idade);
				System.out.printf("AGENCIA: 1234\n");
				System.out.printf("CONTA: %d\n",n);
				System.out.printf("=======================================================\n");
			}else if(option==2) {
				
				System.out.printf("DIGITE O ID DO CLIENTE QUE DESEJA ATUALIZAR:");
				id=scan.nextInt();
				ClienteContaService.ExibirCliente(id);

				cli.setId(id);
				System.out.printf("DIGITE O NOME DO CLIENTE: ");
				cli.setNome(scan.next());
				
				System.out.printf("\nDIGITE O EMAIL DO CLIENTE: ");
				cli.setEmail(scan.next());
				
				System.out.printf("\nDIGITE A IDADE DO CLIENTE: ");
				cli.setIdade(scan.nextInt());
				
				System.out.printf("=========== CLIENTE ATUALIZADO COM SUCESSO ============\n");
				System.out.printf("NOME DO CLIENTE: %s\n",cli.getNome());
				System.out.printf("EMAIL DO CLIENTE: %s\n",cli.getEmail());
				System.out.printf("IDADE DO CLIENTE: %d\n",cli.getIdade());
				System.out.printf("=======================================================\n");
				
				ClienteContaService.AtualizarCliente(cli);
			}else if(option==3) {
				System.out.printf("DIGITE O ID DO CLIENTE QUE GOSTARIA DE EXCLUIR: ");
				ClienteContaService.ExcluirCliente(scan.nextInt());
				ContaBancariaService.ExcluirConta(scan.nextInt());
				System.out.printf("\nCLIENTE EXCLUIDO COM SUCESSO!");
				
			}else if(option==4) {
				ClienteContaService.ExibirClientes();
			}else if(option==5) {
				System.out.printf("DIGITE O ID DO CLIENTE QUE GOSTARIA DE VIZUALIZAR: ");
				ClienteContaService.ExibirCliente(scan.nextInt());
			}
			
		}while (option >0 && option <6);
	}
}
