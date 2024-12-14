import { TestBed } from '@angular/core/testing';

import { ConsultarReservasService } from './consultar-reservas.service';

describe('ConsultarReservasService', () => {
  let service: ConsultarReservasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultarReservasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
