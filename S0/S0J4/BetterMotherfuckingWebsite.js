setTimeout(function() {alert('Hey le site xxxvidsxxx est trop bien. Viens dessus stp please')}, 10000);

setTimeout(function myFunction() {
    
    if (confirm('Hey le site xxxvidsxxx est trop bien. Viens dessus stp please')) {
        window.location.href = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    } 
      return false;
    },3000)

function animation(){
    document.getElementById('body').style.backgroundColor="#FF00FF";
    var divs = document.getElementsByTagName("h2");  // Access all <H1> present in your body.
    var divss = document.getElementsByTagName("h1");
    var divsss = document.getElementsByTagName("h3");
    var divp = document.getElementsByTagName("p");
    
for(var i = 0; i < divs.length; i++) {   //divs.length contain number of <h1> elements
      var div = divs[i];                     // Now access Each <H1> one-by-one
      div.style.color = 'green'; 
     div.style.fontFamily = "Comic Sans"; 

}
for(var i = 0; i < divss.length; i++) {   //divs.length contain number of <h1> elements
    var divv = divss[i];                     // Now access Each <H1> one-by-one
    divv.style.color = 'green'; 
    divv.style.fontFamily = "Comic Sans"; 

}
for(var i = 0; i < divsss.length; i++) {   //divs.length contain number of <h1> elements
    var divvv = divsss[i];                     // Now access Each <H1> one-by-one
    divvv.style.color = 'green'; 
    divvv.style.fontFamily = "Comic Sans"; 

}
for(var i = 0; i < divp.length; i++) {   //divs.length contain number of <h1> elements
    var dip = divp[i];                     // Now access Each <H1> one-by-one
    dip.style.color = "blue";
    dip.style.fontFamily = "courier";

}


    }