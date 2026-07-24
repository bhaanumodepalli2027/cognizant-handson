import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { LoadingService } from '../services/loading';
import { finalize } from 'rxjs';

export const loadingInterceptor: HttpInterceptorFn = (req, next) => {
  const loadingService = inject(LoadingService);

  // Step 91: Set loading to true before handling the request
  loadingService.show();

  return next(req).pipe(
    // finalize runs whether the request succeeds or fails
    finalize(() => {
      loadingService.hide();
    })
  );
};