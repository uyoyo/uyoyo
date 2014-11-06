// JavaScript Document

var PARSE_APP = "RYBRDnR5gVhVTfWQv0WFVjQHvTGr1VfAQHlnHRZZ";
var PARSE_JS = "HgNiInmXeZsi18zGdzjyFdVCA84KqS5VGLRElbh1";
//var cat = "ankara";
var ankara = Parse.Object.extend("ankara");

Parse.initialize(PARSE_APP, PARSE_JS); 
	
var query = new Parse.Query(ankara);

query.find({ 	  
	success:function(results) 
	{ 
		//alert("Successfully retrieved " + results.length + " pics.");
		console.dir(results);
		var s = "";
		// var length = results.length;
		// var l = (length/3) + 1;
		// alert(l);
		// for(var j=0; j<=l; j++){
			// s += "<div class='gallery-row'>";
			for(var i=0, len=2; i<len; i++) {
				var ank = results[i];	
				var picurl = ank.get("picture").url();
						 					  			
				s += "<div class='gallery-item'>";
				s += "<a href='"+picurl+"' rel='external'>";
				s += "<img id='image' src='"+picurl+"' alt='Image'/>";				  
				s += "</a></div>";							
			}
			// s += "</div>";
		// }
		document.getElementById("thegal").innerHTML = s;
		//document.getElementsByClassName("gallery-row").innerHTML = s;
	},
	error:function(error) 
	{
		alert("Error when getting pictures!");
	}
});	
	  



var parse_init = false;
var online;


