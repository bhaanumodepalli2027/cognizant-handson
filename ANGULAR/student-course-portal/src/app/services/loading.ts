import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadingService {

  // Observable to track loading state
  isLoading$ = new BehaviorSubject<boolean>(false);

  constructor() {}

  show(): void {
    setTimeout(() => {
      this.isLoading$.next(true);
    }, 0);
  }

  hide(): void {
    setTimeout(() => {
      this.isLoading$.next(false);
    }, 0);
  }

  get loading$() {
    return this.isLoading$.asObservable();
  }
}
