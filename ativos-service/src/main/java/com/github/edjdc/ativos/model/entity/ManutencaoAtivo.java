package com.github.edjdc.ativos.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ManutencaoAtivo implements Serializable {

	private static final long serialVersionUID = -226767329504943412L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String observacao;
	private Date dataAgendamento;
	private Date dataManutencao;
	
	@Column(nullable = false)
	private Long ativoId;
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	@Column(nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String lastModifiedBy;
	
	@Version
	private int version;
	
	@NotAudited
	@ManyToOne
	@JoinColumn(name = "ativoId", updatable = false, insertable = false, referencedColumnName = "id")
	private Ativo ativo;

}
