package ar.com.codoacodo.domain.promedios;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "alumnos")
@RequiredArgsConstructor
@Data
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER)/*no es bueno*/
	@JoinTable(
			name = "materias_alumnos",
			joinColumns = @JoinColumn(name="id_docente"),
			inverseJoinColumns = @JoinColumn(name="id_materia")
	)
	Set<Materia> materias;	
	
	@ManyToOne(targetEntity = Notas.class)
//	@JoinColumn(name = "alumno_id")
	Set<Notas> notas; 
}
