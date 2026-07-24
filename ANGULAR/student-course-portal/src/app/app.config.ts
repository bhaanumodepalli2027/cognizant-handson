import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { provideEffects } from '@ngrx/effects'; // 1. Import provideEffects

import { routes } from './app.routes';
import { errorHandlerInterceptor } from './interceptors/error-handler-interceptor';
import { loadingInterceptor } from './interceptors/loading-interceptor';
import { authInterceptor } from './interceptors/auth-interceptor';
import { courseReducer } from './store/course/course.reducer';
import { enrollmentReducer } from './store/enrollment/enrollment.reducer';
import { CourseEffects } from './store/course/course.effects'; // 2. Import CourseEffects

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    provideHttpClient(
      withInterceptors([
        authInterceptor,
        loadingInterceptor,
        errorHandlerInterceptor
      ])
    ),
    provideStore({
      course: courseReducer,
      enrollment: enrollmentReducer
    }),
    // 3. Register CourseEffects so async API actions work (Step 97)[cite: 1]
    provideEffects([CourseEffects]),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: false
    })
  ]
};