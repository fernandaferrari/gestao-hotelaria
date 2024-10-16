package com.example.gestaoHotelaria.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public enum DiariaEnum {
    SEGUNDA("Segunda-feira",120.0, 15.0),
    TERÇA("Terça-feira",120.0, 15.0),
    QUARTA("Quarta-feira",120.0, 15.0),
    QUINTA("Quinta-feira",120.0, 15.0),
    SEXTA("Sexta-feira",120.0, 15.0),
    SABADO("Sábado",180.0, 20.0),
    DOMINGO("Doming",180.0, 20.0);

	private final String nome;
    private final double valorDiaria;
    private final double valorEstacionamento;

    DiariaEnum(String nome, double valorDiaria, double valorEstacionamento) {
    	this.nome = nome;
        this.valorDiaria = valorDiaria;
        this.valorEstacionamento = valorEstacionamento;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getValorEstacionamento() {
        return valorEstacionamento;
    }

	public String getNome() {
		return nome;
	}

	public static BigDecimal valorAdicional(LocalDateTime dataFim) {
		String diaSemana = DateUtils.getConverteDataEmDiaSemana(dataFim);
		DiariaEnum dia = DiariaEnum.findByNome(diaSemana);
		BigDecimal valorDiaria = BigDecimal.valueOf(dia.getValorDiaria());
        BigDecimal cinquentaPorCento = valorDiaria.multiply(BigDecimal.valueOf(0.50));
        return cinquentaPorCento != null ? cinquentaPorCento.add(valorDiaria) : BigDecimal.ZERO;
	}
	
	public static DiariaEnum findByNome(final String nome) {
		return DiariaEnum.map.get(nome);
	}

	private static final Map<String, DiariaEnum> map;
	static {
		map = new HashMap<>();
		for (final DiariaEnum diaria : DiariaEnum.values()) {
			DiariaEnum.map.put(diaria.nome, diaria);
		}
	}
}
