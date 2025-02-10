import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-relatorios',
  templateUrl: './relatorios.component.html',
  styleUrls: ['./relatorios.component.css']
})
export class RelatoriosComponent implements OnInit {

  emprestimos = [];
  acervos = [];
  saidas = [];
  usuarios = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.getRelatorioEmprestimos();
    this.getRelatorioAcervos();
    this.getRelatorioSaidas();
    this.getRelatorioUsuarios();
  }

  getRelatorioEmprestimos() {
    this.taskService.relatorioEmprestimos().subscribe((response: any) => {
      this.emprestimos = response;
    });
  }

  getRelatorioAcervos() {
    this.taskService.relatorioAcervo().subscribe((response: any) => {
      this.acervos = response;
    });
  }

  getRelatorioSaidas() {
    this.taskService.relatorioSaida().subscribe((response: any) => {
      this.saidas = response;
    });
  }

  getRelatorioUsuarios() {
    this.taskService.relatorioUsuarios().subscribe((response: any) => {
      this.usuarios = response;
    });
  }

  imprimir() {
    window.print();
  }

}
