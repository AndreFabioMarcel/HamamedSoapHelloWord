'use strict';

/**
 * @ngdoc factory
 * @name webCobrancasApp.factory:UsuarioRepository
 * @description
 * # UsuarioRepository
 * Factory of the webCobrancasApp
 */

angular.module('webCobrancasApp.usuarioRepository', [])
        .factory('UsuarioRepository', UsuarioRepository);


UsuarioRepository.$inject = ['Restangular', 'AbstractRepository'];

function UsuarioRepository(restangular, AbstractRepository) {

    function UsuarioRepository() {
        AbstractRepository.call(this, restangular, 'usuario');
    }

    AbstractRepository.extend(UsuarioRepository);
    return new UsuarioRepository();
}

