import { Injectable, inject } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {loginTypeObj} from '../../models/types/login-type';
import {catchError, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  httpClient: HttpClient = inject(HttpClient);

  login (loginBody: loginTypeObj) {
    return this.httpClient.post("http://localhost:8080/user/login", loginBody).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err)
      })
    );
  }

}


















