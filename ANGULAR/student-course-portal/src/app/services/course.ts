import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class Course {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:3000/courses';

  private enrolledCourseIds: (number | string)[] = [];

  // GET all courses with RxJS Operators (Hands-On 8, Task 2)
  getCourses(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      retry(2), // Step 86: Retry failed requests up to 2 times
      tap(courses => console.log('Courses loaded via tap:', courses.length)), // Step 85: Side effect logging
      map(courses => courses.filter(c => c.credits > 0)), // Step 83: Filter out any 0-credit courses
      catchError(err => {
        // Step 84: Graceful error handling
        console.error('Error caught in service:', err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number | string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  addCourse(newCourse: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, newCourse);
  }

  // Step 82: PUT (Update an existing course)
  updateCourse(id: number | string, updatedCourse: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, updatedCourse);
  }

  // Step 82: DELETE (Remove a course)
  deleteCourse(id: number | string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }

  // Enrollment actions
  enrollInCourse(courseId: number | string): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  isEnrolled(courseId: number | string): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCount(): number {
    return this.enrolledCourseIds.length;
  }
}