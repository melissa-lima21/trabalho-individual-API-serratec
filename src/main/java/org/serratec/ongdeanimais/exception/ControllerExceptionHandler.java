package org.serratec.ongdeanimais.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();

		for (FieldError f : ex.getBindingResult().getFieldErrors()) {
			erros.add(f.getField() + ": " + f.getDefaultMessage());
		}

		RespostaErro respostaErro = new RespostaErro(status.value(),
				"Erro de validação: verifique se todos os campos foram preenchidos corretamente.", LocalDateTime.now(),
				erros);

		return ResponseEntity.status(status).body(respostaErro);
	}

	@ExceptionHandler(SolicitacaoNaoEncontradaException.class)
	public ResponseEntity<RespostaErro> handleSolicitacaoNaoEncontrada(SolicitacaoNaoEncontradaException ex) {

		RespostaErro erro = new RespostaErro(404, ex.getMessage(), LocalDateTime.now(), new ArrayList<>());

		return ResponseEntity.status(404).body(erro);
	}

	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<RespostaErro> handleDuplicateEntry(DuplicateEntryException ex) {

		RespostaErro erro = new RespostaErro(409, ex.getMessage(), LocalDateTime.now(), new ArrayList<>());
		
		return ResponseEntity.status(409).body(erro);
	}

}
