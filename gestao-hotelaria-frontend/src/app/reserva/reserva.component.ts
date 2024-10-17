import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-reserva',
  standalone: true,
  imports: [],
  templateUrl: './reserva.component.html',
  styleUrl: './reserva.component.css'
})
export class ReservaComponent {
  constructor(private Router: Router) {}

  carregarTelaReserva() {
    this.Router.navigate(['/hospede']); // Navega para a rota 'about'
  }
}
