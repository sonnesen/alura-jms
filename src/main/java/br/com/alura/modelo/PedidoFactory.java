package br.com.alura.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoFactory {

	public Pedido geraPedidoComValores() {
		Pedido pedido = new Pedido(Integer.valueOf(2459), geraData("2016-12-06"), geraData("2016-12-23"), new BigDecimal("145.98"));

		Item motoG = geraItem(23, "Moto G");
		Item motoX = geraItem(51, "Moto X");

		pedido.adicionaItem(motoX);
		pedido.adicionaItem(motoG);

		return pedido;
	}

	private Item geraItem(int id, String nome) {
		return new Item(id, nome);
	}

	private LocalDate geraData(String stringData) {
		return LocalDate.parse(stringData);
	}

}
