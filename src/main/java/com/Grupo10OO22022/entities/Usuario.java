package com.Grupo10OO22022.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;

	@Column(name = "dni", nullable = false)
	private long dni;

	@Column(name = "email", nullable = false, length = 60)
	private String email;

	@Column(name = "nombreUsuario", unique = true, nullable = false, length = 45)
	private String nombreUsuario;

	@Column(name = "clave", nullable = false, length = 60)
	private String clave;

	@Column(name = "activo")
	private boolean activo;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil", nullable = false)
	private Perfil perfil;

}
