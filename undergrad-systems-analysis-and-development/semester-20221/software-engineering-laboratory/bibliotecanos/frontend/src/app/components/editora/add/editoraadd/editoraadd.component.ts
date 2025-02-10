import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editoraadd',
  templateUrl: './editoraadd.component.html',
  styleUrls: ['./editoraadd.component.css']
})
export class EditoraaddComponent implements OnInit {

  idEditora;
  nome;

  constructor(private route: ActivatedRoute, private taskService: TaskService, private rota: Router) { }

  editoraForm = new FormGroup({
    nome: new FormControl(''),
  });

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idEditora = params['id'];
      this.getEditoraById(params['id']);
    });
  }

  getEditoraById(categoriaId) {
    this.taskService.editoraById(categoriaId).subscribe((response: any) => {
      this.nome = response.nome;

      this.editoraForm.setValue({
        nome: response.nome
      });
    });
  }

  adicionarEditora() {
    this.taskService.newEditora(
      this.editoraForm.get('nome').value
    ).subscribe((response: any) => {
      console.log(response);
      this.rota.navigate(['/editora']);
    });
  }

}