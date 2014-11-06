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
		
		for(var i=0, len=results.length; i<len; i++) {
			var ank = results[i];	
			//l = ank.get('thumbnail');			 					  			
			s += "<div class='gallery-item'>";
			s += "<a href='"+ank.get("picture").url()+"' rel='external'>";
			s += "<img id='image' src='"+ank.get('picture').url()+"' alt='Image'/>";				  
			s += "</a></div>";							
		}
		document.getElementById("thegal").innerHTML = s;
	},
	error:function(error) 
	{
		alert("Error when getting pictures!");
	}
});	
	  



var parse_init = false;
var online;


