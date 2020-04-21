import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';



@Component({
  selector: 'app-projection',
  templateUrl: './projection.component.html',
  styleUrls: ['./projection.component.css']
})
export class ProjectionComponent implements OnInit { 

  @Input() projectionId: number;
  @Input() cinemaName: string;
  @Input() movieName: string;
  @Input() hallName: string;
  @Input() date: Date;
  @Output() deleteEvent=new EventEmitter<number>();

deleteProjection(){
  this.deleteEvent.emit(this.projectionId)
}


constructor() { }

ngOnInit(): void {
  
}

}
