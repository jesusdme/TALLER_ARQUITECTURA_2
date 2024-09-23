import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {
  private updateParqueaderoSource = new Subject<void>();
  updateParqueadero$ = this.updateParqueaderoSource.asObservable();

  emitUpdateParqueadero() {
    this.updateParqueaderoSource.next();
  }
}
