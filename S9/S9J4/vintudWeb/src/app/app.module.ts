import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { AnnouncesComponent } from './announcement/announces/announces.component';
import { CreateAnnounceComponent } from './announcement/create-announce/create-announce.component';
import { HeaderComponent } from './header/header.component';
import { AuthServiceService } from './services/auth-service.service';
import { AnnouncementServiceService } from './services/announcement-service.service';
import { AuthGuardService } from './services/auth-guard.service';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {  RouterModule,Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'auth/signup', component: SignupComponent },
  { path: 'auth/signin', component: SigninComponent },
  { path: 'announces', component: AnnouncesComponent },
  { path: 'announces/new', component:CreateAnnounceComponent },
  { path: '', redirectTo: 'auth/signin', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth/signin' }
];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    SigninComponent,
    AnnouncesComponent,
    CreateAnnounceComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    AuthServiceService,
    AnnouncementServiceService,
    AuthGuardService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
