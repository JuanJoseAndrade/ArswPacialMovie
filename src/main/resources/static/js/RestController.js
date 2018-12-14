var RestControllerModule = (function () {
//------------------Metodos Get------

  var getPelicula = function(title,year, callback){			
	axios.get('/movie/'+title+"/"+year)		
		.then(function(response){
			callback.onSuccess(response.data);			
		})
		.catch(function(error){
			callback.onFailed(error);
		});
	};
	
	
  return {
	getPelicula: getPelicula


  };

})();