
import { Candidat } from './Candidat';
import { Interview } from './Interview';
import { User } from './User';
export class Application {

  id: number;
  applicationDate: Date;
  cooptedBy: User;
  nextStep:String;
  curriculumVitae: any;
  disponibilityDate: Date;
  source: string;
  candidate: Candidat;
  interview : Interview[];
  responsible: string;
  manager : User;
  copter : User;
  geographicalWish: string;
  searchedPosition : string;
  
}



