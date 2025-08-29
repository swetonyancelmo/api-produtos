package com.swetony.produto.controller;

import com.swetony.produto.dto.ProdutoRequestDTO;
import com.swetony.produto.dto.ProdutoResponseDTO;
import com.swetony.produto.entity.Produto;
import com.swetony.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping()
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody @Valid ProdutoRequestDTO produtoDTO){
        ProdutoResponseDTO produtoSalvo = service.save(produtoDTO);

        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id,
                                                               @RequestBody ProdutoRequestDTO produtoDTO){
        ProdutoResponseDTO produtoAtualizado = service.updateById(id, produtoDTO);
        if(produtoAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(produtoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos(){
        List<ProdutoResponseDTO> produtos = service.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable Long id){
        ProdutoResponseDTO produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> deletarPorId(@PathVariable Long id){
        ProdutoResponseDTO produtoExistente = service.findById(id);
        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
