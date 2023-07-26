import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginComponent } from '../login/login.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private httpClient:HttpClient){}

  beURL:string="http://localhost:8080";
  
    signup(signupData:any){
      return this.httpClient.post(this.beURL+"/todo/register-user", signupData)
  }

  login(loginData:any){
  return this.httpClient.post(this.beURL+"/todo/login", loginData);
  }

  addTask(task:any){
  let httpHeaders=new HttpHeaders({
    'Authorization':'Bearer ' + localStorage.getItem('token')
  });
  let request={headers:httpHeaders};
  return this.httpClient.post("http://localhost:8888/taskservice/addTask", task, request);
  }

        getUser(){
          let httpHeaders=new HttpHeaders({
            'Authorization':'Bearer ' + localStorage.getItem('token')
          });
          let request={headers:httpHeaders};
          return this.httpClient.get("http://localhost:8888/taskservice/get-user", request);
        }
}
