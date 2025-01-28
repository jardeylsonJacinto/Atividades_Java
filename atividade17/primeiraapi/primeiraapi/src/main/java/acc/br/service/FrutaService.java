package acc.br.service;

import java.util.List;
import java.util.stream.Collectors;

import acc.br.dtos.FrutaDTO;
import acc.br.model.Fruta;
import acc.br.repository.FrutaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FrutaService {

  @Inject
  FrutaRepository frutaRepository;

  @Transactional
  public void criarFruta(FrutaDTO frutaDTO) {
    Fruta fruta = new Fruta();
    fruta.setNome(frutaDTO.getNome());
    fruta.setQuantidade(frutaDTO.getQuantidade());
    frutaRepository.persist(fruta);
  }

  public List<FrutaDTO> listarFrutas() {
    return frutaRepository.listAll().stream()
        .map(fruta -> {
          FrutaDTO dto = new FrutaDTO();
          dto.setNome(fruta.getNome());
          dto.setQuantidade(fruta.getQuantidade());
          return dto;
        })
        .collect(Collectors.toList());
  }
}