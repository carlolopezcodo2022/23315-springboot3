package ar.com.codoacodo.domain.promedios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tipo_notas")
@RequiredArgsConstructor
@Data
public class TipoNota {

	@Id
	private Long id;
	private String tipo;
	private Integer habilitado; /*boolean*/
}
