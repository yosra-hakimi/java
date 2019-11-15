import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';


const MaterialComponents = [
  MatButtonModule
]


@NgModule({

  imports: [ MaterialComponents ,
    MatFormFieldModule ],
  exports:[MaterialComponents,
    MatFormFieldModule ]
})
export class MaterialModule { }
