import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { ReservaService } from '../../services/reserva.service';

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
    this.Router.navigate(['/novoHospede']); // Navega para a rota 'about'
  }
}
