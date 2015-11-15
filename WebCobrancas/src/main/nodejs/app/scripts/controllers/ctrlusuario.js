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

ControllerUsuario.$inject = ['$scope', '$location', 'UsuarioRepository'];

function ControllerUsuario($scope, $location, UsuarioRepository) {
    var viewModel = this;

    init();

    function init(){
    	$scope.paginas = 5;
    	setarLinhas($scope.paginas);            		    	
    }

    viewModel.save = function() {
        UsuarioRepository.create($scope.usuario).then(function() {
            $location.path('/login');
        });
    }

    viewModel.ordenarPor = function(coluna) {
        $scope.criterioDeOrdenacao = coluna;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    }

    viewModel.setItemsPagina = function(num) {
         setarLinhas(num);       
    }

    function setarLinhas(num){
    	viewModel.entryLimit= num;
    }


    viewModel.usuarios = [{
        nome: "Fabio1",
        login: "fabio1.euzebio",
        email: "fabio1.euzebio@gmail.com"
    }, {
        nome: "Fabio2",
        login: "fabio2.euzebio",
        email: "fabio2.euzebio@gmail.com"
    }, {
        nome: "Fabio3",
        login: "fabio3.euzebio",
        email: "fabio3.euzebio@gmail.com"
    }, {
        nome: "Fabio4",
        login: "fabio4.euzebio",
        email: "fabio4.euzebio@gmail.com"
    }, {
        nome: "Fabio5",
        login: "fabio5.euzebio",
        email: "fabio5.euzebio@gmail.com"
    }, {
        nome: "Fabio6",
        login: "fabio6.euzebio",
        email: "fabio6.euzebio@gmail.com"
    }, {
        nome: "Fabio7",
        login: "fabio7.euzebio",
        email: "fabio7.euzebio@gmail.com"
    }, {
        nome: "Fabio8",
        login: "fabio8.euzebio",
        email: "fabio8.euzebio@gmail.com"
    }, {
        nome: "Fabio9",
        login: "fabio9.euzebio",
        email: "fabio9.euzebio@gmail.com"
    }, {
        nome: "Fabio10",
        login: "fabio10.euzebio",
        email: "fabio10.euzebio@gmail.com"
    }, {
        nome: "Fabio91",
        login: "fabio91.euzebio",
        email: "fabio91.euzebio@gmail.com"
    }, {
        nome: "Fabio92",
        login: "fabio92.euzebio",
        email: "fabio92.euzebio@gmail.com"
    }, {
        nome: "Fabio93",
        login: "fabio93.euzebio",
        email: "fabio93.euzebio@gmail.com"
    }, {
        nome: "Fabio94",
        login: "fabio94.euzebio",
        email: "fabio94.euzebio@gmail.com"
    }, {
        nome: "Fabio95",
        login: "fabio95.euzebio",
        email: "fabio95.euzebio@gmail.com"
    }, {
        nome: "Fabio96",
        login: "fabio96.euzebio",
        email: "fabio96.euzebio@gmail.com"
    }];    
    
}
