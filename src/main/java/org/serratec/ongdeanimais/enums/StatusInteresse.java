package org.serratec.ongdeanimais.enums;

import org.serratec.ongdeanimais.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusInteresse {
	APROVADO,
	PENDENTE,
	RECUSADO,
	CANCELADO;

	@JsonCreator
	public static StatusInteresse verifica (String value) throws EnumValidationException{
		for (StatusInteresse s : values() ) {
			if(value.equals(s.name())) {
					return s;
			}
	}
		throw new EnumValidationException(
				"Status inválido. Valores válidos: APROVADO, PENDENTE, RECUSADO, CANCELADO.");
			
	}
}


