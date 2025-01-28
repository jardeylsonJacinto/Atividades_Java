package acc.br.repository;

import acc.br.model.Fruta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FrutaRepository implements PanacheRepository<Fruta> {
  // Métodos personalizados, se necessário
}