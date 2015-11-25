(function() {
    'use strict';

    angular.module("webCobrancasApp.modalGeral", [])
        .directive('modalGeral', ModalGeral)
        .controller('ModalGeralCtrl', ModalGeralCtrl);

    //directive
    function ModalGeral($uibModal) {
    	var patch = 'views/';

        var directive = {
            transclude: true,
            restrict: 'EA',
            template: '<a ng-click="open()" ng-transclude></a>',
            link: link,
            scope: {
                name: "@",
                size: "@",
                scope: "=scope",
                body: "@",
                bodyClass: "@"
            }
        };

        return directive;

        function link(scope, element, attrs) {
            scope.open = function() {
                var modalInstance = $uibModal.open({
                    templateUrl: patch + attrs.template + '.html',
                    controller: attrs.controller,
                    controllerAs: 'ModalGeralCtrl',
                    size: attrs.size ? attrs.size : 'sm', //lg - sm - md
                    windowClass: attrs.windowClass ? attrs.windowClass : 'angular-my-modal-window',
                    backdrop: attrs.backdrop ? attrs.backdrop : true,
                    resolve: {
                        modalSetting: function() {
                            return {
                                name: scope.name ? scope.name : 'Modal Genérico'
                            };
                        },
                        modalScope: function() {
                            return scope.scope ? scope.scope : {};
                        }
                    }

                });

                //Não deletar: panto pa debugg
                modalInstance.result.then(function() {
                    //console.debug('success');
                }, function() {
                    //console.debug('error');
                });
            };
        }

    }

    //directive controller
    function ModalGeralCtrl($scope, $rootScope, $uibModalInstance, modalSetting, modalScope) {
        var that = this;
        that.setting = modalSetting;
        that.scope = modalScope;
        that.accept = accept;
        that.cancel = cancel;

        // callback trigger 
        function accept(e) {
            $uibModalInstance.close();
            $rootScope.$emit('ModalGeralAccepted', e);
            if (e) e.stopPropagation();
        };

        function cancel(e) {
            $uibModalInstance.dismiss('cancel');
            $rootScope.$emit('ModalGeralCanceled', e);
            if (e) e.stopPropagation();
        };

        //event trigger 
        $rootScope.$on('ModalGeralAccept', function() {
            accept();
        });
        $rootScope.$on('ModalGeralCancel', function() {
            cancel();
        });
    }
})();
