'use strict';

/**
 * @ngdoc factory
 * @name webCobrancasApp.factory:BairroRepository
 * @description
 * # BairroRepository
 * Factory of the webCobrancasApp
 */

angular.module('webCobrancasApp.bairroRepository', [])
        .factory('BairroRepository', BairroRepository);


BairroRepository.$inject = ['Restangular', 'AbstractRepository'];

function BairroRepository(restangular, AbstractRepository) {

    function BairroRepository() {
        AbstractRepository.call(this, restangular, 'bairro');
    }

    AbstractRepository.extend(BairroRepository);
    return new BairroRepository();
}

