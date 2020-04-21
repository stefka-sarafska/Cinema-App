import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Projection } from './projection/projection.model';
import { Cinema } from './cinema/cinema.module';
import { Movie } from './movie/movie.module';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'cinema-client';
  
  public projections: Projection[]=[];
  public cinemas: Cinema[]=[];
  public movies: Movie[]=[];

    addProjection:boolean=false;
    addCinema:boolean=false;
  
  
    constructor(private http : HttpClient){
  
    }
    searchCinemas(){
      this.http.get<Cinema[]>('cinema/cinema').subscribe((body)=>{
        console.log("Body is "+body)
        this.cinemas=body
        console.log(this.cinemas)
      })
    }
    deleteCinema(name:string){
      console.log("Delete cinema with name "+name);
      this.http.delete<any>('api/cinema/delete/'+name).subscribe(()=>{console.log("Successful delete")});
      this.searchCinemas();
    }
    searchProjections(){
      this.http.get<Projection[]>('projection/projection').subscribe((body)=>{
        console.log("Body is "+body)
        console.log(body)
        this.projections=body
        console.log(this.projections)
      });
    }
    searchMovies(){
      this.http.get<Movie[]>('movie/movie').subscribe((body)=>{
      console.log(body)
      this.movies=body
      console.log(this.projections)
     } );
    }
    deleteMovie(name:string){
      console.log("del")
      this.http.delete<any>('api/movie/'+name).subscribe(()=>{console.log("successful delete")})
      this.searchMovies
    }
    deleteProjection(id:number){
      console.log("Delete projection with id = "+id)
      this.http.delete<any>('api/projection/id/'+id).subscribe(()=>{console.log("Successful delete")})
      this.searchProjections();
    }
    showAddProjections(){
      this.addProjection=true;
    }
    showAddCinemas(){
        this.addCinema=true;
    }

    addNewCinema(cinema:Cinema){
      console.log("adding cinema");
      const postDate={
        
          "name": cinema.cinemaName,
          "contact": {
            "email": cinema.email,
            "address": cinema.address,
            "phone": cinema.phone
          },
          "halls": [
            {
              "name": cinema.halls,
              "seats": [
                "12",
                "3c"
              ]
                    }
          ]
        }
        this.http.post<any>('api/cinema',postDate).subscribe((data:any)=>
        {
        console.log(postDate);
        this.addCinema=false;
        this.searchCinemas();
         } )
      
    }
    
  
    addNewProjection(projection:Projection){
      console.log("adding projection")
      const postDate={
        "cinema": {
         "name": projection.cinema_name
        },
        "movie": {
          "name": projection.movie_name
        },
        "projectionDate": projection.date,
        "hall": {
          "name": projection.hall_name
        }
    }
      
      this.http.post<any>('api/projection',postDate).subscribe((data:any)=>
     {
       console.log(postDate);
      this.addProjection=false;
      this.searchProjections();
      
    })
   
    }
    
 
}


