package org.serratec.ongdeanimais.enums;

import org.serratec.ongdeanimais.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PerfilAnimal {

	BRINCALHAO,
	DOCIL,
	CALMO,
	ARISCO,
	AMIGAVEL;
	
	@JsonCreator
	public static PerfilAnimal verifica (String value) throws EnumValidationException{
		for (PerfilAnimal p : values() ) {
			if(value.equals(p.name())) {
				return p;
			}
		}
		throw new EnumValidationException(
				"Perfil inválido. Valores válidos: BRINCALHAO, DOCIL, CALMO, ARISCO, AMIGAVEL");
			
	}
}
