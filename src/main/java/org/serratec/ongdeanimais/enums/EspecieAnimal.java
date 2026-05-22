package org.serratec.ongdeanimais.enums;

import org.serratec.ongdeanimais.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EspecieAnimal {

	GATO,
	CACHORRO;

	@JsonCreator
	public static EspecieAnimal verifica (String value) throws EnumValidationException{
		for (EspecieAnimal e : values() ) {
			if(value.equals(e.name())) {
					return e;
			}
	}
		throw new EnumValidationException(
				"Espécie inválida. Espécieis válidas: GATO e CACHORRO.");
			
	}
}

