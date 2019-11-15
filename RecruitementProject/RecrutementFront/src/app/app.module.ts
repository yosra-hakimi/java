import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateComponent } from './shared/template/template.component';
import { IconsComponent } from './shared/icons/icons.component';

import { FormsComponent } from './shared/forms/forms.component';

import { NotificationComponent } from './shared/notification/notification.component';
import { PannelsComponent } from './shared/pannels/pannels.component';
import { TablesComponent } from './shared/tables/tables.component';
import { TypographieComponent } from './shared/typographie/typographie.component';
import { ButtonsComponent } from './shared/buttons/buttons.component';
import { DropPanelComponent } from './shared/drop-panel/drop-panel.component';
import { PersonalInformationComponent } from './shared/drop-panel/personal-information/personal-information.component';
import {  ReactiveFormsModule }   from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { GridComponent } from './shared/grid/grid.component';
import { NavigationTemplateComponent } from './shared/navigation-template/navigation-template.component';
import { MainComponent } from './main/main.component';
import { HomeComponent } from './home/home.component';

import { AdditionnelInfoComponent } from './shared/drop-panel/additionnel-info/additionnel-info.component';
import { ContactInformationComponent } from './shared/drop-panel/contact-information/contact-information.component';



import { ApplicationComponent } from './application/application.component';
import { CreateApplicationComponent } from './application/create-application/create-application.component';
import { SearchApplicationComponent } from './application/search-application/search-application.component';
import { InformationsComponent } from './application/create-application/informations/informations.component';
import { UserManagementComponent } from './user-management/user-management.component';
import { ApplicationFolderComponent } from './application/create-application/informations/application-folder/application-folder.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ExperienceComponent } from './application/create-application/informations/experience/experience.component';
import { ContactComponent } from './application/create-application/informations/contact/contact.component';
import { DocumentsComponent } from './application/create-application/documents/documents.component';
import { FileUploadService } from './services/file-upload.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { InterviewComponent } from './application/create-application/create-interview/interview/interview.component';
import { InterviewService } from './services/interview.service';
import { CandidatComponent } from './application/search-application/candidat/candidat.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { LoginComponent } from './authentification/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { CreateUserComponent } from './user-management/create-user/create-user.component';
import { HeaderComponent } from './navigation/header/header.component';
import { SidebarComponent } from './navigation/sidebar/sidebar.component';
import { ConsultUserComponent } from './user-management/consult-user/consult-user.component';
import { DisplayApplicationComponent } from './display-application/display-application.component';
import { DisplayInformationComponent } from './display-application/display-information/display-information.component';
import { DiplayContactComponent } from './display-application/display-information/diplay-contact/diplay-contact.component';
import { DiplayExperienceComponent } from './display-application/display-information/diplay-experience/diplay-experience.component';
import { DiplayAppFolderComponent } from './display-application/display-information/diplay-app-folder/diplay-app-folder.component';
import { EvaluationComponent } from './evaluation/evaluation.component';
import { UpdateApplicationComponent } from './application/update-application/update-application.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {RouterModule} from "@angular/router";

import {FileDropDirective, FileSelectDirective} from "ng2-file-upload";

import {CustomMaterialModule} from  './application/create-application/documents/material.module';
import { PropalComponent } from './application/create-application/create-interview/propal/propal.component';
import { CreateInterviewComponent } from './application/create-application/create-interview/create-interview.component';
import { CommonModule } from '@angular/common';
 
import { ToastrModule } from 'ngx-toastr';
import { UpdateInterviewComponent } from './application/update-application/update-interview/update-interview.component';
import { UpdateDocumentsComponent } from './application/update-application/update-documents/update-documents.component';
import { UpdateInformationsComponent } from './application/update-application/update-informations/update-informations.component';
import { UpdateAppFolderComponent } from './application/update-application/update-informations/update-app-folder/update-app-folder.component';
import { UpdateContactComponent } from './application/update-application/update-informations/update-contact/update-contact.component';
import { UpdateExperienceComponent } from './application/update-application/update-informations/update-experience/update-experience.component';
import { UInterviewComponent } from './application/update-application/update-interview/u-interview/u-interview.component';
import { UPropalComponent } from './application/update-application/update-interview/u-propal/u-propal.component';
import { DispCandidatComponent } from './application/search-application/candidat/disp-candidat/disp-candidat.component';
import { Error404Component } from './error404/error404.component';




@NgModule({
  declarations: [
    AppComponent,
    TemplateComponent,
    IconsComponent,
    NavigationComponent,
    FormsComponent,
    LoginComponent,
    NotificationComponent,
    PannelsComponent,
    TablesComponent,
    TypographieComponent,
    ButtonsComponent,
    DropPanelComponent,
    PersonalInformationComponent,
    GridComponent,
    NavigationTemplateComponent,
    MainComponent,
    HomeComponent,
    AdditionnelInfoComponent,
    ContactInformationComponent,
    ExperienceComponent,
    HeaderComponent,
    DocumentsComponent,
    InterviewComponent,
    ApplicationComponent,
    CreateApplicationComponent,
    SearchApplicationComponent,
    InformationsComponent,
    UserManagementComponent,
    ApplicationFolderComponent,
    ContactComponent,
    CandidatComponent,
    AuthentificationComponent,
    SidebarComponent,
    DisplayApplicationComponent,
    DisplayInformationComponent,
    DiplayContactComponent,
    DiplayExperienceComponent,
    DiplayAppFolderComponent,   
    CreateUserComponent,
    SidebarComponent,
    UpdateApplicationComponent,
    FileSelectDirective,
    FileDropDirective,
    ConsultUserComponent,
    EvaluationComponent,
    PropalComponent,
    CreateInterviewComponent,
    UpdateInterviewComponent,
    UpdateDocumentsComponent,
    UpdateInformationsComponent,
    UpdateAppFolderComponent,
    UpdateContactComponent,
    UpdateExperienceComponent,
    UInterviewComponent,
    UPropalComponent,
    DispCandidatComponent,
    Error404Component
    

    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule, 
    FormsModule, BrowserAnimationsModule,
    RouterModule,
    CustomMaterialModule,
    CommonModule,
    ToastrModule.forRoot(), 

  ],
  providers: [FileUploadService, InterviewService,AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }



