import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninComponent } from './components/signin/signin.component';
import { RegisterComponent } from './components/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AngularMaterialModule } from './angular-material.module';
import { FlexLayoutModule } from "@angular/flex-layout";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LandingComponent } from './components/landing/landing.component';
import { HomeComponent } from './components/home/home.component';
import { ConsultarLivroComponent } from './components/consultar-livro/consultar-livro.component';
import { ReservarComponent } from './components/reservar/reservar.component';
import { SucessoComponent } from './components/sucesso/sucesso.component';
import { RegisterLivroComponent } from './components/register-livro/register-livro.component';
import { TokenInterceptor } from './token.interceptor';
import { ListaAluguelComponent } from './components/lista-aluguel/lista-aluguel.component'
import { HomeAdminComponent } from './components/home-admin/home-admin.component'
import { LivroComponent } from './components/livro/livro.component'
import { CategoriaComponent } from './components/categoria/categoria.component'
import { EditoraComponent } from './components/editora/editora.component'
import { LivroeditComponent } from './components/livro/edit/livroedit/livroedit.component'
import { CategoriaeditComponent } from './components/categoria/edit/categoriaedit/categoriaedit.component'
import { CategoriaaddComponent } from './components/categoria/add/categoriaadd/categoriaadd.component'
import { EditoraaddComponent } from './components/editora/add/editoraadd/editoraadd.component'
import { EditoraeditComponent } from './components/editora/edit/editoraedit/editoraedit.component'
import { DevolverComponent } from './components/devolver/devolver.component'
import { TrocarLivroComponent } from './components/trocar-livro/trocar-livro.component';
import { DeleteLivroComponent } from './components/livro/delete-livro/delete-livro.component';
import { RelatoriosComponent } from './components/relatorios/relatorios.component';

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    RegisterComponent,
    LandingComponent,
    RegisterComponent,
    HomeComponent,
    ConsultarLivroComponent,
    HomeAdminComponent,
    ListaAluguelComponent,
    ReservarComponent,
    SucessoComponent,
    RegisterLivroComponent,
    LivroComponent,
    CategoriaComponent,
    EditoraComponent,
    LivroeditComponent,
    CategoriaeditComponent,
    CategoriaaddComponent,
    EditoraaddComponent,
    EditoraeditComponent,
    DevolverComponent,
    TrocarLivroComponent,
    DeleteLivroComponent,
    RelatoriosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class AppModule { }