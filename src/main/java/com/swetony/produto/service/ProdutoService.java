package com.swetony.produto.service;

import com.swetony.produto.entity.Produto;
import com.swetony.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public Produto updateById(Long id, Produto produto){
        Produto existente = findById(id);
        if(existente == null){
            return null;
        }
        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setDescricao(produto.getDescricao());
        return repository.save(existente);
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
