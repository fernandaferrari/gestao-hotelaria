import { CommonModule } from '@angular/common';
import { ReservaService } from '../../services/reserva.service';
import { ReservaDTO } from '../../dto/reserva.dto';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { CheckinDTO } from '../../dto/checkin.dto';
import { error } from 'console';
import { DetalhePagamentoDTO } from '../../dto/detalhe.pagamento';

@Component({
  selector: 'app-lista-hospedes',
  standalone: true,
  templateUrl: './lista-reservas.component.html',
  providers:[ReservaService],
  imports: [CommonModule],
  styleUrl: './lista-reservas.component.css'
})
export class ListaReservasComponent implements OnInit{
  constructor(private reservaService: ReservaService){}

  reservas: ReservaDTO[] = [];
  detalhePagamento: DetalhePagamentoDTO | null = null;
  ngOnInit(): void {
    this.carregarLista();
  }

  carregarLista(){
    this.reservaService.getReservas().subscribe((data) => {
      this.reservas = data;
    });
  }

  onCheckinChange(reserva: ReservaDTO, event: Event): void {
    const target = event.target as HTMLInputElement;
    const checkin = target.checked;
    reserva.checkin = checkin;

    if(checkin){
      const dataAtual = new Date();
      const dataInicio: Date = this.converterStringParaDate(reserva.dataInicio);
      const dataInicioSemHora = new Date(dataInicio.getFullYear(), dataInicio.getMonth(), dataInicio.getDate());
      const dataAtualSemHora = new Date(dataAtual.getFullYear(), dataAtual.getMonth(), dataAtual.getDate());

      if(dataInicioSemHora > dataAtualSemHora){
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'O check-in deve ser efetuado apenas depois das 14h00.'
        }).then(() => reserva.checkin = !checkin);
      } else if (dataInicioSemHora >= new Date(dataAtual.toLocaleDateString('pt-BR')) && dataAtual.getHours() < 14) {
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'O check-in deve ser efetuado apenas depois das 14h00.'
        }).then(() => reserva.checkin = !checkin);
      }else{
        if(reserva.id){
          const checkinDTO: CheckinDTO = { idReserva: reserva.id, data: dataAtual}

          Swal.fire({
            title: 'Check-in',
            text: 'Você tem certeza? A ação não poderá ser desfeita!',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sim',
            cancelButtonText: 'Cancelar'
          }).then((result) => {
            if (result.isConfirmed) {
              this.reservaService.saveCheckin(checkinDTO).subscribe(response => {
                Swal.fire({
                  icon:'success',
                  title: 'Check-in efetuado com sucesso!'
                }).then((result => this.carregarLista()));
              }, error => {
                reserva.checkin = !checkin;
                Swal.fire({
                  icon: 'error',
                  title: 'Erro!',
                  text: 'Ocorreu um erro ao efetuar o check-in.'
                });
              });
            }
            reserva.checkin = !checkin;
          });
        }
      }
    }
  }

  onCheckoutChange(reserva: ReservaDTO, event: Event): void {
    const target = event.target as HTMLInputElement;
    const checked = target.checked;
    reserva.checkout = checked;

    if(checked){
      const currentDateTime = new Date();
      if(reserva.id){
        this.reservaService.getDetalhesCheckout(reserva.id, currentDateTime.toISOString()).subscribe((data) => {
          this.detalhePagamento = data;

          let texto = '' ;
          texto += '<br> Valor diárias: ' + this.detalhePagamento.valorDiaria;
          texto += '<br> Valor estacionamento: ' + this.detalhePagamento.valorEstacionamento;
          texto += '<br> Valor adicional checkout: ' + this.detalhePagamento.valorAdicional;
          texto += '<br> Valor total: ' + this.detalhePagamento.total;

          Swal.fire({
            title: 'Deseja fazer o checkout?',
            html: texto,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sim',
            cancelButtonText: 'Cancelar'
          }).then((result) => {
            reserva.checkout = result.isConfirmed;
            if (result.isConfirmed && reserva.id) {
              const checkoutDTO: CheckinDTO = { idReserva: reserva.id, data: currentDateTime}
              this.reservaService.saveCheckout(checkoutDTO).subscribe(response => {
                Swal.fire({
                  icon:'success',
                  title: 'Check-out efetuado com sucesso!'
                }).then((result => this.carregarLista()));
              }, error => {
                Swal.fire({
                  icon: 'error',
                  title: 'Erro!',
                  text: 'Ocorreu um erro ao efetuar o check-out.'
                });
              });
            }
          });
        });
      }
    }
  }

  converterStringParaDate(dataString: string): Date {
    // Dividir a string em partes
    const partes = dataString.split('/');
    if (partes.length !== 3) {
      throw new Error('Data inválida: ' + dataString);
    }

    // Reorganizar para yyyy-MM-dd
    const dataFormatada = `${partes[2]}-${partes[1]}-${partes[0]}T00:00:00`;

    return new Date(dataFormatada); // Cria um objeto Date
  }
}
