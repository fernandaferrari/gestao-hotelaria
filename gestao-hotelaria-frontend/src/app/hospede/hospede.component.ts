import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-hospede',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './hospede.component.html',
  styleUrl: './hospede.component.css'
})

export class HospedeComponent {

  constructor(private http: HttpClient) {}

  cadastroHospedeForm = new FormGroup({
    nome: new FormControl('', [Validators.required, Validators.minLength(3)]),
    cpf: new FormControl('', [Validators.required]),
    dataNascimento: new FormControl('', [Validators.required]),
    telefone: new FormControl('', [Validators.required]),
  });

  onSubmit() {
    if (this.cadastroHospedeForm.valid) {
      this.http.post('http://localhost:8080/api/hospedes/save', this.cadastroHospedeForm.value)
      .subscribe(response => {
        // Lógica após o cadastro bem-sucedido
        console.log('Hóspede cadastrado com sucesso!', response);
      }, error => {
        // Lógica para tratar erros
        console.error('Erro ao cadastrar hóspede:', error);
      });
    } else {
      console.log('Formulário inválido');
    }
  }
}
