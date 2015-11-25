(function() {
    'use strict';

    angular.module('webCobrancasApp.modalTemplate', [])
        .directive('modalTemplate', ModalTemplate);


    //directive
    function ModalTemplate($uibModal) {
        var patch = 'views/';

        var directive = {
            restrict: 'EA',
            templateUrl: patch + "entidade.html",
            link: link,
            scope: {
                name: "@",
                scope: "=scope"
            },
            require: "^modalGeral",
        };

        return directive;

        function link(scope, element, attrs, ctrl) {
            scope.teste = 'Fabio';
        }
    }

})();
