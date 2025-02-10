import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-livroedit',
  templateUrl: './livroedit.component.html',
  styleUrls: ['./livroedit.component.css']
})
export class LivroeditComponent implements OnInit {

  idLivro;
  titulo;
  autor;

  constructor(private route: ActivatedRoute, private taskService: TaskService, private rota: Router) { }

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

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idLivro = params['id'];
      this.getLivroById(params['id']);
    });
  }

  getLivroById(livroId) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
      this.titulo = response.titulo;
      this.autor = response.autor;

      this.livroForm.setValue({
        titulo: response.titulo,
        descricao: response.descricao,
        autor: response.autor,
        edicao: response.edicao,
        isbn: response.isbn,
        quantidade: response.quantidade,
        imgUrl: response.imgUrl,
        anoPublicacao: response.anoPublicacao,
        generoId: response.generoId,
        editoraId: response.editoraId,
      });
    });
  }

  editLivro() {
    this.taskService.updateLivro(this.idLivro,
      this.livroForm.get('titulo').value, this.livroForm.get('descricao').value, this.livroForm.get('autor').value,
      this.livroForm.get('edicao').value, this.livroForm.get('isbn').value, this.livroForm.get('quantidade').value,
      this.livroForm.get('imgUrl').value, this.livroForm.get('anoPublicacao').value, this.livroForm.get('generoId').value,
      this.livroForm.get('editoraId').value,
    ).subscribe((response: any) => {
      console.log(response);
      this.rota.navigate(['/livro']);
    });
  }

}