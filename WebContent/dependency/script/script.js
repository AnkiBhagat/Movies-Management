$(document).ready(function(){
  
	setTimeout(function(){ 
		$.ajax({
        type:"POST",
        url : "MyPagination",
        dataType: 'text',
        success : function(response , textStatus, jqXHR) {
        	 console.log(response);
        	 
        	if(response){
        		var array = response.split(',');
        		console.log(array);
        		$.each(array, function( index, value ) {
        			$('#movie-wrapper').append('<div class="col-sm-3"><img src="./images/'+value+'" class="img-responsive" alt=""></div>');
        			console.log( index + ": " + value );
        			});
        		
        		
        	}
        	else {
        		$('#movie-wrapper').append('<div>mad-cow</div>');
            }	
        	
        	/* when document is ready */
        	  $(function(){
        	    /* initiate the plugin */
        	    $("div.holder").jPages({
        	        containerID  : "movie-wrapper",
        	        perPage      : 10,
        	        startPage    : 1,
        	        startRange   : 1,
        	        midRange     : 5,
        	        endRange     : 1
        	    });
        	});
        }
       
    }); }, 100);
	
	
	$('#sel1').change(function() {
		
	   /* var data = "";*/
	    $.ajax({
	        type:"POST",
	        url : "language",
	        data: {"language":$("#sel1").val(), "genre":$("#sel2").val() },
	        dataType: 'html',
	        success : function(response , textStatus, jqXHR) {
	        	console.clear(); 
	        	console.log(response);
	        	 $('#movie-wrapper').html('');
	        	if(response){
	        		var array = response.split(',');
	        		console.log(array);
	        		$.each(array, function( index, value ) {
	        			$('#movie-wrapper').append('<div class="col-sm-3"><img src="./images/'+value+'" class="img-responsive" alt=""></div>');
	        			console.log( index + ": " + value );
	        			});
	        		
	        		
	        	}
	        	else {
	        		$('#movie-wrapper').append('<div>No Movies</div>');
                }	
	        	/* when document is ready */
	        	  $(function(){
	        	    /* initiate the plugin */
	        	    $("div.holder").jPages({
	        	        containerID  : "movie-wrapper",
	        	        perPage      : 10,
	        	        startPage    : 1,
	        	        startRange   : 1,
	        	        midRange     : 5,
	        	        endRange     : 1
	        	    });
	        	});
	        }
	       
	    });
	    
	});
	
	$('#sel2').change(function() {	
	   /* var data = "";*/
	  
	    $.ajax({
	        type:"POST",
	        url : "Genre",
	        data: {"language":$("#sel1").val(), "genre":$("#sel2").val() },
	        dataType: 'html',
	        success : function(response , textStatus, jqXHR) {
	        	console.clear(); 
	        	 console.log(response);
	        	 $('#movie-wrapper').html(''); 
	        	if(response){
	        		var array = response.split(',');
	        		console.log(array);
	        		$.each(array, function( index, value ) {
	        			$('#movie-wrapper').append('<div class="col-sm-3"><img src="./images/'+value+'" class="img-responsive" alt=""></div>');
	        			console.log( index + ": " + value );
	        			});
	        		
	        		
	        	}
	        	else {
	        		$('#movie-wrapper').append('<div>No Movies</div>');
                }	   
	        	/* when document is ready */
	        	  $(function(){
	        	    /* initiate the plugin */
	        	    $("div.holder").jPages({
	        	        containerID  : "movie-wrapper",
	        	        perPage      : 10,
	        	        startPage    : 1,
	        	        startRange   : 1,
	        	        midRange     : 5,
	        	        endRange     : 1
	        	    });
	        	});
	        }
	       
	    });
	    
	});
   

});