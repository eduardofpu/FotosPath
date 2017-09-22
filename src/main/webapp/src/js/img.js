   
	  function visualizarImg() {
		 

		  
	    	  var preview = document.querySelectorAll('img').item(1); //Mostra a imagem   mudar item[0] para 1 se houver uma imagem antes dela 
	    	  var file    = document.querySelector('input[type=file]').files[0]; // e o botão file html
	    	 	    	  
	    	  var reader  = new FileReader(); // Faz a leitura o objeto em si

	    	  reader.onloadend = function () { // e a mudança de imagem no momento que escolhe a imagem
	    	    preview.src = reader.result;// carrega em base64 a img o atributo src sera a imagem escolhida
	    	  };
	    	  
	          //Se for valido 	transforma em um atributo adequado para o navegador
	    	  if (file) {
	    	    reader.readAsDataURL(file);
	    	    
	    	  
	    	    
	    	   //Se não limpa o campo 
	    	  } else {
	    	    preview.src = "";
	    	  }
	    	  
	    }
	  
	  
	  
	  function almentar(){

		  document.getElementById("f").width =document.getElementById("f").width +5;
		  document.getElementById("f").height =document.getElementById("f").height +5;
		  
		  document.getElementById("largura").innerHTML = "Largura"+document.getElementById("f").width;
		  document.getElementById("altura").innerHTML = "Altura"+document.getElementById("f").height;

		}


		function diminuir(){

		  document.getElementById("f").width =document.getElementById("f").width -5;
		  document.getElementById("f").height =document.getElementById("f").height -5;
		  
		  document.getElementById("largura").innerHTML = "Largura " +document.getElementById("f").width;
		  document.getElementById("altura").innerHTML = "Altura " +document.getElementById("f").height;

		}

		//criando random para mudar imagens aleatoriamente ao apertar o f5

		imagens = new Array();
		imagens[0] = "<img src='Image/linda.jpg' width='50'>"
		imagens[1] = "<img src='Image/u1.jpg' width='50'>"
		imagens[2] = "<img src='Image/u2.jpg' width='50'>"
		

		aleatorio = Math.floor(Math.random() *imagens.length)
		document.write(imagens[aleatorio])
		
		
	  
	  
	  
	 