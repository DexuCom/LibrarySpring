import { Component, OnInit } from '@angular/core';
import { BooksService } from '../../service/books.service';
import { Book } from '../../model/book';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrl: './books-list.component.css'
})
export class BooksListComponent implements OnInit{

  constructor(private service: BooksService) {}

  books: Book[] = [];

  ngOnInit(): void {
    this.service.getBooks().subscribe((books) => this.books = books);
  }

  onDelete(book: Book): void {
    this.service.deleteBook(book.id).subscribe(() => this.ngOnInit());
  }
}
