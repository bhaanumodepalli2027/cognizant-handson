import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CourseState } from './course.reducer';

// Step 95: Get the feature state slice from the root store
export const selectCourseState = createFeatureSelector<CourseState>('course');

// Step 95: Select individual pieces of data
export const selectAllCourses = createSelector(
  selectCourseState,
  (state) => state.courses
);

export const selectCoursesLoading = createSelector(
  selectCourseState,
  (state) => state.loading
);

export const selectCoursesError = createSelector(
  selectCourseState,
  (state) => state.error
);