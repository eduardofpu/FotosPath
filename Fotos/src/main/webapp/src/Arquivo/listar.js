'use strict';

angular.module('file')
  .controller('ControListar', function($scope, $http, ngNotify, RestSrv, SERVICE_PATH) {
	   
    var vm = this;    
    $scope.usuarios = function() {	
 			
		var Url = {
			method : 'POST',				
			url : 'http://localhost:8080/service/math/listacompleta',				
			headers : {	'Content-Type' : 'application/json'	},							
			};				

	      $http(Url).then( function(evt) {
	    
		 vm.nomes = [evt.data.respLista.lista]; 
		 
	   });
   }; 
	  


  });
