import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { CourseDetail } from './pages/course-detail/course-detail';
import { StudentProfile } from './pages/student-profile/student-profile';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
    { path: '', component: Home },
    { path: 'courses', component: CourseList },
    { path: 'courses/:id', component: CourseDetail },
    { path: 'profile', component: StudentProfile, 
    canActivate: [authGuard] // 2. Protect the profile page!
  },
  { path: '**', redirectTo: '' } // 3. Wildcard redirect for invalid URLs
];

