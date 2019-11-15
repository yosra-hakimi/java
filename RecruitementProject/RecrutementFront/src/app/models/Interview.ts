import { Application } from './Application';
import { User } from './User';


export class Interview {

  id: number;
  businessUnit: string;
  interviewDate: Date;
  interviewType: string;
  jobOffer: string;
  applicationInterview: Application
  interviewWith: User ;
  opinion: string;
  comment: string;
  nextStep: string;
  date: Date;
  statut: string = "En cours";
  currentRemuneration: number;
  desiredRemuneration: number;
  showInterview: boolean = false;
} 