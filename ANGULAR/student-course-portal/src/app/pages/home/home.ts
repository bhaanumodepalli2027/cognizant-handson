import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit, OnDestroy{

  // 1. A simple string variable
  portalName = 'Student Course Portal';
  
  // 2. A boolean variable to control a button
  isPortalActive = true;
  
  // 3. A variable to hold a message
  message = '';
  
  // 4. A variable for our search box
  searchTerm = '';

  // 5. A method (function) that runs when a button is clicked
  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }

  // 1. ngOnInit: Runs ONCE when the component is first created.
  // Great for fetching data from a server!
  ngOnInit() {
    console.log('HomeComponent initialised - courses loaded');
  }

  // 2. ngOnDestroy: Runs ONCE right before the component is removed from the screen.
  // Great for cleaning up memory to prevent your app from slowing down!
  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }
}
