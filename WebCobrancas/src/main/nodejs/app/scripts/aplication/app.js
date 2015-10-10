/**
 * @ngdoc overview
 * @name webCobrancasApp
 * @description
 * # webCobrancasApp
 *
 * Main module of the application.
 */

 (function() {
    'use strict';

    angular
      .module('webCobrancasApp', [
        'webCobrancasApp.ctrlMain',
        'webCobrancasApp.filters',
        'webCobrancasApp.ctrlLogin',
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'restangular'
      ])

      .config(['$routeProvider','RestangularProvider', function($routeProvider, RestangularProvider) {
        
          $routeProvider.when('/', {
              templateUrl: 'views/login.html',
              controller: 'ControllerMain'
          });

          $routeProvider.when('/main', {
              templateUrl: 'views/main.html',
              controller: 'ControllerMain'
          });

          $routeProvider.when('/login', {
              templateUrl: 'views/login.html',
              controller: 'ControllerMain'
          });

          $routeProvider.otherwise({
              redirectTo: '/'
          });
                   
          RestangularProvider.setBaseUrl('http://localhost:8080/app/api');

          RestangularProvider.setDefaultHeaders({ "X-Requested-With": "XMLHttpRequest"});

          RestangularProvider.setDefaultHttpFields({withCredentials: false});

          //RestangularProvider.setRequestSuffix('!');
      }
    ]);

  }).call(this);
