import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserService } from '../service/user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

constructor(private userService:UserService, private router:Router){}

registerUser(signupForm:NgForm){

  this.userService.signup(signupForm.value).subscribe(
    (response) =>{
      console.log(response);
      alert('User Registered');
      this.router.navigateByUrl("/");
    }
  )
}

}
