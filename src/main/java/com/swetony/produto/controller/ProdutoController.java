package com.swetony.produto.controller;

import com.swetony.produto.entity.Produto;
import com.swetony.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/criar")
    public ResponseEntity<Produto> criarProduto(@RequestBody @Valid Produto produto){
        produto = service.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody @Valid Produto produto){
        Produto atualizado = service.updateById(id, produto);
        if(atualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(atualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos(){
        List<Produto> produtos = service.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarPorId(@PathVariable Long id){
        Produto produtoExistente = service.findById(id);
        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
