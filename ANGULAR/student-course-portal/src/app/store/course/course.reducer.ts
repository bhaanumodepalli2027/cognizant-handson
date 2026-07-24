import { createReducer, on } from '@ngrx/store';
import * as CourseActions from './course.actions';

// Step 94: Define the shape of our Course State
export interface CourseState {
  courses: any[];
  loading: boolean;
  error: string | null;
}

// Initial state before any actions run
export const initialState: CourseState = {
  courses: [],
  loading: false,
  error: null
};

// Step 94: Create the reducer handling state changes per action
export const courseReducer = createReducer(
  initialState,
  
  // When loadCourses is dispatched, set loading to true
  on(CourseActions.loadCourses, (state) => ({
    ...state,
    loading: true,
    error: null
  })),

  // When courses successfully load, store them and turn off loading
  on(CourseActions.loadCoursesSuccess, (state, { courses }) => ({
    ...state,
    courses: courses,
    loading: false
  })),

  // If loading fails, save the error message and turn off loading
  on(CourseActions.loadCoursesFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false
  }))
);