/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.siconWeb.servicos;

import com.app.sinconWeb.models.Usuario;
import com.app.sinconWeb.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Fernandes
 */
@Service //Define a classe como um bean do Spring
public class UsuarioServico {
    
    @Autowired
    private UsuarioRepository ur; //Injeta o repositório
    
    //Retorna uma lista com todos posts inseridos
	public List<Usuario> findAll() {
		return ur.findAll(); 
	}
	
	//Retorno um post a partir do ID
	public Usuario findOne(Long id) {
		return ur.findOne(id);
	}
	
	//Salva ou atualiza um post
	public Usuario save(Usuario usuario) {
		return ur.saveAndFlush(usuario);
	}
	
	//Exclui um post
	public void delete(Long id) {
		ur.delete(id);
	}

}
