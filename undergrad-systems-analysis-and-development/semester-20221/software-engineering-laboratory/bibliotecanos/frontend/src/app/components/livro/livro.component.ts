import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-livro',
  templateUrl: './livro.component.html',
  styleUrls: ['./livro.component.css']
})
export class LivroComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  livros = [
    { id: 1, titulo: "Bomdia" }
  ];

  reservas = [];


  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
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

}