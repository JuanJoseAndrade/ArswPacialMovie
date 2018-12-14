var OrdersControllerModule = (function () {
  
  var loadProduct=function (movie,elemento) {
		nombre='<div class="col-md-4 text-center animate-box fadeInUp animated-fast"><div class="product"><div class="product-grid" style="background-image:url(';
		nombre+=movie.Poster+');">';
		nombre+='<div class="inner"></div></div><div class="desc"><h3><a href="single.html">';
		nombre+=movie.Title+'</a></h3><span class="price">year : ';
		nombre+=movie.Year+ ' Languages: '+movie.Language+'</span></div></div>';
		document.getElementById(elemento).innerHTML+=nombre;
	};
//------------------Metodos Get---------------
var cont=3;
var id=0;

  var getPelicula = function (title,year) {
    var callback = {
        onSuccess: function(movie){

			
		if (cont==3){
			cont=1;
			id+=1;
			var txt1 = '<div class="row" id="'+"magic"+id.toString()+'"></div>';          
			document.getElementById("magic").innerHTML+=txt1;
		}
		else{cont+=1;}
				
		loadProduct(movie,"magic"+id.toString());
            },
        onFailed: function(exception){
		alert(exception);
        }
    }
    RestControllerModule.getPelicula(title,year,callback);
  };
  var removeAll= function(){
	  cont=3;
	  id=0;
	  
	  document.getElementById("magic").innerHTML="";
  };


  
  
 

  return {
	getPelicula:getPelicula,
	removeAll:removeAll
	
  };

})();