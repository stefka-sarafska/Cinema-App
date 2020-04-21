import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit {
@Input() cinemaName: string;
@Input() email: string;
@Input() address: string;
@Input() phone:string;
@Input() halls: string[];
@Input() projections: string[];
@Output() deleteEvent=new EventEmitter<string>();

  constructor() { }

  deleteCinema(){
    this.deleteEvent.emit(this.cinemaName);
  }

  ngOnInit(): void {
  }

}
