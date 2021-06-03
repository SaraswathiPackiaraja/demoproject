import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {
 
  private _url: string ="http://localhost:8081/user/";
  constructor(private http: HttpClient) { }

  registerNewUser(data: any): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
        
      })
    };
    return this.http.post(this._url+"adduser", data, httpOptions)
  }
  authenticateUser(data: any): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
        
      })
    };
    return this.http.post(this._url+"validateUser", data, httpOptions)
  }

  

  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;

  }

  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }
}