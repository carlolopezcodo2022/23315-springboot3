package ar.com.codoacodo.domain.promedios;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class CursoId implements Serializable {
	
	@ManyToOne /*todo ver porque era many to one*/
	private Materia materia;
	
	@ManyToOne
	private Docente docente;
	
	@ManyToOne
	private Alumno alumno;
	
	private String turno;
}
