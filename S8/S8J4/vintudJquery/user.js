


fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
console.log(data)
  $(".userbymail").append(('<h1>'+ JSON.stringify(data) +'</>'));
})


$(document).ready(function(){
    $("#formButton").click(function(){
        $("#form1").toggle();
    });
});


fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.firstname)
    $(".firstname").attr({value : data.firstname}).append(('<p>'+ data.firstname +'</>'));

})


fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.name)
    $(".lastname").attr({value : data.name}).append(('<p>'+ data.name +'</>'));

})


fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.pseudo)
    $(".pseudo").attr({value : data.pseudo}).append(('<p>'+ data.pseudo +'</>'));

})

fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.mail)
    $(".email").attr({value : data.mail}).append(('<p>'+ data.mail +'</>'));

})
fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.uPassword)
    $(".password").attr({value : data.uPassword}).append(('<p>'+ data.uPassword +'</>'));

})

fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.phone)
    $(".phone").attr({value : data.phone}).append(('<p>'+ data.phone +'</>'));

})

fetch('http://localhost:8080/user/johnyPirate@Cara.com')
.then(function(response){
  return response.json()
})
.then(function(data){
    console.log(data.address)
    $(".address").attr({value : data.address}).append(('<p>'+ data.address +'</>'));

})
