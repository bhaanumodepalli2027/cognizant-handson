import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { Course } from '../../services/course';

@Component({
  selector: 'app-add-course',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-course.html',
  styleUrl: './add-course.css'
})
export class AddCourseComponent {
  private courseService = inject(Course);

  courseForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    code: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z]{3}\d{3}$/)]), // e.g., CS101
    credits: new FormControl(3, [Validators.required, Validators.min(1), Validators.max(6)]),
    price: new FormControl(199.99, [Validators.required, Validators.min(1)])
  });

  get f() {
    return this.courseForm.controls;
  }

  onSubmit() {
    if (this.courseForm.valid) {
      const newCourseData = {
        // json-server auto-generates IDs automatically on POST requests!
        name: this.courseForm.value.name!,
        code: this.courseForm.value.code!,
        credits: Number(this.courseForm.value.credits),
        gradeStatus: 'pending',
        price: Number(this.courseForm.value.price),
        startDate: new Date().toISOString().split('T')[0]
      };

      // Subscribe to HTTP POST request observable
      this.courseService.addCourse(newCourseData).subscribe({
        next: (response) => {
          alert('Course added successfully to json-server!');
          this.courseForm.reset({ credits: 3, price: 199.99 });
          // Reload page to display newly fetched course from API
          window.location.reload();
        },
        error: (err) => {
          console.error('Failed to add course:', err);
          alert('Error adding course. Please ensure json-server is running on port 3000.');
        }
      });
    }
  }
}