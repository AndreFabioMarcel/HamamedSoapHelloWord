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

    viewModel.save = function () {
	    BairroRepository.create($scope.bairro).then(function () {
	      viewModel.ListaBairro = BairroRepository.getList();
	    });
	};

	viewModel.ListaBairro = BairroRepository.getList();



}    

