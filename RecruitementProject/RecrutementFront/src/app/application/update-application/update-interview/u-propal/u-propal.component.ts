import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-u-propal',
  templateUrl: './u-propal.component.html',
  styleUrls: ['./u-propal.component.css']
})
export class UPropalComponent implements OnInit {

  propalForm: FormGroup;
  constructor( private formBuilder: FormBuilder) { }

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
