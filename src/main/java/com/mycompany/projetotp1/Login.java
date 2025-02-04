/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetotp1;

/**
 *
 * @author LUCAS
 */
public class Login {
    private final String usuario;
    private final String senha;
    private final String tipoUsuario;

    public Login(String usuario, String senha, String tipoUsuario) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }


    public boolean verificarUsuario(String usuario) {
        return this.usuario.equals(usuario);
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public String getTipoUsuario() {
       return tipoUsuario;
    }

    
}

