    package com.pratocerto.model;

    import jakarta.persistence.*;
    import lombok.Data;
    import java.util.List;

    @Data
    @Entity
    public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String cliente;
        private String status;
        private String hora;
        private String endereco;
        private Double total;
        private String observacoes;
        private Long telefone;
        private Integer quantidade;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<ItemPedido> itens;
    }
