import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrariesListComponent } from "./libraries/view/libraries-list/libraries-list.component";
import { BooksListComponent } from './books/view/books-list/books-list.component';
import { LibrariesEditComponent } from './libraries/view/libraries-edit/libraries-edit.component';
import { LibrariesDetailsComponent } from './libraries/view/libraries-details/libraries-details.component';
import { BooksEditComponent } from './books/view/books-edit/books-edit.component';
import { BooksDetailsComponent } from './books/view/books-details/books-details.component';
import { LibrariesAddComponent } from './libraries/view/libraries-add/libraries-add.component';
import { BooksAddComponent } from './books/view/books-add/books-add.component';

const routes: Routes = [
  {
    component: LibrariesListComponent,
    path: "libraries"
  },
  {
    component: LibrariesAddComponent,
    path: "libraries/add"
  },
  {
    component: LibrariesEditComponent,
    path: "libraries/:uuid/edit"
  },
  {
    component: LibrariesDetailsComponent,
    path: "libraries/:uuid"
  },
  {
    component: BooksListComponent,
    path: "books"
  },
  {
    component: BooksAddComponent,
    path: "books/add"
  },
  {
    component: BooksEditComponent,
    path: "books/:uuid/edit"
  },
  {
    component: BooksDetailsComponent,
    path: "books/:uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
