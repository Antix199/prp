import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RecompensasService } from '../services/recompensas.service';
import { Recompensas } from '../domain/recompensas';
import { RecompensaComponent } from '../components/recompensa/recompensa.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recompensas-page',
  standalone: true,
  imports: [CommonModule, RecompensaComponent],
  template: `
    <h2>Recompensas Disponibles</h2>
    <p *ngIf="puntosUsuario !== null">Tus puntos: {{ puntosUsuario }}</p>

    <div *ngIf="recompensas.length === 0">Cargando...</div>

    <app-recompensa
      *ngFor="let r of recompensas"
      [recompensa]="r"
      [usuId]="usuId"
      (canje)="redirigirACanje(r.recId)">
    </app-recompensa>
  `,
  styles: [`
    .container {
      padding: 20px;
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      gap: 1rem;
    }
  `]
})
export class RecompensasPage implements OnInit {
  recompensas: Recompensas[] = [];
  puntosUsuario: number | null = null;
  usuId: number = 0;

  constructor(
    private recompensaService: RecompensasService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.usuId = +params['usuId'];

      this.recompensaService.obtenerRecompensas().subscribe(data => {
        this.recompensas = data;
      });

      this.recompensaService.obtenerPuntosUsuario(this.usuId).subscribe(puntos => {
        this.puntosUsuario = puntos;
      });
    });
  }

  redirigirACanje(recId: number): void {
    this.router.navigate(['/recompensas/canjear', this.usuId, recId]);
  }
}
