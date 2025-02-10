import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-editora',
  templateUrl: './editora.component.html',
  styleUrls: ['./editora.component.css']
})
export class EditoraComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];
  editoras = [];

  reservas = [];


  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
    this.getEditora();
  }

  getEditora() {
    this.taskService.editorasPaged().subscribe((response: any) => {
      this.editoras = response.content;
    });
  }

}