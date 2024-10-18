import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ReservaDTO } from "../dto/reserva.dto";
import { HospedeDTO } from "../dto/hospede.dto";
import { CheckinDTO } from "../dto/checkin.dto";
import { DetalhePagamentoDTO } from "../dto/detalhe.pagamento";

@Injectable({ //Torna Service Global
  providedIn: 'root',
})

export class ReservaService{

  private apiUrl = 'http://localhost:8080/api/reservas/';

  constructor(private http: HttpClient) {}

  getReservas(): Observable<ReservaDTO[]> {
    return this.http.get<ReservaDTO[]>(this.apiUrl);
  }


  saveHospede(hospedeDTO : HospedeDTO): Observable<String> {
     return this.http.post('http://localhost:8080/api/hospedes/save', hospedeDTO, {responseType: 'text'});
  }

  getHospedes(): Observable<HospedeDTO[]> {
    return this.http.get<HospedeDTO[]>('http://localhost:8080/api/hospedes/');
  }

  saveReserva(reservaDTO: ReservaDTO) : Observable<String> {
    return this.http.post('http://localhost:8080/api/reservas/save', reservaDTO, {responseType: 'text'});
  }

  saveCheckin(checkinDTO: CheckinDTO) {
    return this.http.post('http://localhost:8080/api/reserva/checkin/save', checkinDTO, {responseType: 'text'});
  }

  saveCheckout(checkinDTO: CheckinDTO) {
    return this.http.post('http://localhost:8080/api/reserva/checkout/save', checkinDTO, {responseType: 'text'});
  }

  getDetalhesCheckout(idReserva : number, dataCheckout : string) {
    return this.http.get<DetalhePagamentoDTO>(
      `http://localhost:8080/api/reserva/checkout/detalhamento/${idReserva}/${encodeURIComponent(dataCheckout)}`
  );
  }
}
