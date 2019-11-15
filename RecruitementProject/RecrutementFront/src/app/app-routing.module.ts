import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { HomeComponent } from './home/home.component';
import { ButtonsComponent } from './shared/buttons/buttons.component';
import { TemplateComponent } from './shared/template/template.component';
import { FormsComponent } from './shared/forms/forms.component';
import { GridComponent } from './shared/grid/grid.component';
import { IconsComponent } from './shared/icons/icons.component';

import { NotificationComponent } from './shared/notification/notification.component';
import { PannelsComponent } from './shared/pannels/pannels.component';
import { TablesComponent } from './shared/tables/tables.component';
import { TypographieComponent } from './shared/typographie/typographie.component';
import { DropPanelComponent } from './shared/drop-panel/drop-panel.component';
import { CreateApplicationComponent } from './application/create-application/create-application.component';
import { SearchApplicationComponent } from './application/search-application/search-application.component';
import { UserManagementComponent } from './user-management/user-management.component';
import { CandidatComponent } from './application/search-application/candidat/candidat.component';
import { LoginComponent } from './authentification/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { DisplayApplicationComponent } from './display-application/display-application.component';
import { CreateUserComponent } from './user-management/create-user/create-user.component';
import { ConsultUserComponent } from './user-management/consult-user/consult-user.component';
import{ EvaluationComponent} from './evaluation/evaluation.component';
import { UpdateApplicationComponent } from './application/update-application/update-application.component';
import { PropalComponent } from './application/create-application/create-interview/propal/propal.component';
import { Error404Component } from './error404/error404.component';

const routes: Routes = [
  { path: '', redirectTo: '/recrutement/accueil', pathMatch: 'full' },

  {
  path: 'template', component: TemplateComponent, children: [
    { path: 'buttons', component: ButtonsComponent },
    { path: 'forms', component: FormsComponent },
    { path: 'grid', component: GridComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'notification', component: NotificationComponent },
    { path: 'pannels', component: PannelsComponent },
    { path: 'table', component: TablesComponent },
    { path: 'typographies', component: TypographieComponent },
    { path: 'dropbarrier', component: DropPanelComponent }, 
    {path: '**', component: Error404Component}
  ]
  
},

{
  path:'recrutement',component:MainComponent,children:[
    { path:'accueil',component:HomeComponent},
    { path:'ajouter',component:CreateApplicationComponent,canActivate:[AuthGuard]},
    { path:'rechercher',component:SearchApplicationComponent,canActivate:[AuthGuard]},
    { path:'afficher',component:DisplayApplicationComponent,canActivate:[AuthGuard]},
    { path:'admin',component:UserManagementComponent,canActivate:[AuthGuard]},
    { path:'login',component:LoginComponent},
    { path:'candidats',component:CandidatComponent},
    { path:'update',component:UpdateApplicationComponent},
    {path: '**', component: Error404Component}

  ]
}, 

{
  path:'administration',component:MainComponent,children:[
    { path:'accueil ',component:UserManagementComponent},
    { path:'ajouter',component:CreateUserComponent,canActivate:[AuthGuard]},
    { path:'consulter',component:ConsultUserComponent,canActivate:[AuthGuard]},
    {path: '**', component: Error404Component}
  ]
}, 
{
  path:'entretien',component:MainComponent,children:[
    { path:'evaluation',component:EvaluationComponent},
    {path:'propal',component:PropalComponent},
    {path: '**', component: Error404Component}
  ]
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
