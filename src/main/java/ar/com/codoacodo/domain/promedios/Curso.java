package ar.com.codoacodo.domain.promedios;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cursos")
@RequiredArgsConstructor
@Data
public class Curso {

	@EmbeddedId
	private CursoId id;
	
	@Column(name="nombre")
	String nombre;	
}
