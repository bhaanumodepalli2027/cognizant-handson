import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Course } from '../../services/course';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './course-detail.html',
  styleUrls: ['./course-detail.css']
})
export class CourseDetail implements OnInit {
  course: any = null;
  isLoading: boolean = true;

  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private courseService = inject(Course);
  private cdr = inject(ChangeDetectorRef);

  constructor() {}

  ngOnInit() {
    // FIX: Retrieve the ID as a string to support both numeric and alphanumeric/UUID IDs from json-server
    const courseId = this.route.snapshot.paramMap.get('id');

    if (courseId) {
      this.courseService.getCourseById(courseId).subscribe({
        next: (data) => {
          this.course = data;
          this.isLoading = false;
          this.cdr.detectChanges();
        },
        error: (err) => {
          console.error('Failed to load course details:', err);
          this.isLoading = false;
          this.cdr.detectChanges();
        }
      });
    } else {
      this.isLoading = false;
      this.cdr.detectChanges();
    }
  }

  // Method to handle deletion
  onDeleteCourse() {
    if (confirm(`Are you sure you want to delete ${this.course.name}?`)) {
      this.courseService.deleteCourse(this.course.id).subscribe({
        next: () => {
          alert('Course deleted successfully from json-server!');
          this.router.navigate(['/courses']);
        },
        error: (err: any) => {
          console.error('Delete failed:', err);
          alert('Could not delete the course.');
        }
      });
    }
  }

  // Method to test PUT (Update)
  onQuickUpdate() {
    const updatedCourse = { ...this.course, gradeStatus: 'passed' };

    this.courseService.updateCourse(this.course.id, updatedCourse).subscribe({
      next: (updatedData) => {
        alert('Course updated successfully on json-server!');
        this.course = updatedData;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Update failed:', err);
        alert('Could not update the course.');
      }
    });
  }
}