import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservar',
  templateUrl: './reservar.component.html',
  styleUrls: ['./reservar.component.css']
})
export class ReservarComponent implements OnInit {

  titulo;
  autor;
  livroId;
  usuarioId = localStorage.getItem('id');

  constructor(private taskService: TaskService, private route: ActivatedRoute, private rota: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.livroId = params['id'];
      this.getLivroById(params['id']);
    });
  }

  getLivroById(livroId) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
      this.titulo = response.titulo;
      this.autor = response.autor;
    });
  }

  makeReserva() {
    this.taskService.newEmprestimo(this.usuarioId, this.livroId).subscribe((response: any) => {
      this.rota.navigate(['/sucesso']);
    });
  }

  

}
