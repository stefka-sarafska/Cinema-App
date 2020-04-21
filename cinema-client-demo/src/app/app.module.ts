import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { AddProjectionComponent } from './add-projection/add-projection.component';
import { CinemaComponent } from './cinema/cinema.component';
import { AddCinemaComponent } from './add-cinema/add-cinema.component';
import { ProjectionComponent } from './projection/projection.component';
import { MovieComponent } from './movie/movie.component';





   

@NgModule({
  declarations: [
    AppComponent,
    AddProjectionComponent,
    CinemaComponent,
    AddCinemaComponent,
    ProjectionComponent,
    MovieComponent,
    


 
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    FormsModule,
   
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
