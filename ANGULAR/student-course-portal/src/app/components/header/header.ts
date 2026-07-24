import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Course } from '../../services/course';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  // Dependency Injection: Inject CourseService
  public courseService = inject(Course);
}
