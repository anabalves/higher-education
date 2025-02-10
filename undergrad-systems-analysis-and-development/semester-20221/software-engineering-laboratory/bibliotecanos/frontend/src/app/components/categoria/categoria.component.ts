import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  categorias = [];

  reservas = [];


  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
    this.getCategoria();
  }

  getCategoria() {
    this.taskService.generosPaged().subscribe((response: any) => {
      this.categorias = response.content;
    });
  }

}