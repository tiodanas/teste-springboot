package br.gov.sc.ciasc.webnuc.api.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class EntidadeBase {

    /**
     * As anotações abaixo, @CreationTimestamp e @UpdateTimestamp funcionaram com:
     * updattable = false, para data de criação
     * insertable = false, para data de atualização
     *
     * Datas geradas pela JVM.
     * Para usar datas geradas pelo mecanismo de banco de dados, ver outra solução.
     *
     * http://docs.jboss.org/hibernate/orm/5.1/topical/html_single/generated/GeneratedValues.html#legacy-syntax-example
     *
     * Testado somente na base H2
     */

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    @CreationTimestamp
    private Date dataCadastro;

    @Column(name = "data_atualizacao", nullable = false, insertable = false)
    @UpdateTimestamp
    private Date dataAtualizacao;

    /*
    @PrePersist
    protected void onCreate() {
        dataAtualizacao = dataCadastro = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = new Date();
    }
    */
}
