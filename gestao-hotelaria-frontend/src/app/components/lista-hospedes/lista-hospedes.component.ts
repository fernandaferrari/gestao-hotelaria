import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ReservaService } from '../../services/reserva.service';
import { HospedeDTO } from '../../dto/hospede.dto';

@Component({
  selector: 'app-lista-hospedes',
  standalone: true,
  providers:[ReservaService],
  imports: [CommonModule],
  templateUrl: './lista-hospedes.component.html',
  styleUrl: './lista-hospedes.component.css'
})
export class ListaHospedesComponent implements OnInit{
  constructor(private reservaService: ReservaService){}

  hospedes: HospedeDTO[] = [];

  ngOnInit(): void {
    this.reservaService.getHospedes().subscribe((data) => {
      this.hospedes = data;
    });
  }
}
