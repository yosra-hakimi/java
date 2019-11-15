 console.log("Salut, bienvenue dans ma super pyramide ! Combien d'étages veux-tu ?");

function pyramid() {
    var n = prompt("Salut, bienvenue dans ma super pyramide ! Combien d'étages veux-tu ?");
    console.log(n)
    var output="";
    for (var i = 0; i <n; i++) {
    var myspace = "";   
    for(let s = 0; s <(n-i-1); s++) {
        myspace += " ";
    }
        for (var j = 1; j <= 2*i + 1; j++) {
            output+="#";

        }
        console.log(myspace+output);
        output="";
    }
}
console.log(pyramid());


