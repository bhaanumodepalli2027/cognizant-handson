import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const errorHandlerInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  return next(req).pipe(
    catchError((error) => {
      // Step 90: Intercept HTTP errors globally
      if (error.status === 401) {
        console.warn('401 Unauthorized - Redirecting to Home/Login');
        router.navigate(['/']); 
      } else if (error.status === 500) {
        alert('Global Error: 500 Internal Server Error. Please try again.');
      }
      
      // Propagate the error so components can still handle it if needed
      return throwError(() => error);
    })
  );
};