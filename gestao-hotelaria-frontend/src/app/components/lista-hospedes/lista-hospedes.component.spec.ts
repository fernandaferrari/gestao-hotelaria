import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaHospedesComponent } from './lista-hospedes.component';

describe('ListaHospedesComponent', () => {
  let component: ListaHospedesComponent;
  let fixture: ComponentFixture<ListaHospedesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaHospedesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaHospedesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
