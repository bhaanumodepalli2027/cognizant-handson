import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadingService {
  // Step 91: BehaviorSubject to hold the loading state
  isLoading$ = new BehaviorSubject<boolean>(false);

  show() {
    setTimeout(() => {
      this.isLoading$.next(true);
    }, 0);
  }

  hide() {
    setTimeout(() => {
      this.isLoading$.next(false);
    }, 0);
  }
}
