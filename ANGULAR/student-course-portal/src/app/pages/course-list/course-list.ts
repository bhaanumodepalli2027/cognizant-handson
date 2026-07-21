import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {

  selectedCourseId: number | null = null;

  courses = [
    { id:1, name:'Angular', code:'CS101', credits:4 },
    { id:2, name:'Java', code:'CS102', credits:4 },
    { id:3, name:'DBMS', code:'CS103', credits:3 },
    { id:4, name:'React', code:'CS104', credits:3 },
    { id:5, name:'Spring Boot', code:'CS105', credits:4 }
  ];

  onEnroll(id:number){

    console.log("Enrolling in course:", id);

    this.selectedCourseId=id;

  }

}
