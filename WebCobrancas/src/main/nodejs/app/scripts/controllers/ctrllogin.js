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
ControllerLogin.$inject = ['$injector','Restangular'];

function ControllerLogin($injector, Restangular) {
    var viewModel = this;

    viewModel.ListCtrl = Restangular.one("estado",24).get();

    viewModel.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
}
