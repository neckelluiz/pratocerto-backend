package com.pratocerto.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
public class PedidoDTO {

    @NotNull(message = "O nome do cliente é obrigatório")
    private String cliente;

    @NotNull(message = "A hora do pedido é obrigatória")
    private String hora;

    @NotNull(message = "O endereço é obrigatório")
    private String endereco;

    @NotNull(message = "O telefone é obrigatório")
    private Long telefone;

    @Size(min = 1, message = "O pedido deve conter pelo menos um item")
    private List<ItemPedidoDTO> itens;

    private String observacoes;
    private String status;
    private Double total;

}
