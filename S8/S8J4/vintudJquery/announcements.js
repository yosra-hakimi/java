


fetch('http://localhost:8080/announce/1')
.then(function(response){
  return response.json()
})
.then(function(data){
console.log(data)
  $(".announce").append(('<h1>'+ JSON.stringify(data) +'</>'));
})
