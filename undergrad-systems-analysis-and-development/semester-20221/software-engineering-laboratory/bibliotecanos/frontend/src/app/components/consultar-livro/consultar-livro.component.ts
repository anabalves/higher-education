import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-consultar-livro',
  templateUrl: './consultar-livro.component.html',
  styleUrls: ['./consultar-livro.component.css']
})
export class ConsultarLivroComponent implements OnInit {

  idLivro;
  titulo;
  autor;

  constructor(private route: ActivatedRoute, private taskService: TaskService) { }

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
    });
  }

}