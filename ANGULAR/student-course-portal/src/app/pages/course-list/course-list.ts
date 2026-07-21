import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-course-list',
  standalone: true,
  templateUrl: './course-list.html',
  styleUrls: ['./course-list.css']
})
export class CourseListComponent implements OnInit {

  isLoading = true;

  constructor(private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;

      // Force Angular to update the view
      this.cdr.detectChanges();

      console.log('Loading finished:', this.isLoading);
    }, 1500);
  }
}
