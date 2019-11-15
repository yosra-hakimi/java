import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor(private authService:AuthService) { }

  intercept(req, next){
    if(this.authService.loggedIn()){
    
let tokenizedReq = req.clone({
  setHeaders: {
    Authorization:  localStorage.getItem('token')
  }
});


return next.handle(tokenizedReq);
}
else return next.handle(req);
    
  }
}
