package br.com.alura.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	private Integer codigo;

	@NonNull
	private LocalDate dataPedido;

	@NonNull
	private LocalDate dataPagamento;

	@NonNull
	private BigDecimal valorTotal;

	@XmlElementWrapper(name = "itens")
	@XmlElement(name = "item")
	private Set<Item> itens = new LinkedHashSet<>();

	public void adicionaItem(Item item) {
		this.itens.add(item);
	}

}
