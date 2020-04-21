import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Movie } from '../movie/movie.module';
import { MovieComponent } from '../movie/movie.component';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  movie: Movie = {};
  name?: string;
  actors?: string;
  description?: string;
  format?: string;
  genre?: string;
  premiere?: Date;
  @Output() addMovie=new EventEmitter<Movie>();
  constructor() { }

  add() {
    console.log(this.movie)
    this.addMovie.emit(this.movie);
  }

  ngOnInit(): void {
  }

}
