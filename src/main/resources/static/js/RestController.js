var RestControllerModule = (function () {
//------------------Metodos Get------
  var getEmpresa = function (tipo,callback) {
	
    axios.get('/apialpha/'+tipo)
    .then(function (response) {
     return callback.onSuccess(response.data);
    })
    .catch(function (error) {
      return callback.onFailed(error);
    });
  };
  
  return {
	getEmpresa: getEmpresa

  };

})();