$(document).ready(function() {
 
    $("#owl-demo").owlCarousel({
   
      navigation : true, // Show next and prev buttons
        slideSpeed : 300,
        paginationSpeed : 400,
         singleItem:true,
       items : 1,
         loop: true
     
    });
   
 });



$( "#eye" ).mousedown(function() {
    $("#inputPassword").attr("type", "text");
  });
  
  $( "#eye" ).mouseup(function() {
    $("#inputPassword").attr("type", "password");
  });