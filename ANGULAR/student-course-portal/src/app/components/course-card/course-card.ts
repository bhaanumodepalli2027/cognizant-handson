import { CommonModule, AsyncPipe } from '@angular/common';
import { Component, Input, OnInit, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { SummaryPipe } from '../../pipes/summary-pipe';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import {
  enrollInCourse,
  unenrollFromCourse
} from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [
    CommonModule,
    AsyncPipe,
    RouterLink,
    SummaryPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnInit {

  @Input() course: any;

  private store = inject(Store);

  isEnrolled$!: Observable<boolean>;

  ngOnInit(): void {
    this.isEnrolled$ = this.store.select(selectEnrolledIds).pipe(
      map(ids => ids.includes(this.course.id))
    );
  }

  toggleEnrollment(isCurrentlyEnrolled: boolean): void {
    if (isCurrentlyEnrolled) {
      this.store.dispatch(
        unenrollFromCourse({ courseId: this.course.id })
      );
    } else {
      this.store.dispatch(
        enrollInCourse({ courseId: this.course.id })
      );
    }
  }
}
