import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  User: any = ['Usuario', 'Bibliotecario', 'Admin'];

  constructor(private taskService: TaskService, private route: Router) { }

  registerForm = new FormGroup({
    nome: new FormControl(''),
    sobrenome: new FormControl(''),
    cpf: new FormControl(''),
    telefone: new FormControl(''),
    cep: new FormControl(''),
    endereco: new FormControl(''),
    numeroEndereco: new FormControl(''),
    complemento: new FormControl(''),
    cidade: new FormControl(''),
    estado: new FormControl(''),
    emailAlternativo: new FormControl(''),
    email: new FormControl(''),
    senha: new FormControl(''),
  });

  ngOnInit() {
  }

  register() {
    this.taskService.signUp(this.registerForm.get('nome').value, this.registerForm.get('sobrenome').value,
      this.registerForm.get('cpf').value, this.registerForm.get('telefone').value, this.registerForm.get('cep').value,
      this.registerForm.get('endereco').value, this.registerForm.get('numeroEndereco').value, this.registerForm.get('complemento').value,
      this.registerForm.get('cidade').value, this.registerForm.get('estado').value, this.registerForm.get('emailAlternativo').value,
      this.registerForm.get('email').value, this.registerForm.get('senha').value).subscribe((response: any) => {
        console.log(response);
        if (response.situacao == 'OK') {
          this.route.navigate(['/login']);
        }
      });
  }

}
