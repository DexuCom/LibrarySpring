import { Component, OnInit } from '@angular/core';
import { BookAdd } from '../../model/book-add';
import { BooksService } from '../../service/books.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-books-add',
  templateUrl: './books-add.component.html',
  styleUrl: './books-add.component.css'
})
export class BooksAddComponent implements OnInit{

  book: BookAdd | undefined;
  original: BookAdd | undefined;

  constructor(
    private bookService: BooksService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.book = {
      title: '',
      author: '',
      pages: 0,
      library: ''
    };
    this.original = {...this.book};
  }
  
  onSubmit(): void {
    console.log(this.book);
    this.bookService.addBook(this.book!)
      .subscribe(() => this.router.navigate(['/books']));
  }
}
