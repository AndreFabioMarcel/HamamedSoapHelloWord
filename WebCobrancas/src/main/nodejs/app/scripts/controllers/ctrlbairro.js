'use strict';

/**
 * @ngdoc function
 * @name webCobrancasApp.controllers:ControllerBairro
 * @description
 * # ControllerBairro
 * Controller of the webCobrancasApp
 */

var app = angular.module('webCobrancasApp');

angular.module('webCobrancasApp.ctrlBairro', [])
    .controller('ControllerBairro', ControllerBairro)

ControllerBairro.$inject = ['$scope','$location','BairroRepository'];

function ControllerBairro($scope, $location, BairroRepository) {
    var viewModel = this;

    init();

    function init(){
    	$scope.paginas = 5;
    	setarLinhas($scope.paginas);            		    	
    }

    viewModel.save = function () {
	    BairroRepository.create($scope.bairro).then(function () {
	      viewModel.bairros = BairroRepository.getList();
	    });
	};

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

	viewModel.bairros = BairroRepository.getList();

	viewModel.bairro = function(id) {
   		 $scope.bairro = BairroRepository.get(id).$object;
    }


} 
