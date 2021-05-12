package com.candidatos.candidatos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidatos.candidatos.error.ResourceNotFoundException;
import com.candidatos.candidatos.model.Candidato;
import com.candidatos.candidatos.model.CartaoCredito;
import com.candidatos.candidatos.repository.CandidatoRepository;
import com.candidatos.candidatos.repository.CartaoCreditoRepository;

@RestController
@RequestMapping("/api/v1")
public class CandidatoCartaoController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	@Autowired
	private CartaoCreditoRepository cartaoRepository;

	@GetMapping("/candidatos")
	public List<Candidato> getAllCandidatos() {
		return candidatoRepository.findAll();
	}

	@GetMapping("/cartoes")
	public List<CartaoCredito> getAllCartoess() {
		return cartaoRepository.findAll();
	}

	@GetMapping("/candidatos/{documento}")
	public ResponseEntity<Candidato> getCandidatoById(@PathVariable(value = "documento") Long documento)
			throws ResourceNotFoundException {
		Candidato candidato =  candidatoRepository.findByDocumento(documento);//.orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado ::" + documento));
		return ResponseEntity.ok().body(candidato);
	}

	@GetMapping("/cartoes/{numero}")
	public ResponseEntity<CartaoCredito> getCartaoCreditoById(@PathVariable(value = "numero") Long numero)
			throws ResourceNotFoundException {
		CartaoCredito cartao = cartaoRepository.findByNumero(numero);
				//.orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado ::" + numero));
		return ResponseEntity.ok().body(cartao);
	}

	@PostMapping("/candidatos")
	public Candidato createCandidato(@RequestBody Candidato candidato) {
		return candidatoRepository.save(candidato);
	}

	@PostMapping("/cartoes")
	public CartaoCredito createCartao(@RequestBody CartaoCredito cartao) {
		return cartaoRepository.save(cartao);
	}

	@PutMapping("/candidatos/{id}")
	public ResponseEntity<Candidato> updateCandidato(@PathVariable(value = "id") Long candidatoId,
			@RequestBody Candidato canditatoDetails) throws ResourceNotFoundException {
		Candidato candidato = candidatoRepository.findById(candidatoId).orElseThrow(
				() -> new ResourceNotFoundException("Não encotrado candidato para esse  id :: " + candidatoId));

		candidato.setId(canditatoDetails.getId());
		candidato.setNome(canditatoDetails.getNome());
		candidato.setVaga(canditatoDetails.getVaga());
		candidato.setTelefone(canditatoDetails.getTelefone());
		candidato.setEndereco(canditatoDetails.getEndereco());
		candidato.setDocumento(canditatoDetails.getDocumento());
		final Candidato updatedCandidato = candidatoRepository.save(candidato);
		return ResponseEntity.ok(updatedCandidato);
	}

	@PutMapping("/cartoes/{id}")
	public ResponseEntity<CartaoCredito> updateCartoes(@PathVariable(value = "id") Long cartaoId,
			@RequestBody CartaoCredito cartaoDetails) throws ResourceNotFoundException {
		CartaoCredito cartao = cartaoRepository.findById(cartaoId)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado cartao com esse  id :: " + cartaoId));

		cartao.setId(cartaoDetails.getId());
		cartao.setNomePortador(cartaoDetails.getNomePortador());
		cartao.setNumero(cartaoDetails.getNumero());
		cartao.setDataVenc(cartaoDetails.getDataVenc());
		cartao.setCodValidade(cartaoDetails.getCodValidade());

		final CartaoCredito updatedCartao = cartaoRepository.save(cartao);
		return ResponseEntity.ok(updatedCartao);
	}

	@DeleteMapping("/candidatos/{id}")
	public Map<String, Boolean> deleteCandidato(@PathVariable(value = "id") Long candidatoId)
			throws ResourceNotFoundException {
		Candidato candidato = candidatoRepository.findById(candidatoId).orElseThrow(
				() -> new ResourceNotFoundException("Candidato não encontrado para esse id :: " + candidatoId));

		candidatoRepository.delete(candidato);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/cartoes/{id}")
	public Map<String, Boolean> deleteCartao(@PathVariable(value = "id") Long cartaoId)
			throws ResourceNotFoundException {
		CartaoCredito cartao = cartaoRepository.findById(cartaoId)
				.orElseThrow(() -> new ResourceNotFoundException("Cartao não encontrado para esse  id :: " + cartaoId));

		cartaoRepository.delete(cartao);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
