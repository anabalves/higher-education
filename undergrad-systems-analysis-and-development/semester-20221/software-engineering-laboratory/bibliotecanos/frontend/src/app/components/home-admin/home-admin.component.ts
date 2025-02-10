import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  livros = [
    { id: 1, titulo: "Bomdia" }
  ];

  reservas = [];


  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
    this.getReservas()
    this.getLivros();
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