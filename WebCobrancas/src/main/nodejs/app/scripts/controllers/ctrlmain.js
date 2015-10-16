'use strict';

/**
 * @ngdoc function
 * @name webCobrancasApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webCobrancasApp
 */

angular.module('webCobrancasApp.ctrlMain', [])
    .controller('ControllerMain', ControllerMain)
    .run(appRun);

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

/* @ngInject */
function appRun(routerHelper) {
    routerHelper.configureStates(getStates());
}

function getStates() {
    return [
        {
            state: 'usuarios',
            config: {
                abstract: true,
                template: 'Fabio Teste',
                url: '/customer'
            }
        }
    ];
}