import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AsyncPipe, CommonModule } from '@angular/common';
import { Header } from './components/header/header';
import { LoadingService } from './services/loading';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, AsyncPipe, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('student-course-portal');

  // Inject the service so the HTML template can read the isLoading$ BehaviorSubject
  public loadingService = inject(LoadingService); 
}