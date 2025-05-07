import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Recompensas } from '../../domain/recompensas';

@Component({
  selector: 'app-recompensa',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './recompensa.component.html',
  styleUrls: ['./recompensa.component.css']
})
export class RecompensaComponent {
  @Input() recompensa!: Recompensas;
  @Input() usuId!: number;
  @Output() canje = new EventEmitter<number>();

  emitirCanje(): void {
    this.canje.emit(this.recompensa.recId);
  }
}
