import { Profile } from './Profile';

export class User {
   id: number;
   lastName: string ; 
   firstName: string ; 
   phoneNumber : number;
   dateOfBithday: Date; 
   nationality: string; 
   mail: string; 
   password: string; 
  profile : Profile; 

  selected:boolean;
  detailsAppear: boolean= false;
} 