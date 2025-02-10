import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-trocar-livro',
  templateUrl: './trocar-livro.component.html',
  styleUrls: ['./trocar-livro.component.css']
})
export class TrocarLivroComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  livros = [
    { id: 1, titulo: "Bomdia" }
  ];

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

}
