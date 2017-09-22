'use strict';

//var BASE_URL = 'http://localhost:8080/api';
var BASE_URL = '/api';

angular.module('file', ['checklist-model', 'ngNotify', 'ngRoute', 'ngCookies', 'ngStorage'])
  .constant('SERVICE_PATH', {
    'ROOT_PATH': BASE_URL,
    'PUBLIC_PATH': BASE_URL + '/public',
    'PRIVATE_PATH': BASE_URL + '/private'
  })
  .config(function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'src/home/home.html',
        controller: 'HomeCtrl'
      })
      .when('/login', {
        templateUrl: 'src/login/login.html',
        controller: 'LoginCtrl'
      })
      
      .when('/user', {
        templateUrl: 'src/user/user.html',
        controller: 'UserCtrl'
      })

      .when('/EditarUser', {
        templateUrl: 'src/user/editaruser.html',
        controller: 'EditarUserCtrl'
      })

      
      .when('/File1', {
        templateUrl: 'src/File1/file1.html',
        controller: 'file1Ctrl'
      })
      .when('/File2', {
        templateUrl: 'src/File2/file2.html',
        controller: 'file2Ctrl'
      })
      .when('/File3', {
        templateUrl: 'src/File3/file3.html',
        controller: 'file3Ctrl'
      })
       .when('/Arquivo', {
        templateUrl: 'src/Arquivo/arquivo.html',
        controller: 'arquivoCtrl'
      })
      .when('/Listar', {
        templateUrl: 'src/Arquivo/listar.html',
        controller: 'ControListar'
      })
      
      .otherwise({
        redirectTo: '/'
      });
  })
  .config(function($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    $httpProvider.defaults.withCredentials = true;
    $httpProvider.interceptors.push('httpRequestInterceptor');
  })
  .run(function($rootScope, ngNotify, LoginLogoutSrv) {
    $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };

    ngNotify.config({
      theme: 'pastel'
    });

    LoginLogoutSrv.verifyAuth();
  });
