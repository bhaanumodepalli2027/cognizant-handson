import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';
import { Course } from '../../services/course';
import { FormsModule } from '@angular/forms';
import { AddCourseComponent } from '../../components/add-course/add-course';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses } from '../../store/course/course.selectors';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors'; // Import enrollment selector

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard, FormsModule, AddCourseComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  searchTerm: string = '';

  private store = inject(Store);
  public courseService = inject(Course);

  // Observables mapped to NgRx store selectors
  courses$: Observable<any[]> = this.store.select(selectAllCourses);
  enrolledIds$: Observable<(number | string)[]> = this.store.select(selectEnrolledIds);

  ngOnInit() {
    // Dispatch the action to load courses into the store on init
    this.store.dispatch(loadCourses());
  }

  // Helper method that receives the array unwrapped by the async pipe in HTML
  filterCourses(courses: any[] | null): any[] {
    if (!courses) return [];
    if (!this.searchTerm.trim()) {
      return courses;
    }
    return courses.filter(course =>
      course.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      course.code.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }

  trackByCourseId(index: number, course: any) {
    return course.id;
  }
}