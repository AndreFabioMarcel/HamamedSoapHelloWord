(function() {
    'use strict';

    angular.module('webCobrancasApp.ctrlLogradouros', [])
        .controller('ControllerLogradouros', ControllerLogradouros);

    ControllerLogradouros.$inject = ['noty'];

    function ControllerLogradouros(noty) {
        var viewModel = this;

        var metodosPublicos = {
            message: _message
        };

        _.extend(viewModel, metodosPublicos);

        function _message() {
            noty.show('Variável não declarada na aplicação!', "error");
        }
    }

})();
