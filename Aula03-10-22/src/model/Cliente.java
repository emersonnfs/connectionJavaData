package model;

public class Cliente {
	private int id, idade;
	private String nome, email;
	private ContaBancaria conta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
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
	public ContaBancaria getConta() {
		return conta;
	}
	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
	public Cliente () {
		
	}
	public Cliente (int id, int idade, String nome, String email, ContaBancaria conta) {
		this.conta=conta;
		this.email=email;
		this.id=id;
		this.idade=idade;
		this.nome=nome;
	}
}
