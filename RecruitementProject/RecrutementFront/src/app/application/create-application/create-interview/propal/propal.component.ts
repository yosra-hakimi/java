import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-propal',
  templateUrl: './propal.component.html',
  styleUrls: ['./propal.component.css']
})
export class PropalComponent implements OnInit {
  propalForm: FormGroup;
  
  constructor(private router: Router, private formBuilder: FormBuilder) { }

  

  
    ngOnInit() {
      this.propalForm = this.formBuilder.group({
        startDay: [''],
        poste: [''],
        salary: [''],
        manager:['']
      });
  }
  onSubmit() {
    console.log(this.propalForm.value);
  }

  
}
