package com.Grupo10OO22022.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class NotaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "turno")
	protected char turno;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aula", nullable = true)
	protected Aula aula;

	@Column(name = "cantEstudiantes")
	protected int cantEstudiantes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_materia", nullable = false)
	protected Materia materia;

	@Column(name = "observaciones")
	protected String observaciones;

	@ManyToMany(fetch = FetchType.EAGER)
	@OrderBy("apellido ASC")
	protected Set<Profesor> profesores;

	@Column(name = "pendiente") // 1 - se le asignaron espacio/s
	protected boolean pendiente; // 0 - no se le asignaron espacio/s

	@Column(name = "activo") // 1 - Activa en el sistema con espacios asignados
	protected boolean activo; // 0 - Inactiva en el sistma, no ocupa espacios

	public NotaPedido(char turno, Aula aula, int cantEstudiantes, Materia materia, String observaciones,
			Set<Profesor> profesores, boolean pendiente) {
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.profesores = profesores;
		this.pendiente = pendiente;
	}

	public NotaPedido(char turno, int cantEstudiantes, String observaciones, boolean pendiente) {
		super();
		this.turno = turno;
		this.cantEstudiantes = cantEstudiantes;
		this.observaciones = observaciones;
		this.pendiente = pendiente;
	}

}
