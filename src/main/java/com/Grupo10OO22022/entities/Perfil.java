package com.Grupo10OO22022.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Entity
@Table(name = "perfil")
public class Perfil {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPerfil;

  @Column(name = "tipoPerfil", nullable = false)
  private String tipoPerfil;

  @Column(name = "activo", nullable = false)
  private boolean activo;

  @Column(name = "createdat")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updatedat")
  private LocalDateTime updatedAt;
}
