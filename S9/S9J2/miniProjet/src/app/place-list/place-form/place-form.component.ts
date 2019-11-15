import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';
import { Place } from '../../models/place.model';
import { PlacesService } from '../../services/places.service';
@Component({
  selector: 'app-place-form',
  templateUrl: './place-form.component.html',
  styleUrls: ['./place-form.component.css']
})
export class PlaceFormComponent implements OnInit {
  myForm =new FormGroup({
    name : new FormControl(null,[
      Validators.required,
      Validators.maxLength(30),
      //Validators.minLength(30), 
    ]),
    
    address : new FormControl(null,[
      Validators.required,
      Validators.maxLength(20),
      //Validators.minLength(20), 
    ]),
    postcode : new FormControl(null,[
      Validators.required,
      Validators.maxLength(5),
      //Validators.minLength(5), 
    ]),
    rating : new FormControl(null,[Validators.pattern(/^-?(0|[1-9]\d*)?$/), Validators.maxLength(5)]),
    Flag : new FormControl(null),


    
  })


  constructor(private fb :FormBuilder,private placeService:PlacesService) { }

  ngOnInit() {
  }

 /*
  onSubmit() {
 
    console.log(this.myForm.value)
    
    const name = this.myForm.value['name'];
    const address = this.myForm.value['address'];
    
}
*/

get name(){
  return this.myForm.get('name');
}
get adress(){
  return this.myForm.get('address');
}
get postal(){
  return this.myForm.get('postcode');
}

get rating(){
  return this.myForm.get('rating');

}

onSubmit(){
  if(this.myForm.valid){
  console.log(this.myForm.value);
  let newPlace : Place = this.myForm.value;

  console.log(newPlace);
  this.placeService.addPlace(newPlace);
  }
}

}



