'use strict';

/**
 * @ngdoc function
 * @name webCobrancasApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webCobrancasApp
 */

angular.module('webCobrancasApp.ctrlMain', [])
    .controller('ControllerMain', ControllerMain);

/**
 * Controller Main
 */
ControllerMain.$inject = ['$injector'];

function ControllerMain($injector) {
    var viewModel = this;

    viewModel.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
}
