import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from 'src/app/task.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoriaadd',
  templateUrl: './categoriaadd.component.html',
  styleUrls: ['./categoriaadd.component.css']
})
export class CategoriaaddComponent implements OnInit {

  idCategoria;
  nome;

  constructor(private route: ActivatedRoute, private taskService: TaskService, private rota: Router) { }

  categoriaForm = new FormGroup({
    nome: new FormControl(''),
  });

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idCategoria = params['id'];
      this.getCategoriaById(params['id']);
    });
  }

  getCategoriaById(categoriaId) {
    this.taskService.generoById(categoriaId).subscribe((response: any) => {
      this.nome = response.nome;

      this.categoriaForm.setValue({
        nome: response.nome
      });
    });
  }

  adicionarCategoria() {
    this.taskService.newGenero(
      this.categoriaForm.get('nome').value
    ).subscribe((response: any) => {
      console.log(response);
      this.rota.navigate(['/categoria']);
    });
  }

}