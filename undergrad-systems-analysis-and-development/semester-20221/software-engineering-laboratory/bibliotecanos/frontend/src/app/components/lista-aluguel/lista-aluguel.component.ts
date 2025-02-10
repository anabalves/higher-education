import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';


@Component({
  selector: 'app-lista-aluguel',
  templateUrl: './lista-aluguel.component.html',
  styleUrls: ['./lista-aluguel.component.css']
})
export class ListaAluguelComponent implements OnInit {

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

  getLivroById(livroId, situacao) {
    this.taskService.livrosById(livroId).subscribe((response: any) => {
      response.situacao = situacao;
      this.reservas.push(response);

    });
  }

  getReservas() {
    this.taskService.reservaEmprestimosDevolucoesByUsuarioId().subscribe((response: any) => {
      response.map((item) => {
        this.getLivroById(item.livroId, item.situacao);

      })
    });
  }
}
