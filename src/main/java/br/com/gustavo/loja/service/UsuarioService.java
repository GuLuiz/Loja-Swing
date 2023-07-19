package br.com.gustavo.loja.service;

import java.sql.SQLException;
import java.util.List;

import br.com.gustavo.loja.entity.UsuarioEntity;
import br.com.gustavo.loja.repository.UsuarioRepository;

public class UsuarioService {
    
    UsuarioRepository usuarioRepository  = new UsuarioRepository();

    public UsuarioEntity salvar( UsuarioEntity usuarioEntity){
        return usuarioRepository.salvar(usuarioEntity);
    }

    public List<UsuarioEntity> listar(){

        try {
            return usuarioRepository.listar();
        } catch(SQLException e){
            System.out.println("Erro : " + e.getMessage());
        }
        return null;
    }

        
    }
