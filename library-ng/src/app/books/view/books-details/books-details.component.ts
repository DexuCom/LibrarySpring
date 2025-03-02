import { Component, OnInit } from '@angular/core';
import { BookDetails } from '../../model/book-detail';
import { BooksService } from '../../service/books.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-books-details',
  templateUrl: './books-details.component.html',
  styleUrl: './books-details.component.css'
})
export class BooksDetailsComponent implements OnInit{
  book: BookDetails | undefined;

  constructor(private service: BooksService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getBook(params['uuid'])
        .subscribe(book => this.book = book)
    });
  }
}
