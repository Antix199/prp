import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Canje } from '../../domain/recompensas';
import { RecompensasService } from '../../services/recompensas.service';

@Component({
  selector: 'app-historial-puntos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './historial-puntos.component.html',
  styleUrls: ['./historial-puntos.component.css']
})
export class HistorialPuntosComponent implements OnInit {
  canjes: Canje[] = [];

  constructor(
    private route: ActivatedRoute,
    private recompensasService: RecompensasService
  ) {}

  ngOnInit(): void {
    const usuarioId = Number(this.route.snapshot.paramMap.get('id'));
    this.recompensasService.obtenerHistorialCanjes(usuarioId).subscribe(data => {
      this.canjes = data;
    });
  }

  get totalCanjes(): number {
    return this.canjes.length;
  }

  get totalPuntos(): number {
    return this.canjes.reduce((acc, c) => acc + c.puntosCosto, 0);
  }
}
