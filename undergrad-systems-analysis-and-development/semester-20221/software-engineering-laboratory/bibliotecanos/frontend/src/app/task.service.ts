import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private webReqService: WebRequestService) {
  }

  //AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH
  login(email: string, senha: string) {
    return this.webReqService.post('/api/auth/login', { email, senha })
  }

  signUp(nome: string, sobrenome: string, cpf: string, telefone: string, cep: string, endereco: string, numeroEndereco: string, complemento: string, cidade: string, estado: string, emailAlternativo: string, email: string, senha: string) {
    return this.webReqService.post('/api/auth/signup', { nome, sobrenome, cpf, telefone, cep, endereco, numeroEndereco, complemento, cidade, estado, emailAlternativo, email, senha, role: 'user' })
  }

  logout(usuarioId: string) {
    return this.webReqService.post('/api/auth/logout', { usuarioId })
  }

  refreshToken(refreshToken: string) {
    return this.webReqService.post('/api/auth/refreshtoken', { refreshToken })
  }
  //AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH -- AUTH





  //EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS
  editorasPaged() {
    return this.webReqService.get('/api/editoras?page=0&size=100')
  }

  editoraById(editoraId: string) {
    return this.webReqService.get('/api/editoras/' + editoraId)
  }

  newEditora(nome: string) {
    return this.webReqService.post('/api/editoras', { nome })
  }

  updateEditora(editoraId: string, nome: string) {
    return this.webReqService.put('/api/editoras/' + editoraId, { nome })
  }

  deleteEditora(editoraId: string) {
    return this.webReqService.delete('/api/editoras/' + editoraId)
  }
  //EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS -- EDITORAS





  //GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS
  generosPaged() {
    return this.webReqService.get('/api/generos?page=0&size=100')
  }

  generoById(generoId: string) {
    return this.webReqService.get('/api/generos/' + generoId)
  }

  newGenero(nome: string) {
    return this.webReqService.post('/api/generos', { nome })
  }

  updateGenero(generoId: string, nome: string) {
    return this.webReqService.put('/api/generos/' + generoId, { nome })
  }

  deleteGenero(generoId: string) {
    return this.webReqService.delete('/api/generos/' + generoId)
  }
  //GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS -- GENEROS


  //LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS
  livrosPaged() {
    return this.webReqService.get('/api/livros?page=0&size=100')
  }

  livrosById(livroId: string) {
    return this.webReqService.get('/api/livros/' + livroId)
  }

  newLivro(titulo: string, descricao: string, autor: string, edicao: string, isbn: string, quantidade: string, imgUrl: string, anoPublicacao: string, generoId: string, editoraId: string) {
    return this.webReqService.post('/api/livros', { titulo, descricao, autor, edicao, isbn, quantidade, imgUrl, anoPublicacao, generoId, editoraId })
  }

  updateLivro(livroId: string, titulo: string, descricao: string, autor: string, edicao: string, isbn: string, quantidade: string, imgUrl: string, anoPublicacao: string, generoId: string, editoraId: string) {
    return this.webReqService.put('/api/livros/' + livroId, { titulo, descricao, autor, edicao, isbn, quantidade, imgUrl, anoPublicacao, generoId, editoraId })
  }

  deleteLivro(livroId: string) {
    return this.webReqService.delete('/api/livros/' + livroId)
  }
  //LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS -- LIVROS





  //RESERVA -- EMPRESTIMO -- DEVOLUCAO -- RESERVA -- EMPRESTIMO -- DEVOLUCAO -- RESERVA -- EMPRESTIMO -- DEVOLUCAO
  reservaEmprestimosDevolucoesPaged() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes?page=0&size=100')
  }

  reservaEmprestimosDevolucoesById(reservaEmprestimoId: string) {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/' + reservaEmprestimoId)
  }

  reservaEmprestimosDevolucoesByUsuarioId() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/usuario/' + localStorage.getItem('id'))
  }

  newEmprestimo(usuarioId: string, livroId: string) {
    return this.webReqService.post('/api/reserva-emprestimos-devolucoes/emprestar', { usuarioId, livroId })
  }

  newReserva(usuarioId: string, livroId: string) {
    return this.webReqService.post('/api/reserva-emprestimos-devolucoes/reservar', { usuarioId, livroId })
  }

  updateDevolver(reservaEmprestimoId: string, usuarioId: string, livroId: string) {
    return this.webReqService.put('/api/reserva-emprestimos-devolucoes/devolver/' + reservaEmprestimoId, { usuarioId, livroId })
  }

  updateCancelar(reservaEmprestimoId: string, usuarioId: string, livroId: string) {
    return this.webReqService.put('/api/reserva-emprestimos-devolucoes/cancelar/' + reservaEmprestimoId, { usuarioId, livroId })
  }
  //RESERVA -- EMPRESTIMO -- DEVOLUCAO -- RESERVA -- EMPRESTIMO -- DEVOLUCAO -- RESERVA -- EMPRESTIMO -- DEVOLUCAO





  //USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS
  usuariosPaged() {
    return this.webReqService.get('/api/usuarios?page=0&size=100')
  }

  usuariosById(usuarioId: string) {
    return this.webReqService.get('/api/usuarios/' + usuarioId)
  }

  updateRole(usuarioId: string, role: string) {
    return this.webReqService.put('/api/usuarios/update-role/' + usuarioId, { role })
  }

  updateSenha(usuarioId: string, senha: string) {
    return this.webReqService.put('/api/usuarios/update-senha/' + usuarioId, { senha })
  }

  updateUsuario(usuarioId: string, nome: string, sobrenome: string, cpf: string, telefone: string, cep: string, endereco: string, numeroEndereco: string, complemento: string, cidade: string, estado: string, emailAlternativo: string, email: string, senha: string) {
    return this.webReqService.put('/api/usuarios/' + usuarioId, { nome, sobrenome, cpf, telefone, cep, endereco, numeroEndereco, complemento, cidade, estado, emailAlternativo, email, senha })
  }
  //USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS -- USUARIOS





  //RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS
  relatorioEmprestimos() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/relatorio-emprestimos')
  }

  relatorioAcervo() {
    return this.webReqService.get('/api/livros/relatorio-acervo')
  }

  relatorioSaida() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/relatorio-saida')
  }

  relatorioUsuarios() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/relatorio-usuarios')
  }

  relatorioAtrasos() {
    return this.webReqService.get('/api/reserva-emprestimos-devolucoes/relatorio-atrasos')
  }
  //RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS -- RELATORIOS


}
