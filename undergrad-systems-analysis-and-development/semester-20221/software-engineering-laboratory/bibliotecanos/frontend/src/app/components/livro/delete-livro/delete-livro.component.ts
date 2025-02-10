import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router'

@Component({
  selector: 'app-delete-livro',
  templateUrl: './delete-livro.component.html',
  styleUrls: ['./delete-livro.component.css']
})
export class DeleteLivroComponent implements OnInit {

  idLivro;

  constructor(private taskService: TaskService, private route: ActivatedRoute, private rota: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idLivro = params['id'];
      this.getLivroById(params['id']);
    });
  }

  getLivroById(livroId) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
    });
  }


  deletar() {
    this.taskService.deleteLivro(this.idLivro).subscribe((response: any) => {
      this.rota.navigate(['/livro']);
    });
  }
}
