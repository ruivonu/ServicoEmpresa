package br.com.eicon.dao.dto;

import java.time.LocalDate;
import br.com.eicon.dao.Empresa;

public class EmpresaDTO {
	private String cnpj;
	private String im;
	private String razaosocial;
	private LocalDate dtabertura;
	private LocalDate dtencerramento;
	private String endereco;
	private int situacao;
	private int ativo;
	
	public static EmpresaDTO fromEntity(Empresa empresa) {
		EmpresaDTO EmpresaDTO = new EmpresaDTO();
	    EmpresaDTO.cnpj = empresa.getCnpj();
	    EmpresaDTO.im = empresa.getIm();
	    EmpresaDTO.razaosocial = empresa.getRazaosocial();
	    EmpresaDTO.dtabertura = empresa.getDtabertura();
	    EmpresaDTO.dtencerramento = empresa.getDtencerramento();
	    EmpresaDTO.endereco = empresa.getEndereco();
	    EmpresaDTO.situacao = empresa.getSituacao();
	    EmpresaDTO.ativo = empresa.getAtivo();
	
	    return EmpresaDTO;
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
	
}