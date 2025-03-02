import { Component, OnInit } from '@angular/core';
import { LibraryDetails } from '../../model/library-detail';
import { ActivatedRoute, Router } from '@angular/router';
import { LibrariesService } from '../../service/libraries.service';
import { Book } from '../../../books/model/book';
import { BooksService } from '../../../books/service/books.service';

@Component({
  selector: 'app-libraries-details',
  templateUrl: './libraries-details.component.html',
  styleUrl: './libraries-details.component.css'
})
export class LibrariesDetailsComponent implements OnInit{
  library: LibraryDetails | undefined;

  books: Book[] = [];

  constructor(private service: LibrariesService, private route: ActivatedRoute, private router: Router, private bookService: BooksService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getLibrary(params['uuid'])
        .subscribe(library => this.library = library);
      this.service.getBooksInLibrary(params['uuid'])
        .subscribe(books => this.books = books);
    });
  }

  onDelete(book: Book): void {
    this.bookService.deleteBook(book.id).subscribe(() => this.ngOnInit());
  }
}
