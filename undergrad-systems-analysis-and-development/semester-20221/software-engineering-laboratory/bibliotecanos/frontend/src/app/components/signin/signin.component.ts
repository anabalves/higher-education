import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private taskService: TaskService, private route: Router) { }

  loginForm = new FormGroup({
    email: new FormControl(''),
    senha: new FormControl(''),
  });


  ngOnInit(): void {
  }
  //email: string, senha: string
  login() {
    this.taskService.login(this.loginForm.get('email').value, this.loginForm.get('senha').value).subscribe((response: any) => {
      console.log(response);
      if (response.situacao == 'OK') {
        localStorage.setItem('token', response.token);
        localStorage.setItem('id', response.id);
        localStorage.setItem('role', response.roles[0]);
        if (response.roles[0] == 'ROLE_BIBLIOTECARIO') {
          this.route.navigate(['/home-admin']);
        } else {
          this.route.navigate(['/home']);
        }
      }
    });
  }
}
