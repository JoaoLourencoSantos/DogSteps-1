package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 	DogWalker extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private double mediaAvaliacao;
	private String descricao;
	private ArrayList<Avaliacao> avaliacoes;
	private Preferencias preferencias;

	public DogWalker(String nome, String photoUrl, int idade, String cpf, String email, String senha, Endereco endereco,
			Agenda agenda, ArrayList<Avaliacao> avaliacoes, double mediaAvaliacao, String descricao) {
		super(nome, photoUrl, idade, cpf, email, senha, endereco, agenda);
		this.avaliacoes = avaliacoes;
		this.mediaAvaliacao = mediaAvaliacao;
		this.descricao = descricao;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Preferencias getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

	public DogWalker(){}

	public boolean estaDentroDoPoligono(List<Coordenada> coordenadas){
		Coordenada localizacao = this.getEndereco().getCoordenada();
		List<Double> latitudes = coordenadas.stream().map(x -> x.getLatitude()).collect(Collectors.toList());
		List<Double> longitudes = coordenadas.stream().map(y -> y.getLongitude()).collect(Collectors.toList());
		if(localizacao.getLatitude() > latitudes.get(0) && localizacao.getLatitude() < latitudes.get(1) && localizacao.getLongitude() > longitudes.get(0) && localizacao.getLongitude() < longitudes.get(1)){
			System.out.println(true);
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return this.getNome();
	}
}
