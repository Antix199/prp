import { TestBed } from '@angular/core/testing';
import { RecompensasService } from './recompensas.service';

describe('RecompensaService', () => {
  let service: RecompensasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecompensasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should have obtenerHistorialCanjes method', () => {
    expect(service.obtenerHistorialCanjes).toBeDefined();
  });
});
