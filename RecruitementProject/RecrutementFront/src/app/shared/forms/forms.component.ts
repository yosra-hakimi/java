import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit() {
  }


  basic = this.fb.group({});
  disabled = this.fb.group({});
  validation = this.fb.group({});
  inputGroup = this.fb.group({});

}
