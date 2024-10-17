export interface ReservaDTO{
  id: number;
  nomeHospede: string;
  dataInicio: string;
  dataFim: string;
  valor: number;
  checkin: boolean;
  checkout: boolean;
}
