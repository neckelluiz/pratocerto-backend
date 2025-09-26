package com.pratocerto.controller;

import com.pratocerto.dto.PedidoDTO;
import com.pratocerto.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.pratocerto.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @PostMapping
    public Pedido criar(@RequestBody PedidoDTO pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return pedidoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) { pedidoService.deletar(id);}
}
