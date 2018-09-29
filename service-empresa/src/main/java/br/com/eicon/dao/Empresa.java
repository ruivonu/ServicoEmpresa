package br.com.eicon.dao;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa {
	@Column
	@NotNull
	private String cnpj;
	@Column
	@Id
	@NotNull
	private String im;
	@Column
	@NotNull
	private String razaosocial;
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dtabertura;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dtencerramento;
	@Column
	@NotNull
	private String endereco;
	@Column
	@NotNull
	private int situacao;
	@Column
	@NotNull
	private int ativo;

	public Empresa(String cnpj2, String im2, String razao, Date dtAbertura2, Date dtEncerramento2, String endereco2,
			int situacao2, int ativo2) {
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getRazaosocial() {
		return razaosocial;
	}
	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}
	public Date getDtabertura() {
		return dtabertura;
	}
	public void setDtabertura(Date dtabertura) {
		this.dtabertura = dtabertura;
	}
	public Date getDtencerramento() {
		return dtencerramento;
	}
	public void setDtencerramento(Date dtencerramento) {
		this.dtencerramento = dtencerramento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
}
