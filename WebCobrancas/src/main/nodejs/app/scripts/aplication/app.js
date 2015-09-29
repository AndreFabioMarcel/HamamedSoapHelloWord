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
        'ngTouch'
      ])

      .config(['$routeProvider', function($routeProvider) {
        
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
      }
    ]);
  }).call(this);
