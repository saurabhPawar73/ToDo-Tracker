import { Component } from '@angular/core';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

constructor(private auth:AuthenticateService, private route:Router){}

  public checkLogin(){
    return !this.auth.isLoggedIn();
  }

  public logout(){
    localStorage.removeItem('token');
    alert('Logged off');
 this.route.navigateByUrl("/")   
  }
}
