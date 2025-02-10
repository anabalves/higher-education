import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrocarLivroComponent } from './trocar-livro.component';

describe('TrocarLivroComponent', () => {
  let component: TrocarLivroComponent;
  let fixture: ComponentFixture<TrocarLivroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrocarLivroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrocarLivroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
