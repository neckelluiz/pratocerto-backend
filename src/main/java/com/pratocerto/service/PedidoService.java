package com.pratocerto.service;

import com.pratocerto.dto.PedidoDTO;
import com.pratocerto.model.ItemPedido;
import com.pratocerto.model.Pedido;
import com.pratocerto.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(PedidoDTO dto) {
        if (dto.getItens() == null || dto.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter pelo menos um item");
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(dto.getCliente());
        pedido.setEndereco(dto.getEndereco());
        pedido.setHora(LocalTime.now());
        pedido.setTelefone(dto.getTelefone());
        pedido.setObservacoes(dto.getObservacoes());
        pedido.setStatus(dto.getStatus());

        List<ItemPedido> itens = dto.getItens().stream().map(itemDTO -> {
            ItemPedido item = new ItemPedido();
            item.setNome(itemDTO.getNome());
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPreco(itemDTO.getPreco());
            return item;
        }).toList();

        pedido.setItens(itens);
        pedido.setTotal(dto.getTotal());
        pedido.setQuantidade(itens.size());

        return pedidoRepository.save(pedido);
    }

    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }
}
