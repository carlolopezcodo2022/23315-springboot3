package ar.com.codoacodo.domain.promedios;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "notas")
@RequiredArgsConstructor
@Data
public class Notas {

	@EmbeddedId
	private NotasId id;
	
	private Float nota;
	private String comentario;
}
