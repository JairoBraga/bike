package com.neto.bike.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    private String regiao;
    @Column(name = "id_locatario")
    private Long idLocatario;
    @Column(name = "ultimo_aluguel")
    private LocalDateTime ultimoAluguel;
    @Column(name = "veiculo_alugado")
    private Boolean veiculoAlugado;

    public Bike() {
    }

    public Bike(Long id, LocalDateTime dataCriacao, String regiao, Long idLocatario, LocalDateTime ultimoAluguel, Boolean veiculoAlugado) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.regiao = regiao;
        this.idLocatario = idLocatario;
        this.ultimoAluguel = ultimoAluguel;
        this.veiculoAlugado = veiculoAlugado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(Long idLocatario) {
        this.idLocatario = idLocatario;
    }

    public LocalDateTime getUltimoAluguel() {
        return ultimoAluguel;
    }

    public void setUltimoAluguel(LocalDateTime ultimoAluguel) {
        this.ultimoAluguel = ultimoAluguel;
    }

    public Boolean getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(Boolean veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }
}
