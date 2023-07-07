package ar.com.codoacodo.domain.promedios;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "docentes")
@RequiredArgsConstructor
@Data
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	/*many to many*/
	@ManyToMany(fetch = FetchType.EAGER)/*no es bueno*/
	@JoinTable(
			name = "materias_docentes",
			joinColumns = @JoinColumn(name="id_docente"),
			inverseJoinColumns = @JoinColumn(name="id_materia")
	)
	Set<Materia> materias;
}
