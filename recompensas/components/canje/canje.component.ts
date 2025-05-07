import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RecompensasService } from '../../services/recompensas.service';
import { Recompensas } from '../../domain/recompensas';
import {CrossOrigin} from '@angular-devkit/build-angular';


@Component({
  selector: 'app-canje',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './canje.component.html',
  styleUrls: ['./canje.component.css']
})
export class CanjeComponent implements OnInit {
  recompensa: Recompensas | null = null;
  usuId!: number;
  recId!: number;
  puntosDisponibles: number = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private recompensasService: RecompensasService
  ) {}

  ngOnInit(): void {
    this.usuId = +this.route.snapshot.paramMap.get('usuId')!;
    this.recId = +this.route.snapshot.paramMap.get('recId')!;

    this.recompensasService.obtenerRecompensaPorId(this.recId).subscribe((rec) => {
      this.recompensa = rec;
    });

    this.recompensasService.obtenerPuntosUsuario(this.usuId).subscribe((pts) => {
      this.puntosDisponibles = pts;
    });
  }

  canjear(): void {
    this.recompensasService.canjearRecompensa(this.usuId, this.recId).subscribe({
      next: () => {
        // redirige al historial
        this.router.navigate([`/recompensas/historial-puntos/${this.usuId}`]);
      },
      error: (err) => {
        alert('Error al canjear: ' + (err?.message || err));
      }
    });
  }


  get puntosRestantes(): number {
    return this.recompensa ? this.puntosDisponibles - this.recompensa.recCostoPuntos : 0;
  }
}
