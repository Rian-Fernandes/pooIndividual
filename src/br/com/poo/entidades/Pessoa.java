package br.com.poo.entidades;

public class Pessoa {
    private String pesTxNome;
    private String pesTxSobrenome;
    private String pesTxCpf;
    private String pesTxContato;
    private String pesTxEmail;

    public Pessoa(String pesTxNome, String pesTxSobrenome, String pesTxCpf, String pesTxContato, String pesTxEmail) {
        this.pesTxNome = pesTxNome;
        this.pesTxSobrenome = pesTxSobrenome;
        this.pesTxCpf = pesTxCpf;
        this.pesTxContato = pesTxContato;
        this.pesTxEmail = pesTxEmail;
    }


    public String getPesTxNome() {
		return pesTxNome;
	}


	public void setPesTxNome(String pesTxNome) {
		this.pesTxNome = pesTxNome;
	}


	public String getPesTxSobrenome() {
		return pesTxSobrenome;
	}


	public void setPesTxSobrenome(String pesTxSobrenome) {
		this.pesTxSobrenome = pesTxSobrenome;
	}


	public String getPesTxCpf() {
		return pesTxCpf;
	}


	public void setPesTxCpf(String pesTxCpf) {
		this.pesTxCpf = pesTxCpf;
	}


	public String getPesTxContato() {
		return pesTxContato;
	}


	public void setPesTxContato(String pesTxContato) {
		this.pesTxContato = pesTxContato;
	}


	public String getPesTxEmail() {
		return pesTxEmail;
	}


	public void setPesTxEmail(String pesTxEmail) {
		this.pesTxEmail = pesTxEmail;
	}


	@Override
    public String toString() {
        return "Pessoa [Nome: " + pesTxNome + ", Sobrenome: " + pesTxSobrenome +
               ", CPF: " + pesTxCpf + ", Contato: " + pesTxContato + ", Email: " + pesTxEmail + "]";
    }
}
