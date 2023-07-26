import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { NgForm } from '@angular/forms';
import { Task } from '../task.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  panelOpenState = false;
userData:any;
tasksList:any=[];

  constructor(private userService:UserService){
    this.getUser();
  }

  emptyTasks:boolean=true;

  ngOnInit(): void {
   
  }


  addTask(taskForm:NgForm){
    this.userService.addTask(taskForm.value).subscribe(
      (response:any)=>{
        console.log(response);
        this.getUser();
        
      }
)
  }

  getUser(){
    this.userService.getUser().subscribe(
      (response:any)=>{
      
      this.tasksList=response.tasks;
      if(response!=null){
        this.emptyTasks=false;
      }
      console.log(response);
      }
    )
  }

}
