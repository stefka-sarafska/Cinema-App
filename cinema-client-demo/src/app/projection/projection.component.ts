import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';



@Component({
  selector: 'app-projection',
  templateUrl: './projection.component.html',
  styleUrls: ['./projection.component.css']

})
export class ProjectionComponent implements OnInit {
@Input() projectId:number;
@Input() cinema_name: string;
@Input() movie_name:string;
@Input() hall_name:string;
@Input() date:Date;
@Output() deleteEvent=new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }
  deleteProjection(){
    this.deleteEvent.emit(this.projectId);
  }

}
