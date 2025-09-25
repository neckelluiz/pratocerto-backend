package com.pratocerto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer quantidade;
    private Double preco;
}
