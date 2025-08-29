package com.swetony.produto.dto;

import com.swetony.produto.entity.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        Double preco,
        Integer quantidade
) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }
}
