import { Component, OnInit, ViewChild } from '@angular/core';
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
task:Task ={
  taskName: '',
  taskDescription: ''};

  isNewTask:boolean=false;
  index:number=-1;


  constructor(private userService:UserService){
    this.getUser();
  }

  emptyTasks:boolean=true;

  ngOnInit(): void {
  }
  @ViewChild('addButton') addButton: any;
  @ViewChild('updateButton') updateButton: any;

  onFormSubmit(taskForm:NgForm) {
    // Check which button was clicked
    if (this.addButton?.clicked) {
      this.addTask(taskForm.value);
    } else if (this.updateButton?.clicked) {
      this.updateTask(taskForm.value);
    }
  }

  addTask(taskForm:NgForm){

  this.userService.addTask(taskForm.value).subscribe(
    (response:any)=>{
      console.log(response);
      
      taskForm.reset();
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

  deleteTask(task:any){
    this.userService.deleteTask(task).subscribe(
      (response)=>{
        console.log(response);
        this.getUser();
      }
    )
  }

  public populateFormWithData(taskObj:any){
    this.task=taskObj;
    this.userService.getIndexOfTask(taskObj).subscribe(
(response:any)=>{
  console.log(response);
  this.index=response;
}
    )
    
  }

  public updateTask(task:any){

    this.userService.updateTask(task, this.index).subscribe(
      (response)=>{
        console.log(response);
        this.getUser();
      }
    )
  }


  isFormPopulated(): boolean {
    return this.task.taskName.trim() !== '' && this.task.taskDescription.trim() !== '';
  }
}
