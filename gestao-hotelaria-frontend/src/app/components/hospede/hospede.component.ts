import { HospedeDTO } from './../../dto/hospede.dto';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ReservaService } from '../../services/reserva.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-hospede',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  providers:[ReservaService],
  templateUrl: './hospede.component.html',
  styleUrl: './hospede.component.css'
})

export class HospedeComponent {

  constructor(private reservaService: ReservaService){}

  cadastroHospedeForm = new FormGroup({
    nome: new FormControl('', [Validators.required, Validators.minLength(3)]),
    cpf: new FormControl('', [Validators.required]),
    dataNascimento: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
  });

  onSubmit() {
    if (this.cadastroHospedeForm.valid) {
      const hospede: HospedeDTO = {
        nome: this.cadastroHospedeForm.value.nome ?? '',  // Garantindo que será string
        cpf: this.cadastroHospedeForm.value.cpf ?? '',
        dataNascimento: this.cadastroHospedeForm.value.dataNascimento ?? '',
        telefone: this.cadastroHospedeForm.value.telefone ?? ''  // Opcional
      };

      this.reservaService.saveHospede(hospede)
      .subscribe(response => {
        // Lógica após o cadastro bem-sucedido
        Swal.fire({
          icon: 'success',
          title: 'Sucesso!',
          text: 'Hóspede cadastrado com sucesso!'
        });
        this.cadastroHospedeForm.reset();
      }, error => {
        // Lógica para tratar erros
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'Erro ao cadastrar hóspede.\n' + error.message
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
