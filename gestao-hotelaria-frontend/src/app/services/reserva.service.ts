import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ReservaDTO } from "../dto/reserva.dto";
import { HospedeDTO } from "../dto/hospede.dto";

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
}
