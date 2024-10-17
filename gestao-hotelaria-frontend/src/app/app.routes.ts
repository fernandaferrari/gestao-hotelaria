import { ReservaComponent } from './reserva/reserva.component';
import { Routes } from '@angular/router';
import { NovaReservaComponent } from './nova-reserva/nova-reserva.component';
import { CheckinComponent } from './checkin/checkin.component';
import { AppComponent } from './app.component';
import { BuscarReservaComponent } from './buscar-reserva/buscar-reserva.component';
import { HospedeComponent } from './hospede/hospede.component';

export const routes: Routes = [
  { path: '', redirectTo: '/reserva', pathMatch: 'full' },
  { path: 'reserva', component: ReservaComponent},
  { path: 'hospede', component: HospedeComponent},
  { path: 'novaReserva', component: NovaReservaComponent},
  { path: 'checkin', component: CheckinComponent},
  { path: 'buscarReservas', component: BuscarReservaComponent}
];
