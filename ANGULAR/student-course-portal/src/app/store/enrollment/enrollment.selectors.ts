import { createFeatureSelector, createSelector } from '@ngrx/store';
import { EnrollmentState } from './enrollment.reducer';
import { selectAllCourses } from '../course/course.selectors';

// Step 99: Get the enrollment feature state slice
export const selectEnrollmentState = createFeatureSelector<EnrollmentState>('enrollment');

// Select just the raw array of enrolled IDs
export const selectEnrolledIds = createSelector(
  selectEnrollmentState,
  (state) => state.enrolledCourseIds
);

// Step 99: Cross-slice selector combining course state and enrollment state
export const selectEnrolledCourses = createSelector(
  selectAllCourses,
  selectEnrolledIds,
  (courses, enrolledIds) => courses.filter((course) => enrolledIds.includes(course.id))
);