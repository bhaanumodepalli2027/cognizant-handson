import { Injectable, inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Course } from '../../services/course';
import * as CourseActions from './course.actions';
import { catchError, map, switchMap, of } from 'rxjs';

@Injectable()
export class CourseEffects {
  private actions$ = inject(Actions);
  private courseService = inject(Course);

  // Step 97: Listen for loadCourses action, call API, and dispatch Success or Failure
  loadCourses$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CourseActions.loadCourses),
      switchMap(() =>
        this.courseService.getCourses().pipe(
          map((courses) => CourseActions.loadCoursesSuccess({ courses })),
          catchError((error) => of(CourseActions.loadCoursesFailure({ error: error.message })))
        )
      )
    )
  );
}