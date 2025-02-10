import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  livros = [];

  reservas = [];


  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
    this.getReservas();
    console.log("init");
    this.getLivros();
    console.log("livros init:" + this.livros);
  }

  getLivros() {
    this.taskService.livrosPaged().subscribe((response: any) => {
        this.livros = response.content;
    });
  }

  getLivroById(livroId) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
      this.reservas.push(response);
    });
  }

  getReservas() {
    this.taskService.reservaEmprestimosDevolucoesByUsuarioId().subscribe((response: any) => {
      response.map((item) => {
        if (item.situacao != "DEVOLVIDO") {
          this.getLivroById(item.livroId);
        }
      })
    });
  }

}