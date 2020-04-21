import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  @Input() name:string;
  @Input() actors:string;
  @Input() description:string;
  @Input() format:string;
  @Input() genre:string;
  @Input() premiere:Date;
  @Output() deleteEvent=new EventEmitter<string>();

  
  constructor() { }

  deleteMovie(){
    this.deleteEvent.emit(this.name);
  }
  ngOnInit(): void {
  }

  

}
