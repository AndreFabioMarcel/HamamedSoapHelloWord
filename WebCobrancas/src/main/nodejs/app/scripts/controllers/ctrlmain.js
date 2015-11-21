(function() {

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

        viewModel.awesomeThings = ['HTML5 Boilerplate', 'AngularJS', 'Karma'];
    }

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [{
            state: 'main.usuario',
            config: {
                url: '/usuario',
                templateUrl: 'views/usuario.html',
                controller: 'ControllerUsuario',
                controllerAs: 'cu'
            }
        }, {
            state: 'main.entidade',
            config: {
                url: '/entidade',
                templateUrl: 'views/entidade.html'
            }
        }, {
            state: 'main.credores',
            config: {
                url: '/credores',
                templateUrl: 'views/credores.html'
            }
        }, {
            state: 'main.devedores',
            config: {
                url: '/devedores',
                templateUrl: 'views/devedores.html'
            }
        }, {
            state: 'main.relatorios',
            config: {
                url: '/relatorios',
                templateUrl: 'views/relatorios.html'
            }
        }, {
            state: 'main.agenda',
            config: {
                url: '/agenda',
                templateUrl: 'views/agenda.html'
            }
        }, {
            state: 'main.negociacoes',
            config: {
                url: '/negociacoes',
                templateUrl: 'views/negociacoes.html'
            }
        }, {
            state: 'main.acordos',
            config: {
                url: '/acordos',
                templateUrl: 'views/acordos.html'
            }
        }, {
            state: 'main.bairros',
            config: {
                url: '/bairros',
                templateUrl: 'views/bairros.html',
                controller: 'ControllerBairro',
                controllerAs: 'cb'
            }
        }, {
            state: 'main.logradouros',
            config: {
                url: '/logradouros',
                templateUrl: 'views/logradouros.html',
                controller: 'ControllerLogradouros',
                controllerAs: 'CtrlLogradouros'
            }
        }];
    }
})();
