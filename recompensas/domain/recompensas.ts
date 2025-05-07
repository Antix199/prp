export interface Recompensas {
  recId: number;
  recNombre: string;
  recDescripcion: string;
  recCostoPuntos: number;
}
export interface Canje {
  recompensaNombre: string;
  recompensaDescripcion: string;
  puntosCosto: number;
  codigoCanje: string;
  fechaCanje: Date;
  estado: boolean;
}
export interface RecompensaDetalle {
  recId: number;
  recNombre: string;
  recDescripcion: string;
  recCostoPuntos: number;
}


