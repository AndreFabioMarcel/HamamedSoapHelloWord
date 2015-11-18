(function() {
    'use strict'

    angular.module('webCobrancasApp.arrowSortDirective',[])
        .directive('arrowSort', ArrowSort);

    function ArrowSort() {
        return {
            restrict: 'A',
            transclude: true,
            scope: {
                order: '=',
                sort: '='
            },
            template: ' <a href="" ng-click="sortBy(order)" style="color: #555555;"><span ng-transclude></span><i ng-class="selectedCls(order)"></i></a>',
            link: function(scope) {

                    // change sorting order
                    scope.sortBy = function(newSortingOrder) {
                        var sort = scope.sort;

                        if (sort.sortingOrder == newSortingOrder) {
                            sort.reverse = !sort.reverse;
                        }

                        sort.sortingOrder = newSortingOrder;
                    };


                    scope.selectedCls = function(column) {
                        if (column == scope.sort.sortingOrder) {
                            return ('fa fa-sort-' + ((scope.sort.reverse) ? 'down ' : 'up ') + 'pull-right');
                        } else {
                            return 'fa fa-sort pull-right'
                        }
                    };
                } // end link 
        }
    }
})();
