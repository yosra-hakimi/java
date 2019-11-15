
/*
fetch('https://jsonplaceholder.typicode.com/posts')
.then(function(response){
  return response.json()
})
.then(function(data){
console.log(data)

})



  $(document).ready(function(){
  $(".buttonLoad").click(function(){
    $("#div1").load("https://jsonplaceholder.typicode.com/posts");
  });
});




fetch('https://jsonplaceholder.typicode.com/posts')
.then(function(response){
  return response.json()
})
.then(function(data){
  for(i=0;i<data.length;i++){
    console.log(data[i].title)
    $(".title").append(('<h1>'+'title n°'+i+" : "+ data[i].title +'</>'));
  }

})

fetch('https://jsonplaceholder.typicode.com/posts')
.then(function(response){
  return response.json()
})
.then(function(data){
  for(i=0;i<data.length;i++){
    console.log(data[i].body)
    $(".body").append(('<p>'+'body n°'+i+" : "+ data[i].body +'</>'));
  }

})
*/

fetch('https://jsonplaceholder.typicode.com/posts')
.then(function(response){
  return response.json()
})
.then(function(data){
  for(i=0;i<data.length;i++){
    //console.log(data[i])

    $(".btndelete").append(('<p>'+'data n°'+i+" : "+ JSON.stringify(data[i]) +'</>')).append('<button onclick="filtrerParID( data[i].id))">delete</button>');
  }

})
/*
function deletebyId(id){
fetch('https://jsonplaceholder.typicode.com/posts/'+id, { method: 'DELETE' }).then(function(data){
  const result = data.filter(obj => obj.id != 1);
  console.log(result);

})
}
*/





function filtrerParID(id) {
  if (id !== 1) {
    return true;
  } else {
    return false;
  }
}

fetch('https://jsonplaceholder.typicode.com/posts')
.then(function(response){
  return response.json()
})
.then(function(data){
var arrByID = data.filter(filtrerParID);
console.log('Tableau filtré\n', arrByID);

})
