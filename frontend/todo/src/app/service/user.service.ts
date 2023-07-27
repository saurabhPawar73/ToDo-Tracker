import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { Task } from '../task.model';

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

        public deleteTask(task:any){
          let httpHeaders=new HttpHeaders({
            'Authorization':'Bearer ' + localStorage.getItem('token')
          });
          let request={headers:httpHeaders};
          return this.httpClient.post("http://localhost:8888/taskservice/delete-task", task, request);
        }

        public getIndexOfTask(task:any){
          let httpHeaders=new HttpHeaders({
            'Authorization':'Bearer ' + localStorage.getItem('token')
          });
          let request={headers:httpHeaders};
            return this.httpClient.post("http://localhost:8888/taskservice/get-index", task, request);
        }

        public updateTask(task:any, index:number){
          let httpHeaders=new HttpHeaders({
            'Authorization':'Bearer ' + localStorage.getItem('token')
          });
          let request={headers:httpHeaders};
          return this.httpClient.post("http://localhost:8888/taskservice/update-task/"+index, request);
        }
}
