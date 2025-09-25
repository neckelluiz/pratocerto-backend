package com.pratocerto.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
public class ItemPedidoDTO {

    @NotNull(message = "O nome do item é obrigatório")
    private String nome;

    @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
    private Integer quantidade;

    @Min(value = 0, message = "O preço deve ser positivo")
    private Double preco;
}
