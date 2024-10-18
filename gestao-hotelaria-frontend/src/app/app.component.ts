import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { ReservaComponent } from "./components/reserva/reserva.component";
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReservaComponent, HttpClientModule, RouterModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'gestao-hotelaria-frontend';


}
