package com.neto.bike.domain.dto;

import java.time.LocalDateTime;

public class BikeDTO {
    private Long id;
    private LocalDateTime dataCriacao;
    private String regiao;
    private Long idLocatario;
    private LocalDateTime ultimoAluguel;
    private Boolean veiculoAlugado;

    public BikeDTO() {
    }

    public BikeDTO(Long id, LocalDateTime dataCriacao, String regiao, Long idLocatario, LocalDateTime ultimoAluguel, Boolean veiculoAlugado) {
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
