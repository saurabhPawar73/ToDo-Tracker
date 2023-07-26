import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private userService:UserService, private authenticate:AuthenticateService, private router:Router){
  }

  public login(loginForm:NgForm){  
    this.userService.login(loginForm.value).subscribe(
      (response:any) => {
        console.log(response);
        this.authenticate.setToken(response.token);
        if(response.token!=null){
          alert('Login Success');
            this.router.navigateByUrl("/home");
        }
        else
        alert('No token found');
      }
    )
  }

}
