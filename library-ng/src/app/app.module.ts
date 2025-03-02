import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { LibrariesListComponent } from './libraries/view/libraries-list/libraries-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LibrariesService } from './libraries/service/libraries.service';
import { BooksListComponent } from './books/view/books-list/books-list.component';
import { BooksService } from './books/service/books.service';
import { LibrariesEditComponent } from './libraries/view/libraries-edit/libraries-edit.component';
import { LibrariesDetailsComponent } from './libraries/view/libraries-details/libraries-details.component';
import { BooksDetailsComponent } from './books/view/books-details/books-details.component';
import { BooksEditComponent } from './books/view/books-edit/books-edit.component';
import { LibrariesAddComponent } from './libraries/view/libraries-add/libraries-add.component';
import { BooksAddComponent } from './books/view/books-add/books-add.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    LibrariesListComponent,
    BooksListComponent,
    LibrariesEditComponent,
    LibrariesDetailsComponent,
    BooksDetailsComponent,
    BooksEditComponent,
    LibrariesAddComponent,
    BooksAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    LibrariesService,
    BooksService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
