import { CommonModule } from '@angular/common';
import { ReservaService } from '../../services/reserva.service';
import { ReservaDTO } from './../../dto/reserva.dto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-hospedes',
  standalone: true,
  templateUrl: './lista-hospedes.component.html',
  providers:[ReservaService],
  imports: [CommonModule],
  styleUrl: './lista-hospedes.component.css'
})
export class ListaHospedesComponent implements OnInit{
  constructor(private reservaService: ReservaService){}

  reservas: ReservaDTO[] = [];
  ngOnInit(): void {
    this.reservaService.getReservas().subscribe((data) => {
      this.reservas = data;
    });
  }

  onCheckinChange(reserva: ReservaDTO, event: Event): void {
    const target = event.target as HTMLInputElement;
    const checkin = target.checked;
    reserva.checkin = checkin;
  }

  onCheckoutChange(reserva: ReservaDTO, event: Event): void {
    const target = event.target as HTMLInputElement;
    const checked = target.checked;
    reserva.checkout = checked;
  }
}
