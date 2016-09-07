/**
 * Created by Danilo on 9/7/2016.
 */
'use strict';

myApp.controller("CadastroUsuarioController", function(UsuarioService, $location) {
    var model = this;

    model.message = "";

    model.usuario = {
        nome: "",
        email: "",
        senha: "",
        confirmaSenha: ""
    };

    model.submit = function(isValid) {
        console.log("h");
        if (isValid) {
            model.usuario = {nome: model.usuario.nome, email: model.usuario.email, senha: model.usuario.senha};
            UsuarioService.createUsuario(model.usuario);
            $location.path("/Login");
        } else {
            model.message = "Ainda existem campos inválidos no formulário";
        }
    };

});