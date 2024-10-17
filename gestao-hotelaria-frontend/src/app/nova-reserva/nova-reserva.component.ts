import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-nova-reserva',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './nova-reserva.component.html',
  styleUrl: './nova-reserva.component.css'
})
export class NovaReservaComponent {

  cadastroReservaForm = new FormGroup({
    cpf: new FormControl('', [Validators.required, Validators.minLength(11)]),
    dataInicial: new FormControl('', [Validators.required]),
    dataFinal: new FormControl('', [Validators.required]),
    estacionamento: new FormControl('')
  });

  onSubmit() {
    if (this.cadastroReservaForm.valid) {
      console.log('Formulário enviado com sucesso', this.cadastroReservaForm.value);
    } else {
      console.log('Formulário inválido');
    }
  }
}
