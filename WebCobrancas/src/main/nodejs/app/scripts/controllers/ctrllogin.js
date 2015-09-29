'use strict';

/**
 * @ngdoc function
  * @description
 * # ControllerLogin
 * Controller of the webCobrancasApp
 */

angular.module('webCobrancasApp.ctrlLogin', [])
    .controller('ControllerLogin', ControllerLogin);

/**
 * Controller Login
 */
ControllerLogin.$inject = ['$injector'];

function ControllerLogin($injector) {
    var viewModel = this;

    viewModel.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
}
