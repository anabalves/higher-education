import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register-livro',
  templateUrl: './register-livro.component.html',
  styleUrls: ['./register-livro.component.css']
})


export class RegisterLivroComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];

  constructor(private taskService: TaskService, private route: Router) { }

  livroForm = new FormGroup({
    titulo: new FormControl(''),
    descricao: new FormControl(''),
    autor: new FormControl(''),
    edicao: new FormControl(''),
    isbn: new FormControl(''),
    quantidade: new FormControl(''),
    imgUrl: new FormControl(''),
    anoPublicacao: new FormControl(''),
    generoId: new FormControl(''),
    editoraId: new FormControl(''),
  });

  ngOnInit() {
  }

  registerLivro() {
    this.taskService.newLivro(
      this.livroForm.get('titulo').value, this.livroForm.get('descricao').value, this.livroForm.get('autor').value,
      this.livroForm.get('edicao').value, this.livroForm.get('isbn').value, this.livroForm.get('quantidade').value,
      this.livroForm.get('imgUrl').value, this.livroForm.get('anoPublicacao').value, this.livroForm.get('generoId').value,
      this.livroForm.get('editoraId').value,
    ).subscribe((response: any) => {
      console.log(response);
      this.route.navigate(['/home-admin']);
    });
  }

}
