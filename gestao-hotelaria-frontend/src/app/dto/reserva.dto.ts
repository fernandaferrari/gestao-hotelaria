export interface ReservaDTO{
  id?: number;
  cpf?: string;
  nomeHospede?: string;
  dataInicio: string;
  dataFim: string;
  valor?: number;
  checkin?: boolean;
  checkout?: boolean;
  estacionamento: string;
  dataHoraCheckout?: Date;
  dataHoraCheckin?: Date;
}
