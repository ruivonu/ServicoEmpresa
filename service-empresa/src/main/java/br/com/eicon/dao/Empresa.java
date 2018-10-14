package br.com.eicon.dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eicon.dao.dto.EmpresaDTO;

@Entity
@Table(name = "EMPRESA",schema = "PUBLIC", uniqueConstraints=@UniqueConstraint(columnNames="IM"))
public class Empresa {
	@Column(name = "cnpj")
	@NotNull(message = "O CNPJ deve ser informado")
	private String cnpj;
	@Column(name = "im")
	@Id
	@NotNull(message = "A incrição municipal deve ser informada")
	private String im;
	@Column(name = "razaosocial")
	@NotNull(message = "A razão social deve ser informada")
	private String razaosocial;
	@Column(name = "dtabertura")
	@NotNull(message = "A data de abertura deve ser informada")
	//@Temporal(TemporalType.DATE)
	private LocalDate dtabertura;
	@Column(name = "dtencerramento")
	//@Temporal(TemporalType.DATE)
	private LocalDate dtencerramento;
	@Column(name = "endereco")
	@NotNull(message = "O endereço deve ser informado")
	@Size(min = 1, max = 500, message = "O endereço deve ter no máximo 500 caracteres")
	private String endereco;
	@Column(name = "situacao")
	@NotNull(message = "A situação deve ser informada")
	private int situacao;
	@Column(name = "ativo")
	@NotNull(message = "O status deve ser informado")
	private int ativo;

	public static Empresa fromDTO(EmpresaDTO empresaDTO){
		Empresa empresa = new Empresa();
		empresa.cnpj 			= empresaDTO.getCnpj();
		empresa.im 	 			= empresaDTO.getIm();
		empresa.razaosocial 	= empresaDTO.getRazaosocial();
		empresa.dtabertura  	= empresaDTO.getDtabertura();
		empresa.dtencerramento 	= empresaDTO.getDtencerramento();
		empresa.endereco 		= empresaDTO.getEndereco();
		empresa.situacao 		= empresaDTO.getSituacao();
		empresa.ativo 			= empresaDTO.getAtivo();
		
		return empresa;
	}
	
	@Override
	public String toString() {
		return "Empresa{" + "cnpj=" + cnpj + ", im='" + im + '\'' + ", razaosocial=" + razaosocial
        + ", dtabertura=" + dtabertura + ", dtencerramento=" + dtencerramento + ", endereco=" + endereco 
        + ", situacao='" + situacao + '\'' + ", ativo='" + ativo + '}';
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getIm() {
		return im;
	}
	
	public String getRazaosocial() {
		return razaosocial;
	}
	
	public LocalDate getDtabertura() {
		return dtabertura;
	}
	
	public LocalDate getDtencerramento() {
		return dtencerramento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public int getSituacao() {
		return situacao;
	}
	
	public int getAtivo() {
		return ativo;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public void setDtabertura(LocalDate dtabertura) {
		this.dtabertura = dtabertura;
	}

	public void setDtencerramento(LocalDate dtencerramento) {
		this.dtencerramento = dtencerramento;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
}
