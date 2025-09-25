package com.pratocerto.service;

import com.pratocerto.dto.PedidoDTO;
import com.pratocerto.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @Test
    void deveLancarExcecaoParaPedidoSemItens() {
        PedidoRepository mockRepo = Mockito.mock(PedidoRepository.class);
        PedidoService pedidoService = new PedidoService(mockRepo);

        PedidoDTO dto = new PedidoDTO();
        dto.setCliente("Maria");
        dto.setEndereco("Rua A");
        dto.setHora("14:00");
        dto.setTelefone(123456789L);
        dto.setItens(Collections.emptyList());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pedidoService.criarPedido(dto);
        });

        assertEquals("Pedido deve conter pelo menos um item", exception.getMessage());
    }
}
