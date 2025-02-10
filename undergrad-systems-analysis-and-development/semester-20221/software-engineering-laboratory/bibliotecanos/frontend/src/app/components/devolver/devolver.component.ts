import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-devolver',
  templateUrl: './devolver.component.html',
  styleUrls: ['./devolver.component.css']
})
export class DevolverComponent implements OnInit {

  idLivro;
  usuarioId = localStorage.getItem('id');
  emprestimoId;

  constructor(private taskService: TaskService, private route: ActivatedRoute, private rota: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idLivro = params['id'];
      this.getLivroById(params['id']);
      this.getEmprestimoByUserId();
    });
  }

  getLivroById(livroId) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
    });
  }

  getEmprestimoByUserId() {
    this.taskService.reservaEmprestimosDevolucoesByUsuarioId().subscribe((response: any) => {
      for (let i = 0; i <= 10000; i++) {
        if (response[i].situacao == "EM_DIA") {
          this.emprestimoId = response[i].id;
          return;
        }
      }
      
    });
  }

  devolver() {
    this.taskService.updateDevolver(this.emprestimoId, this.usuarioId, this.idLivro).subscribe((response: any) => {
      this.rota.navigate(['/home']);
    });
  }

}
