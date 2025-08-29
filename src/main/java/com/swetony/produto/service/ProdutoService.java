package com.swetony.produto.service;

import com.swetony.produto.dto.ProdutoRequestDTO;
import com.swetony.produto.dto.ProdutoResponseDTO;
import com.swetony.produto.entity.Produto;
import com.swetony.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoResponseDTO save(ProdutoRequestDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.nome());
        produto.setPreco(produtoDTO.preco());
        produto.setQuantidade(produtoDTO.quantidade());
        produto.setDescricao(produtoDTO.descricao());

        Produto produtoSalvo = repository.save(produto);

        return new ProdutoResponseDTO(produtoSalvo);
    }

    public ProdutoResponseDTO updateById(Long id, ProdutoRequestDTO produtoDTO){
        Produto produtoExistente = repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Produto com o ID: " + id + " não encontrado " +
                                "para atualização"));

        produtoExistente.setNome(produtoDTO.nome());
        produtoExistente.setPreco(produtoDTO.preco());
        produtoExistente.setQuantidade(produtoDTO.quantidade());
        produtoExistente.setDescricao(produtoDTO.descricao());

        Produto produtoAtualizado = repository.save(produtoExistente);

        return new ProdutoResponseDTO(produtoAtualizado);
    }

    public ProdutoResponseDTO findById(Long id){
        Optional<Produto> produtoOpt = repository.findById(id);

        if(produtoOpt.isEmpty()){
            throw new EntityNotFoundException("Produto com o id: " + id + " não foi encontrado.");
        }

        return new ProdutoResponseDTO(produtoOpt.get());
    }

    public List<ProdutoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
