(function() {
    'use strict';

    angular.module('webCobrancasApp.ctrlLogradouros', [])
        .controller('ControllerLogradouros', ControllerLogradouros);

    function ControllerLogradouros() {
        var viewModel = this;

        var metodosPublicos = {
            metodoDefault: _metodoDefault
        };

        return metodosPublicos;

        function _metodoDefault() {
            return 'teste';
        }
    }
})();
