package org.serratec.ongdeanimais.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaDTORequest {
	
	@NotBlank(message = "O nome é obrigatório.")
    @Size(max = 70, message = "O nome deve ter até 70 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;
    
    private EnderecoDTORequest endereco;
    
    

	public PessoaDTORequest() {
		super();
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

	public EnderecoDTORequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTORequest endereco) {
		this.endereco = endereco;
	}
    
    
}
