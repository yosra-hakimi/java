
$(document).ready(function(){
  $("Form").submit(function(){
    //alert("Submitted");
    var firstname = $(".firstname").val();
    var lastname = $(".lastname").val();
    var date = $(".date").val();
    var email = $(".email").val();
    var phone = $(".phone").val();
    var range = $(".slider").val();

    // Initializing Variables With Regular Expressions
    var name_regex = /^[a-zA-Z]+$/;
    //var email_regex = /^[w-.+]+@[a-zA-Z0-9.-]+.[a-zA-z0-9]{2,4}$/;
    var phone_regex = /^[0-9]+$/;


    $(".slider").on("change", function() {
      // var range = $(this).val();
      $("#p7").text(range);
    });

    $( function(){
  	var maintenant = new Date(),
  		maDateNaissance = new Date( date ),
  		monAge = maintenant.getFullYear() - maDateNaissance.getFullYear();
/*
  	if ( maDateNaissance.getMonth() > maintenant.getMonth() ){
  		monAge += 1;
  	} else if ( maintenant.getMonth() == maDateNaissance.getMonth() &&
  				maDateNaissance.getDate() >= maintenant.getDate() ){
  		monAge += 1;
  	}
*/
  	$( "#age" ).html( '<p>' + monAge + ' ans</p>' );

if(monAge<18) {
$(".date").focus();
$(".error").text("error").css('color', 'red')
return false;
}
  });



    if (firstname.length == 0) {
    $("#head").text("* All fields are mandatory *"); // This Segment Displays The Validation Rule For All Fields
    $(".firstname").focus();
    return false;
    }
    else if (!(firstname.length >= 3 && firstname.length < 20) || firstname.length == 0) {
    $("#p1").text("* Please enter between 3 and 20 characters *"); // This Segment Displays The Validation Rule For Username
    $(".firstname").focus();
    return false;
    }
    // Validating Name Field.
    else if (!firstname.match(name_regex) || firstname.length == 0) {
    $("#p1").text("* For your firstname please use alphabets only *"); // This Segment Displays The Validation Rule For Name
    $(".firstname").focus();
    return false;
    }


    if (lastname.length == 0) {
    $("#head").text("* All fields are mandatory *"); // This Segment Displays The Validation Rule For All Fields
    $(".lastname").focus();
    return false;
    }
    else if (!(lastname.length >= 3 && lastname.length < 15) || lastname.length == 0) {
    $("#p2").text("* Please enter between 3 and 15 characters *"); // This Segment Displays The Validation Rule For Username
    $(".lastname").focus();
    return false;
    }
    // Validating Name Field.
    else if (!lastname.match(name_regex) || lastname.length == 0) {
    $("#p2").text("* For your lastname please use alphabets only *"); // This Segment Displays The Validation Rule For Name
    $(".lastname").focus();
    return false;
    }

    // Validating date Field.
    else if (date == "") {
    $("#p3").text("* Please Choose your birthday *"); // This Segment Displays The Validation Rule For Selection
    $(".date").focus();
    return false;
    }


  /*  // Validating Email Field.
    else if (!email.match(email_regex) || email.length == 0) {
    $("#p4").text("* Please enter a valid email address *"); // This Segment Displays The Validation Rule For Email
    $(".email").focus();
    return false;
    }
/*/

else if ( email.length == 0){
$("#p4").text("* remplir ce champ svp ! *").css('color', 'yellow').css("background-color", "black").css("width","250px");
$(".email").focus();
  return false;
}

// Validating phone Field.
else if (!phone.match(phone_regex) || phone.length == 0) {
$('#p5').text("* Please enter a valid phone Number *"); // This Segment Displays The Validation Rule For Zip
$(".phone").focus();
return false;
}

else if (!(phone.length >= 7 && phone.length <= 10) || phone.length == 0) {
$("#p5").text("* Please enter between 7 and 10 Numbers *"); // This Segment Displays The Validation Rule For Username
$(".phone").focus();
return false;
}
/*
   if (!(range.length >= 0 && range.length <= 7)  {
      $("#p6").text("* Please enter between 0 and 7  *"); // This Segment Displays The Validation Rule For Username
      $(".slider").focus();
      return false;
      }
      */


else {
  $(".success").text("Form Submitted Successfuly!").css('color', 'green');
//alert("Form Submitted Successfuly!");
return false;
}
  });
});
