

import { Diploma } from './Diploma';
import { Application} from './Application';
import { User } from './User';
export class Candidat {
  forEach(arg0: (candidates: any) => number) {
    throw new Error("Method not implemented.");
  } 


    id:number;
    firstName: string  ;
    lastName:string;
    civility :string ;
    statut:string ;
    nationality: string;
    dateOfBithday: Date;
    dateFirstExperience:Date ;
    typeIdentityPiece : string ;
    expirationIdentityPiece :Date;
    numIdentityPiece : string ;
    entreprise: string;
    mail: string;
    phoneNumber: number ;
    experience : string;
    diploma:Diploma;
    application :  Application ;
    user : User;
    processId:String;
 
    
    
}