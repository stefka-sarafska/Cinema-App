import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Cinema } from '../cinema/cinema.module';

@Component({
  selector: 'app-add-cinema',
  templateUrl: './add-cinema.component.html',
  styleUrls: ['./add-cinema.component.css']
})
export class AddCinemaComponent implements OnInit {

  cinema: Cinema={};
  cinemaName:string;
  email:string;
  address:string;
  phone:string;
  halls:string[];

  @Output() addCinema= new EventEmitter<Cinema>();
 
  constructor() { }

  ngOnInit(): void {
  }
  add(){
    console.log(this.cinema);
    this.addCinema.emit(this.cinema);
  }

}
