'use strict';

/**
 * @ngdoc function
 * @name webCobrancasApp.controllers:ControllerUsuario
 * @description
 * # ControllerUsuario
 * Controller of the webCobrancasApp
 */

var app = angular.module('webCobrancasApp');

angular.module('webCobrancasApp.ctrlUsuario', [])
    .controller('ControllerUsuario', ControllerUsuario)

ControllerUsuario.$inject = ['$scope','$location','UsuarioRepository'];

function ControllerUsuario($scope, $location, UsuarioRepository) {
    var viewModel = this;

    viewModel.save = function () {
	    UsuarioRepository.create($scope.usuario).then(function () {
	      $location.path('/login');
	    });
	};

	viewModel.fabio = 99999;
}    

