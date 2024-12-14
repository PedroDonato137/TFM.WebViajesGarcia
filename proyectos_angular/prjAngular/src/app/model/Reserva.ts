import { CestaViajes } from "./CestaViajes";

export class Reserva{
  idUsuario:Int16Array;
  fecha:Date;
  status:string;
  elementosReserva:CestaViajes[];
}
