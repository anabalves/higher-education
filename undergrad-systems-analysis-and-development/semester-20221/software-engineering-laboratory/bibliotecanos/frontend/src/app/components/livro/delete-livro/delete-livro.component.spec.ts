import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteLivroComponent } from './delete-livro.component';

describe('DeleteLivroComponent', () => {
  let component: DeleteLivroComponent;
  let fixture: ComponentFixture<DeleteLivroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteLivroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteLivroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
