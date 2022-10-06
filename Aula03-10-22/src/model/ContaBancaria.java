package model;

public class ContaBancaria {
	private String agencia,conta;
	private double saldo;
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public ContaBancaria(){
		
	}
	
	public ContaBancaria(String agencia, String conta, double saldo){
		this.agencia=agencia;
		this.conta=conta;
		this.saldo=saldo;
	}
}
