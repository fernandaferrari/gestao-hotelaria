package com.example.gestaoHotelaria.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    DOMINGO("Domingo",180.0, 20.0);

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
        return cinquentaPorCento != null ? cinquentaPorCento : BigDecimal.ZERO;
	}
	
	public static DiariaEnum findByNome(final String nome) {
		return DiariaEnum.map.get(nome.toUpperCase());
	}

	private static final Map<String, DiariaEnum> map;
	static {
		map = new HashMap<>();
		for (final DiariaEnum diaria : DiariaEnum.values()) {
			DiariaEnum.map.put(diaria.nome.toUpperCase(), diaria);
		}
	}
	
	public static BigDecimal calcular(LocalDateTime dataInicio, LocalDateTime dataFim, boolean estacionamento) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		long diasEntre = DateUtils.getDiasEntreDuasDatas(dataInicio, dataFim);
        for (long i = 0; i <= diasEntre; i++) {
            LocalDate dataAtual = dataInicio.toLocalDate().plusDays(i);
            String diaSemana = DateUtils.getConverteDataEmDiaSemana(dataAtual.atStartOfDay());
            DiariaEnum diaAtual = DiariaEnum.findByNome(diaSemana);
            valorTotal = valorTotal.add(BigDecimal.valueOf(diaAtual.getValorDiaria()));
            if(estacionamento) {
            	valorTotal = valorTotal.add(BigDecimal.valueOf(diaAtual.getValorEstacionamento()));
            }
        }
		return valorTotal;
	}
}
