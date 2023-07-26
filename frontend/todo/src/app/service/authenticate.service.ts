import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor() { }

public setToken(token:any){
  localStorage.setItem('token', token);
}

public getToken(){
  return localStorage.getItem('token');
}

public isLoggedIn():boolean{
 const token= localStorage.getItem('token');
if(token!=null)
return true;
else
return false;
}
}
