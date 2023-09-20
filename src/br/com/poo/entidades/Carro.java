package br.com.poo.entidades;

public class Carro {
    private String carTxModelo;
    private String carTxDisponibilidade;
    private String carTxMarca;
    private String carTxPlaca;
    private String carTxCor;
    private double carTxPreco;

    public Carro(String carTxModelo, String carTxDisponibilidade, String carTxMarca, String carTxPlaca, String carTxCor, double carTxPreco) {
        this.carTxModelo = carTxModelo;
        this.carTxDisponibilidade = carTxDisponibilidade;
        this.carTxMarca = carTxMarca;
        this.carTxPlaca = carTxPlaca;
        this.carTxCor = carTxCor;
        this.carTxPreco = carTxPreco;
    }
    
    
    public String getCarTxModelo() {
		return carTxModelo;
	}



	public void setCarTxModelo(String carTxModelo) {
		this.carTxModelo = carTxModelo;
	}



	public String getCarTxDisponibilidade() {
		return carTxDisponibilidade;
	}



	public void setCarTxDisponibilidade(String carTxDisponibilidade) {
		this.carTxDisponibilidade = carTxDisponibilidade;
	}



	public String getCarTxMarca() {
		return carTxMarca;
	}



	public void setCarTxMarca(String carTxMarca) {
		this.carTxMarca = carTxMarca;
	}



	public String getCarTxPlaca() {
		return carTxPlaca;
	}



	public void setCarTxPlaca(String carTxPlaca) {
		this.carTxPlaca = carTxPlaca;
	}



	public String getCarTxCor() {
		return carTxCor;
	}



	public void setCarTxCor(String carTxCor) {
		this.carTxCor = carTxCor;
	}



	public double getCarTxPreco() {
		return carTxPreco;
	}



	public void setCarTxPreco(double carTxPreco) {
		this.carTxPreco = carTxPreco;
	}


	@Override
    public String toString() {
        return "Carro [Modelo: " + carTxModelo + ", Disponibilidade: " + carTxDisponibilidade +
               ", Marca: " + carTxMarca + ", Placa: " + carTxPlaca + ", Cor: " + carTxCor + ", Preço: " + carTxPreco + "]";
    }
}
