package acc.br.corridaJPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import acc.br.corridaJPA.model.Corrida;
import acc.br.corridaJPA.repository.CorridaRepository;
import acc.br.corridaJPA.repository.LocalRepository;

@Service
public class CorridaService {

  private final CorridaRepository corridaRepository;
  private final LocalRepository localRepository;

  public CorridaService(CorridaRepository corridaRepository, LocalRepository localRepository) {
    this.corridaRepository = corridaRepository;
    this.localRepository = localRepository;
  }

  // Pega todos os registros da tabela corridas
  public List<Corrida> getAllCorrida() {
    List<Corrida> corridas = new ArrayList<>();
    corridaRepository.findAll().forEach(corrida -> corridas.add(corrida));
    return corridas;
  }

  // Recupera um registro específico
  public Corrida getCorridaById(long id) {
    return corridaRepository.findById(id).orElse(null);
  }

  // Salva ou atualiza uma corrida
  public void saveOrUpdate(Corrida corrida) {
    corridaRepository.save(corrida);
  }

  // Deleta um registro específico
  public void delete(long id) {
    corridaRepository.deleteById(id);
  }

  // POST Adicionar uma corrida a um Local
  public ResponseEntity<Corrida> criarCorrida(Long localId, Corrida corridaRequest) {
    Corrida corrida = localRepository.findById(localId)
        .map(local -> {
          corridaRequest.setLocal(local);
          return corridaRepository.save(corridaRequest);
        })
        .orElseThrow(() -> new IllegalArgumentException("Não encontrado o Local com id = " + localId));
    return new ResponseEntity<>(corrida, HttpStatus.CREATED);
  }

  // GET Consulta corridas por local
  public ResponseEntity<List<Corrida>> consultaCorridasPorLocalId(Long localId) {
    if (!localRepository.existsById(localId)) {
      throw new IllegalArgumentException("Não encontrado o Local com id = " + localId);
    }
    List<Corrida> corridas = corridaRepository.findByLocalId(localId);
    return new ResponseEntity<>(corridas, HttpStatus.OK);
  }

  // DELETE Corridas por Local
  public ResponseEntity<Void> deletaCorridasPorLocalId(Long localId) {
    if (!localRepository.existsById(localId)) {
      throw new IllegalArgumentException("Não encontrado o Local com id = " + localId);
    }
    corridaRepository.deleteByLocalId(localId);
    return ResponseEntity.noContent().build();
  }
}
