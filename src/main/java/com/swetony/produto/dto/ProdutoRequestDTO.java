package com.swetony.produto.dto;

import jakarta.validation.constraints.*;


public record ProdutoRequestDTO(
        @NotBlank(message = "O nome não pode ser vazio.")
        String nome,

        @NotNull(message = "O valor não pode ser nulo.")
        @Positive(message = "O preço deve ser positivo")
        Double preco,

        @Size(max = 255, message = "A descrição deve ter até 255 caracteres")
        String descricao,

        @NotNull(message = "A quantidade não pode ser nula")
        @PositiveOrZero(message = "A quantidade deve ser positiva ou zero")
        Integer quantidade

) {
}
