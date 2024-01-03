package ar.com.codoacodo.domain.promedios;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class NotasId {

	/*@ManyToOne
	private Alumno alumno;
	@ManyToOne
	private Materia materia;
	*/
	private Long alumnoId;
	private Long materiaId;
	@Column
	private LocalDate fecha;
	@ManyToOne
	private TipoNota tipo;
}
