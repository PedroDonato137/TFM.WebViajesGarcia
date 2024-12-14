import { CestaViajes } from "./CestaViajes";

export class Reserva{
  idReserva:number;
  fecha:Date;
  status:string;
  elementosReserva:CestaViajes[];
}
