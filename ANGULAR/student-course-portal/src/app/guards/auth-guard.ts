import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  // Simulated authentication check (Set to 'true' to allow access, 'false' to block)
  const isLoggedIn = true; 

  if (isLoggedIn) {
    return true; // Grant access
  } else {
    alert('Access Denied! Please log in first.');
    router.navigate(['/']); // Redirect to home
    return false; // Block navigation
  }
};
