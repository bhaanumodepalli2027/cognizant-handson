import { CommonModule, AsyncPipe, UpperCasePipe, CurrencyPipe, DatePipe } from '@angular/common';
import { Component, Input, OnInit, inject } from '@angular/core';
import { SummaryPipe } from '../../pipes/summary-pipe';
import { RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, SummaryPipe, RouterLink, AsyncPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnInit {
  // @Input allows data to flow DOWN from the list into this card
  @Input() course: any;

  private store = inject(Store);

  // Observable stream tracking if this specific course is enrolled in the NgRx store
  isEnrolled$!: Observable<boolean>;

  ngOnInit() {
    this.isEnrolled$ = this.store.select(selectEnrolledIds).pipe(
      map((ids) => ids.includes(this.course.id))
    );
  }

  // Toggle state via NgRx store actions (Step 100)
  toggleEnrollment(isCurrentlyEnrolled: boolean) {
    if (isCurrentlyEnrolled) {
      this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
    } else {
      this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
    }
  }
}