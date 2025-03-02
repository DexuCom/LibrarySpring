import { Component, OnInit } from '@angular/core';
import { BookEdit } from '../../model/book-edit';
import { BooksService } from '../../service/books.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-books-edit',
  templateUrl: './books-edit.component.html',
  styleUrl: './books-edit.component.css'
})
export class BooksEditComponent implements OnInit {

  uuid: string | undefined;
  book: BookEdit | undefined;
  original: BookEdit | undefined;

  constructor(
    private bookService: BooksService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.bookService.getBook(params['uuid'])
        .subscribe(book => {
          this.uuid = book.id;
          this.book = {
            title: book.title,
            author: book.author,
            pages: book.pages
          };
          this.original = {...this.book};
        });
    });
  }
  
  onSubmit(): void {
    this.bookService.putBook(this.uuid!, this.book!)
      .subscribe(() => this.router.navigate(['/books']));
  }
}
