'use strict';

angular.module('file')
  .controller('file1Ctrl', function($scope, ngNotify, RestSrv, SERVICE_PATH ) {
    $scope.f = {};
    $scope.fs = []; 
    
 
   
    $scope.showAddEdit = false;
    
    
    
    $scope.show = function() {
      $scope.showAddEdit = true;
     
    };
    
    $scope.hide = function() {
     
      $scope.showAddEdit = false;
     	
      $scope.f = {};
    };
    
    
    
    // Manage CRUD operations.
    var fileUrl = SERVICE_PATH.PRIVATE_PATH + '/file1';
    
///////////////////////////////////////EDITAR  FILE ////////////////////////////////      

    $scope.editarFile = function(f) {
      //para editar a imagem
  	  document.getElementById("foto").src = $scope.f.file2;    
	  $scope.f = angular.copy(f);
	 
      $scope.show();
    };
    
///////////////////////////////////////DELETAR FILE ////////////////////////////////
    

    $scope.deletarFile = function(f) {
      RestSrv.delete(fileUrl, f, function(status,data) {
        $scope.fs.splice($scope.fs.indexOf(f), 1);
        ngNotify.set('File \'' + f.nomeImage + '\' Excluido com sucesso!!.', 'success');
      });
    };
    
    
///////////////////////////////////////SALVAR  FILE ////////////////////////////////
    
    $scope.salvarFile = function(f) {
    	
     //Extrai o nome da imagem com a extensão	 
     var fileName = $('input[type="file"]')[0].files[0].name;
     
   //pega a imagem na base 64  e salva no banco
	 $scope.f.file2 = document.getElementById("foto").getAttribute("src");	
	 
	//Salva o nome da imagem com a extensão no banco
	 $scope.f.nomeImage =  fileName;
    		
      if (f.id) {
    	    	
        RestSrv.edit(fileUrl,f, function() {  
        	
          for (var i = 0; i < $scope.fs.length; i++) {
        	
  			
            if ($scope.fs[i].id === f.id) {
              
      		 	
              $scope.fs[i] = f;
            }
          }

          $scope.hide();
          ngNotify.set('File \'' + f.nomeImage+ '\' Editado com sucesso!!.', 'success');
        });
      } else {
    	//pega a imagem e base 64
		  $scope.f.file2 = document.getElementById("foto").getAttribute("src");
		  $scope.f.nomeImage =  fileName ;
		  
          RestSrv.add(fileUrl, f, function(newFile) {
        	
        	  
        	  
          $scope.fs.push(newFile);

          $scope.hide();
          ngNotify.set('File \'' + f.nomeImage + '\' Salvo com sucesso!!.', 'success');
          
        });
      }
    };


    RestSrv.find(fileUrl, function(data) {
        $scope.fs = data;

        ngNotify.set('Conectado com sucesso!.', 'success');
      });
    
  


  });
