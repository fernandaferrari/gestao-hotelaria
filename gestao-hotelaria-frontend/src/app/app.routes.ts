import { ReservaComponent } from './components/reserva/reserva.component';
import { Routes } from '@angular/router';
import { NovaReservaComponent } from './components/nova-reserva/nova-reserva.component';
import { HospedeComponent } from './components/hospede/hospede.component';
import { ListaReservasComponent } from './components/lista-reservas/lista-reservas.component';
import { ListaHospedesComponent } from './components/lista-hospedes/lista-hospedes.component';

export const routes: Routes = [
  { path: '', redirectTo: '/reserva', pathMatch: 'full' },
  { path: 'reserva', component: ReservaComponent},
  { path: 'novoHospede', component: HospedeComponent},
  { path: 'novaReserva', component: NovaReservaComponent},
  { path: 'listaReserva', component: ListaReservasComponent},
  { path: 'listaHospede', component: ListaHospedesComponent}
];
