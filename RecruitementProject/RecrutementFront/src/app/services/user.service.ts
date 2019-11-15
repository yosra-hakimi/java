import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpHandler, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { User } from '../models/User';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users: User[] = [];
  constructor(private http: HttpClient) { }


  // Add User
  addUser(user: User): Observable<any> {
    this.users.push(user);
    return this.http.post("http://localhost:8080/users", user, { observe: 'response' })
      .pipe(
        catchError(this.handleError('addUser', user))
      );
  }


  getUsersApi() {
    this.getAllUsers().subscribe(users => {
      users.forEach(user => this.users.push(user));
    })
  }

  getAllUser(): User[] {
    if (this.users.length == 0)
      this.getUsersApi();
    return this.users;
  }

  // update User
  updateUser(user: any): Observable<any> {
    return this.http.post("http://localhost:8080/users/user", user)
      .pipe(
        catchError(this.handleError('updateUser', user))
      );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
  //Get All Profiles
  getAllProfiles(): Observable<any> {
    return this.http.get('http://localhost:8080/profiles');
  }
  //Get All Users 
  getAllUsers() {
    return this.http.get<User[]>('http://localhost:8080/users');
  }

  deleteUserByMail(mail): Observable<any> {
    return this.http.delete('http://localhost:8080/users' + mail)
  }
  GetUserByMail(mail): Observable<any> {
    return this.http.get('http://localhost:8080/users/' + mail)
  }

}
