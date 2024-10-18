import { ReservaDTO } from './../../dto/reserva.dto';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ReservaService } from '../../services/reserva.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nova-reserva',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  providers:[ReservaService],
  templateUrl: './nova-reserva.component.html',
  styleUrl: './nova-reserva.component.css'
})
export class NovaReservaComponent {
  constructor(private reservaService: ReservaService){}

  cadastroReservaForm = new FormGroup({
    cpf: new FormControl('', [Validators.required, Validators.minLength(11)]),
    dataInicial: new FormControl('', [Validators.required]),
    dataFinal: new FormControl('', [Validators.required]),
    estacionamento: new FormControl('')
  });

  onSubmit() {
    if (this.cadastroReservaForm.valid) {
      const reserva : ReservaDTO = {
        cpf: this.cadastroReservaForm.value.cpf ?? '',
        dataInicio: this.cadastroReservaForm.value.dataInicial ?? '',
        dataFim: this.cadastroReservaForm.value.dataFinal ?? '',
        estacionamento: this.cadastroReservaForm.value.estacionamento ?? ''
      }

      this.reservaService.saveReserva(reserva).subscribe(response => {
        // Lógica após o cadastro bem-sucedido
        Swal.fire({
          icon: 'success',
          title: 'Sucesso!',
          text: 'Reserva cadastrada com sucesso!'
        });
        this.cadastroReservaForm.reset();
      }, error => {
        // Lógica para tratar erros
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'Erro ao cadastrar reserva.\n' + error.message
        });
      });
    } else {
      Swal.fire({
        icon: 'warning',
        title: 'Formulário inválido',
        text: 'Por favor, preencha todos os campos obrigatórios corretamente.'
      });
    }
  }
}
