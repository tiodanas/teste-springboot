package br.gov.sc.ciasc.webnuc.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "unidade_medida")
public class UnidadeMedida extends EntidadeBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Min(1)
    @Column(name = "codigo", unique = true, nullable = false)
    private Integer codigo;

    @NotNull
    @Column(name = "nome", unique = true, nullable = false)
    @Size(min = 1, max = 100)
    private String nome;

    @NotNull
    @Column(name = "sigla", unique = true, nullable = false)
    @Size(min = 1, max = 15)
    private String sigla;

    @Column(name = "ativo", nullable = false) //, columnDefinition = "default 1")
    private Boolean ativo = true;

    @Override
    public String toString() {
        return String.format("%s - %s", this.nome.trim(), this.sigla.trim());
    }
}
