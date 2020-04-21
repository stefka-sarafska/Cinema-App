import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Projection } from '../projection/projection.model';


@Component({
  selector: 'app-add-projection',
  templateUrl: './add-projection.component.html',
  styleUrls: ['./add-projection.component.css']
})
export class AddProjectionComponent implements OnInit {
projection: Projection={};
 cinema_name: string;
 movie_name: string;
 hall_name: string;
 date: Date;

 @Output() addProjection= new EventEmitter<Projection>();
 
  constructor() { }

  ngOnInit(): void {
  }
  add(){
    console.log(this.projection);
    this.addProjection.emit(this.projection);
  }

}
